import java.util.ArrayList;
import java.io.*;

/**
 * The main class that handles all the information together and the game logic.
 */
public class Main {
    /**
     * Starts a game with the two specified players and the specified UserInterface.
     * @param p1 the first Player to make a move
     * @param p2 the second Player to make a move
     * @param frame the UserInterface to handle display and user input
     * @return a String representing which Player won and in how many turns
     */
    public static String runGame(Player p1, Player p2, UserInterface frame) {
        boolean p1Turn = true;
        int turnCount = 0; //Counts turns as 1 turn = 1 Player1 move + 1 Player2 move

        //Start Game
        frame.gameScreen();
        while (true) {
            if (p1Turn) {
                if (!p1.checkSlots()) {
                    break;
                }
                runTurn(p1, p2, frame);
                p1Turn = false;
                turnCount++;
            } else {
                if (!p2.checkSlots()) {
                    break;
                }
                runTurn(p2, p1, frame);
                p1Turn = true;
            }
        }

        //Return String with data on winner and turns it took to win
        if (p1Turn) {
            return "Player 2 - " + turnCount;
        } else {
            return "Player 1 - " + turnCount;
        }
    }

    /**
     * Runs a turn with the specified Players and UserInterface.
     * @param p1 the current Player
     * @param p2 the opposing Player
     * @param frame the UserInterface to handle display and user input
     */
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

    /**
     * Records the results of the last game permanently. Reads all the records and calls on the specified UserInterface's endScreen() method with the last results and all past records.
     * @param results the results of the last game
     * @param frame the UserInterface to handle display and user input
     */
    public static void gameOver(String results, UserInterface frame) {
        //Add latest results to Rankings.txt
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("Rankings.txt", true));
            pw.println(results);
            pw.close();
        } catch (IOException e) {
            frame.textError();
        }
        //Display game over screen and sort all results in order (least -> greatest)
        try {
            String rankings = "";
            BufferedReader br = new BufferedReader(new FileReader("Rankings.txt"));
            String addedText = br.readLine();
            while (addedText != null) {
                rankings += addedText + "/";
                addedText = br.readLine();
            }
            rankings = rankings.substring(0, rankings.length() - 1);
            String[] rankingsArray = quickSort(rankings.split("/"));
            frame.endScreen(results, rankingsArray);
        } catch (IOException e) {
            frame.textError();
        }
    }

    /**
     * Sorts all records from least amount of turns to most.
     * @param s an array of records to be sorted
     * @return a sorted array of all the records.
     */
    public static String[] quickSort(String[] s) {
        //Create separate array
        String[] arr = s;

        //Find k-value (midpoint)
        int k = Integer.parseInt(arr[0].substring(11));

        //Count how many elements are less than, more than, or equal to k-value
        int less = 0;
        int more = 0;
        int equals = 0;
        for (int i = 0; i < arr.length; i++) {
            Integer.parseInt(arr[i].substring(11));
            if (Integer.parseInt(arr[i].substring(11)) < k) {
                less++;
            } else if (Integer.parseInt(arr[i].substring(11)) > k) {
                more++;
            }
        }
        equals = arr.length - (less + more);
        //Base Case: return array if there is only one type of element left
        if (less < 1 && more < 1) {
            return arr;
        }

        //Copy values into separate arrays depending on if they are less than, more than, or equal to k-value
        String[] lessArr = new String[less];
        String[] moreArr = new String[more];
        String[] equalsArr = new String[equals];

        int lessIndex = 0;
        int moreIndex = 0;
        int equalsIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Integer.parseInt(arr[i].substring(11)) < k) {
                lessArr[lessIndex] = arr[i];
                lessIndex++;
            } else if (Integer.parseInt(arr[i].substring(11)) > k) {
                moreArr[moreIndex] = arr[i];
                moreIndex++;
            } else {
                equalsArr[equalsIndex] = arr[i];
                equalsIndex++;
            }
        }

        //Recursive call to sort each sub-array if they have any elements
        if (less > 0) {
            lessArr = quickSort(lessArr);
        }
        if (more > 0) {
            moreArr = quickSort(moreArr);
        }
        equalsArr = quickSort(equalsArr);

        //Combine all 3 arrays into a single sorted array
        for (int i = 0; i < arr.length; i++) {
            if (i < less) {
                arr[i] = lessArr[i];
            } else if (i - less < equals) {
                arr[i] = equalsArr[i - less];
            } else {
                arr[i] = moreArr[i - less - equals];
            }
        }

        //Return
        return arr;
    }

    /**
     * The method that is run by Java, where all the other game logic methods are called.
     * @param args N/A
     */
    public static void main(String[] args) {
        //Create a new JFrame/UserInterface
        UserInterface frame = new UserInterface();

        //Instantiate Ability presets
        Ability heal = new Ability("Heal", "", -3, 2);
        Ability slash = new Ability("Slash", "", 2, 1);
        Ability kick = new Ability("Kick", "", 1, 1);
        Ability feast = new Ability("Feast" , "", -7, 8);
        Ability stab = new Ability("Stab", "", 3, 2);
        Ability charge = new Ability("Charge", "", 5, 6);
        Ability fireball = new Ability("Fireball", "", 9, 11);
        //Instantiate Person presets
        Person king = new Person("King", "", new ArrayList<Ability>(), 8);
        Person queen = new Person("Queen", "", new ArrayList<Ability>(), 10);
        Person knight = new Person("Knight", "", new ArrayList<Ability>(), 15);
        Person princess = new Person("Princess", "", new ArrayList<Ability>(), 12);
        king.addAbility(feast);
        queen.addAbility(charge);
        knight.addAbility(stab);
        princess.addAbility(stab);

        //Instantiate decks
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

        //Instantiate Persons
        Person[] p1Persons = {king, knight, princess, queen};
        Person[] p2Persons = new Person[4];
        for (int i = 0; i < p1Persons.length; i++) {
            p2Persons[i] = p1Persons[i].copy();
        }
        Player p1 = new Player(p1Deck, p1Persons);
        Player p2 = new Player(p2Deck, p2Persons);

        //Game Logic!
        //Run Game
        String results = runGame(p1, p2, frame);
        //Display Game Over Screen and Save Results
        gameOver(results, frame);
    }
}
