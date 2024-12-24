import java.util.Scanner;
public class UserInterface {
    public static String getInput() {
        Scanner console = new Scanner(System.in);
        System.out.println("What card would you like to add energy to?");
        String input = console.nextLine();
        //console.close();
        return input;
    } 
}
