import java.util.ArrayList;
public class Main {
    public static void runGame(Player p1, Player p2, UserInterface frame) {
        boolean p1Turn = true;

        frame.gameScreen();
        while (true) {
            if (p1Turn) {
                if (!p1.checkSlots()) {
                    break;
                }
                runTurn(p1, p2, frame);
                p1Turn = false;
            } else {
                if (!p2.checkSlots()) {
                    break;
                }
                runTurn(p2, p1, frame);
                p1Turn = true;
            }
        }
    }
    public static void runTurn(Player p1, Player p2, UserInterface frame) {
        //Add Ability
        p1.deckDraw();
        frame.update(p1, p2);
        while (frame.getLastClick() > 5 || frame.getLastClick() < 4) {
            //frame.update(p1, p2);
        }
        Ability abil = p1.getHand(frame.getLastClick() - 4);
        frame.setLastClick(7);

        while (frame.getLastClick() > 3) {
            //frame.update(p1, p2);
        }
        p1.addAbility(frame.getLastClick(), abil);
        frame.setLastClick(7);
        p1.deckReset(abil);
        frame.update(p1, p2);
        
        //Add Energy
        for (int i = 0; i < 4; i++) {
            while (frame.getLastClick() > 3) {
                //frame.update(p1, p2);
            }
            p1.addEnergy(frame.getLastClick());
            frame.setLastClick(7);
            frame.update(p1, p2);
        }

        //Add Active
        while (frame.getLastClick() > 3) {
            //frame.update(p1, p2);
        }
        p1.setActive(frame.getLastClick());
        frame.setLastClick(7);
        frame.update(p1, p2);

        //Do Attack
        ArrayList<Ability> activeAbils = p1.getActive().getAbilities();
        int highCost = 0;
        int highIndex = -1;
        for (int i = 0; i < activeAbils.size(); i++) {
            if (activeAbils.get(i).getAttackCost() >= highCost) {
                highIndex = i;
            }
        }
        if (highIndex >= 0) {
            Player.doAttack(p1, highIndex, p2);
        }
    }
    public static void main (String[] args) {
        UserInterface frame = new UserInterface();
        frame.gameScreen();

        ArrayList<Ability> abils = new ArrayList<Ability>();
        Ability a = new Ability("Fireball", "test", 3, 1);
        Ability aa = new Ability("Heal", "test", -4, 2);
        abils.add(a);
        abils.add(aa);
        abils.add(aa);
        abils.add(a);
        ArrayList<Ability> abilsa = new ArrayList<Ability>();
        abilsa.add(a);
        abilsa.add(aa);
        abilsa.add(aa);
        abilsa.add(aa);
        ArrayList<Ability> abilsb = new ArrayList<Ability>();
        abilsb.add(a);
        abilsb.add(aa);
        Person p = new Person("p", "test", 3, abilsb, 3);
        Person pa = new Person("knight", "test", 7, abilsa, 0);
        Person[] persons = {new Person("0", "", 3, new ArrayList<Ability>(), 30),new Person("1", "", 3, new ArrayList<Ability>(), 25),pa, p};
        Player p1 = new Player(abils, persons);
        Player p2 = p1;
        frame.update(p1, p2);

        runGame(p1, p2, frame);
    }
}
