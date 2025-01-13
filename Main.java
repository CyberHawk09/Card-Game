import java.util.ArrayList;
public class Main {
    public static void runGame(Player p1, Player p2, UserInterface frame) {
        boolean p1Turn = true;

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
        while (frame.getLastClick() > 5) {
            //wait
        }
        Ability abil = p1.getHand(frame.getLastClick() - 4);
        frame.setLastClick(7);

        while (frame.getLastClick() > 3) {
            //wait
        }
        p1.addAbility(frame.getLastClick(), abil);
        frame.setLastClick(7);

        //Add Energy
        for (int i = 0; i < 4; i++) {
            while (frame.getLastClick() > 3) {
                //wait
            }
            p1.addEnergy(frame.getLastClick());
            frame.setLastClick(7);
        }

        //Add Active
        while (frame.getLastClick() > 3) {
            //wait
        }
        p1.setActive(frame.getLastClick());
        frame.setLastClick(7);

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
        /*
        Scanner console = new Scanner(System.in);
        
        Person knight = new Person( "Knight", 3, new ArrayList<Ability>(), 30);
        String input = console.nextLine();
        knight.addEnergy(3);
        if (input.equals("attach strong attack")) {
            Ability strongAttack = new Ability("Strong Attack", 5, 1);
            knight.addAbility(strongAttack);
        } else if (input.equals("energy")) {
            System.out.println(knight.getEnergy());
        }

        String another = console.nextLine();
        if (another.equals("strong attack") && knight.abilityIndex("Strong Attack") >= 0) {
            System.out.println(knight.getAbilities().get(knight.abilityIndex("Strong Attack")).getDamage());
        } else {
            System.out.println("no strong attack");
        }
        console.close();
        */
        /* 
        Person k = new Person( "Knight", 3, new ArrayList<Ability>(), 30);
        ArrayList<Person> p = new ArrayList<Person>();
        p.add(k);
        p.add(k);
        p.add(k);
        p.add(k);
        Ability s = new Ability("Strong Attack", 5, 1);
        ArrayList<Ability> a = new ArrayList<Ability>();
        a.add(s);
        a.add(s);
        a.add(s);
        a.add(s);
        a.add(s);
        runGame(new Player(p, a), new Player(p, a));
        */
        UserInterface frame = new UserInterface();
        frame.gameScreen();

        ArrayList<Ability> abils = new ArrayList<Ability>();
        Ability a = new Ability("a", "test", 3, 1);
        abils.add(a);
        abils.add(a);
        abils.add(a);
        abils.add(a);
        abils.add(a);
        abils.add(a);
        Person p = new Person("p", "test", 3, new ArrayList<Ability>(), 3);
        Person[] persons = {p, p, p, p};
        Player p1 = new Player(abils, persons);
        Player p2 = p1;
        frame.update(p1, p2);
    }
}
