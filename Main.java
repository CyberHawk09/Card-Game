import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void runGame(Player p1, Player p2) {
        boolean gameOver = false;
        boolean p1Slots = false;
        boolean p2Slots = false;
        boolean p1Turn = true;
        int turnCount = 0;

        while (!gameOver) {
            if (p1Turn) {
                runTurn(p1, p2);
                p1Turn = false;
            } else {
                runTurn(p2, p1);
                p1Turn = true;
            }
            p1Slots = p1.checkSlots();
            p2Slots = p2.checkSlots();
            if (turnCount >= 2) {
                if (!p1Slots) {
                    gameOver = true;
                } else if (!p2Slots) {
                    gameOver = true;
                }
            }
            turnCount++;
        }
    }
    public static void runTurn(Player p1, Player p2) {
        for (int i = 0; i < 4; i++) {
            String card = InputHandler.getCardSelection();
            switch (card) {
                case "active":
                    p1.getActive().addEnergy(1);
                case "sL":
                    p1.getSecondaryL().addEnergy(1);
                case "sR":
                    p1.getSecondaryR().addEnergy(1);
                case "tL":
                    p1.getTertiaryL().addEnergy(1);
                case "tR":
                    p1.getTertiaryR().addEnergy(1);
            }
        }
        
    }
    public static void main (String[] args) {
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
    }
}
