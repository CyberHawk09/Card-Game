import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void runGame(Player p1, Player p2) {
        boolean gameOver = false;
        boolean p1Slots = false;
        boolean p2Slots = false;
        boolean p1Turn = true;

        p1.setupHand();
        p2.setupHand();
        while (!gameOver) {
            if (p1Turn) {
                runTurn(p1, p2);
                p2.healthUpdate();
                if (!p1.checkSlots()) {
                    gameOver = true;
                }
                p1Turn = false;
            } else {
                runTurn(p2, p1);
                p1.healthUpdate();
                if (!p2.checkSlots()) {
                    gameOver = true;
                }
                p1Turn = true;
            }
        }
    }
    public static void runTurn(Player p1, Player p2) {
        for (int i = 0; i < 4; i++) {
            String card = UserInterface.getInput();
            switch (card) {
                case "active":
                    if (p1.getActive() == null) {
                        i--;
                    } else {
                        p1.getActive().addEnergy(1);
                    }
                case "sL":
                    if (p1.getSecondaryL() == null) {
                        i--;
                    } else {
                        p1.getSecondaryL().addEnergy(1);
                    }
                case "sR":
                    if (p1.getSecondaryR() == null) {
                        i--;
                    } else {
                        p1.getSecondaryR().addEnergy(1);
                    }
                case "tL":
                    if (p1.getTertiaryL() == null) {
                        i--;
                    } else {
                        p1.getTertiaryL().addEnergy(1);
                    }
                case "tR":
                    if (p1.getTertiaryR() == null) {
                        i--;
                    } else {
                        p1.getTertiaryR().addEnergy(1);
                    }
                case "deck":
                    if (p1.deckSize() <= 0) {
                        i--;
                    }
                    p1.deckDraw();
            }
        }
        boolean endTurn = false;
        while (!endTurn) {
            String select1 = UserInterface.getInput();
            
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
    }
}
