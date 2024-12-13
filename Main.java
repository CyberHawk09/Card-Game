import java.util.ArrayList;
import java.util.Scanner;
public class Main {
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
