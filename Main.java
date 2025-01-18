import java.util.ArrayList;

public class Main {
    static final Ability heal = new Ability("Heal", "", -3, 2);
    static final Ability slash = new Ability("Slash", "", 2, 1);
    static final Ability kick = new Ability("Kick", "", 1, 1);
    static final Ability feast = new Ability("Feast" , "", -7, 8);
    static final Ability stab = new Ability("Stab", "", 3, 2);
    static final Ability charge = new Ability("Charge", "", 5, 6);
    static final Ability fireball = new Ability("Fireball", "", 10, 13);
    static final Person king = new Person("King", "", 0, new ArrayList<Ability>(), 8);
    //king.addAbility(feast);
    static final Person queen = new Person("Queen", "", 0, new ArrayList<Ability>(), 10);
    //queen.addAbility(charge);
    static final Person knight = new Person("Knight", "", 0, new ArrayList<Ability>(), 15);
    //knight.addAbility(stab);
    static final Person princess = new Person("Princess", "", 0, new ArrayList<Ability>(), 12);
    //princess.addAbility(stab);

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
            frame.update(p1, p2);
        }
        Ability abil = p1.getHand(frame.getLastClick() - 4);
        frame.setLastClick(7);

        while (frame.getLastClick() > 3) {
            frame.update(p1, p2);
        }
        p1.addAbility(frame.getLastClick(), abil);
        frame.setLastClick(7);
        p1.deckReset(abil);
        frame.update(p1, p2);

        //Add Energy
        for (int i = 0; i < 4; i++) {
            while (frame.getLastClick() > 3) {
                frame.update(p1, p2);
            }
            p1.addEnergy(frame.getLastClick());
            frame.setLastClick(7);
            frame.update(p1, p2);
        }

        //Add Active
        while (frame.getLastClick() > 3) {
            frame.update(p1, p2);
        }
        p1.setActive(frame.getLastClick());
        frame.setLastClick(7);
        frame.update(p1, p2);

        //Do Attack
        ArrayList<Ability> activeAbils = p1.getActive().getAbilities();
        int highCost = 0;
        int highIndex = -1;
        for (int i = 0; i < activeAbils.size(); i++) {
            if (activeAbils.get(i).getAttackCost() >= highCost && activeAbils.get(i).getAttackCost() <= p1.getActive().getEnergy()) {
                highIndex = i;
                highCost = activeAbils.get(i).getAttackCost();
            }
        }
        if (highIndex >= 0) {
            Player.doAttack(p1, highIndex, p2);
        }
    }

    public static void main(String[] args) {
        UserInterface frame = new UserInterface();

        /*
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
        Person pa = new Person("knight", "test", 7, abilsa, 5);
        Person[] persons = {new Person("0", "", 3, new ArrayList<Ability>(), 30), new Person("1", "", 3, new ArrayList<Ability>(), 25), pa, p};
        Player p1 = new Player(abils, persons);
        Player p2 = p1;
        //frame.update(p1, p2);
         u/
         */
        king.addAbility(feast);
        queen.addAbility(charge);
        knight.addAbility(stab);
        princess.addAbility(stab);

        ArrayList<Ability> p1Deck = new ArrayList<Ability>();
        p1Deck.add(kick);
        p1Deck.add(kick);
        p1Deck.add(kick);
        p1Deck.add(heal);
        p1Deck.add(heal);
        p1Deck.add(heal);
        p1Deck.add(feast);
        p1Deck.add(slash);
        p1Deck.add(slash);
        p1Deck.add(slash);
        p1Deck.add(slash);
        p1Deck.add(fireball);
        p1Deck.add(charge);
        p1Deck.add(charge);
        p1Deck.add(stab);
        p1Deck.add(stab);
        Object p2DeckObj = p1Deck.clone();
        ArrayList<Ability> p2Deck = (ArrayList<Ability>)p2DeckObj;

        Person[] p1Persons = {king, knight, princess, queen};
        Person[] p2Persons = new Person[4];
        for (int i = 0; i < p1Persons.length; i++) {
            p2Persons[i] = p1Persons[i].copy();
        }

        Player p1 = new Player(p1Deck, p1Persons);
        Player p2 = new Player(p2Deck, p2Persons);
        runGame(p1, p2, frame);
    }
}
