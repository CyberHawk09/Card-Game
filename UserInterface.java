import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * An object that contains and handles all information regarding the Graphical User Interface of the Card-Game project.
 */
public class UserInterface extends JFrame{
    /**
     * A constant representing the width (in pixels) of each Card on the screen.
     */
    final private int CARD_WIDTH = 100;
    /**
     * A constant representing the height (in pixels) of each Card on the screen.
     */
    final private int CARD_HEIGHT = 150;
    /**
     * An integer whose value is dictated by the last button click on the screen.
     */
    private static int lastClick = 7;
    /**
     * An array of JButtons representing each Person of the current Player.
     */
    private JButton[] persons = new JButton[4];
    /**
     * An array of JLabels representing the abilities of each Person of the current Player.
     */
    private JLabel[] personAbilities = new JLabel[4];
    /**
     * A JLabel representing the active slot of the current Player.
     */
    private JLabel active = new JLabel();
    /**
     * A JLabel representing the deck of the current Player.
     */
    private JLabel deck = new JLabel();
    /**
     * An array of JButtons representing each Ability in the hand of the current Player.
     */
    private JButton[] options = new JButton[2];
    /**
     * An array of JButtons representing the persons of the opposing Player.
     */
    private JButton[] oppPersons = new JButton[4];
    /**
     * An array of JLabels representing the abilities of each Person of the opposing Player.
     */
    private JLabel[] oppPersonAbilities = new JLabel[4];
    /**
     * A JButton representing the active Person of the opposing Player.
     */
    private JButton oppActive = new JButton();
    /**
     * A JLabel representing the abilities of the active Person of the opposing Player.
     */
    private JLabel oppActiveAbility = new JLabel();

    /**
     * Constructs a JFrame with dimensions 900x700px starting 100 pixels from the left and 50 pixels from the top of the screen.
     */
    public UserInterface() {
        setBounds(100, 50, 900, 700);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
    }

    /**
     * Returns the value of the lastClick variable.
     * @return the value of the lastClick variable
     */
    public int getLastClick() {
        return lastClick;
    }

    /**
     * Sets the value of the lastClick variable to the specified amount.
     * @param num the amount to set the lastClick variable to
     */
    public void setLastClick(int num) {
        lastClick = num;
    }

    /**
     * Updates this UserInterface.
     */
    public void update() {
        revalidate();
        repaint();
    }

    /**
     * Re-evaluates the values of each JButton and JLabel on this UserInterface.
     * @param p1 the current player
     * @param p2 the opposing player
     */
    public void update(Player p1, Player p2) {
        //Iterate between p1 and p2
        for (int j = 0; j < 2; j++) {
            //Iterate between each persons array
            for (int i = 0; i < persons.length; i++) {
                //Define some variables
                String setText;
                String abilities = "<html>Abilities:<br/>";
                Person person;
                if (j == 0) {
                    person = p1.getPerson(i);
                } else {
                    person = p2.getPerson(i);
                }

                //Set text
                String name = person.getName();
                String spacing = "<br/><br/><br/><br/><br/><br/>";
                String health = "Health: " + person.getHealth() + "/" + person.getMaxHealth();
                String energy = "Energy: " + person.getEnergy();
                setText = "<html>" + name + spacing + health + "<br/>" + energy + "</html>";
    
                ArrayList<Ability> abils = person.getAbilities();
                for (Ability a : abils) {
                    abilities += a.getName();
                    abilities += "..";
                    abilities += "E:" + a.getAttackCost();
                    abilities += " ";
                    if (a.getDamage() > 0) {
                        abilities += "D:" + a.getDamage();
                    } else {
                        abilities += "H:" + (a.getDamage() * -1);
                    }
                    abilities += "<br/>";
                }
                abilities += "</html>";

                //Set text depending on if Player 1 or Player 2 and if the card is set as active
                if (j == 0) {
                    persons[i].setText(setText);
                    personAbilities[i].setText(abilities);
                } else {
                    if (i == p2.getActiveIndex()) {
                        oppPersons[i].setVisible(false);
                        oppPersonAbilities[i].setVisible(false);
                        oppActive.setText(setText);
                        oppActiveAbility.setText(abilities);
                        oppActive.setBackground(Color.LIGHT_GRAY);
                    } else {
                        oppPersons[i].setText(setText);
                        oppPersonAbilities[i].setText(abilities);
                        oppPersons[i].setVisible(true);
                        oppPersonAbilities[i].setVisible(true);
                        oppPersons[i].setBackground(Color.GRAY);
                    }
                }
            }
        }

        for (int i = 0; i < options.length; i++) {
            //Do the same as above but for the 2 Ability objects in the hand
            Ability opt = p1.getHand(i);
            //If there is no card, do not display it
            if (opt == null) {
                options[i].setVisible(false);
            } else {
                options[i].setVisible(true);
                String name = opt.getName();
                String spacing = "<br/><br/><br/><br/><br/><br/>";
                String energy = "Energy Cost: " + opt.getAttackCost();
                String damage;
                if (opt.getDamage() > 0) {
                    damage = "Damage: " + opt.getDamage();
                } else {
                    damage = "Heals: " + (opt.getDamage() * -1);
                }
                String setText = "<html>" + name + spacing + energy + "<br/>" + damage + "</html>";
                options[i].setText(setText);
                if (opt.getDamage() > 0) {
                    options[i].setBackground(Color.ORANGE);
                } else {
                    options[i].setBackground(Color.YELLOW);
                }
            }
        }
        //Update the screen with all the changes
        update();
    }

    /**
     * Defines all the values, actionListeners (JButtons only), and positions of the JButtons and JLabels on this UserInterface. Prepares all of them for a round of the game.
     */
    public void gameScreen() {
        /*
        JButton button = new JButton("Woohoo!!");
        button.setBounds(0, 0, CARD_WIDTH, CARD_HEIGHT);
        button.setVisible(true);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                button.setText("ok");
            }
        });
        this.add(button);

        JButton b = new JButton("Woohoo!!");
        b.setBounds(0, 160, CARD_WIDTH, CARD_HEIGHT);
        b.setVisible(true);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                b.setText("ok");
            }
        });
        this.add(b);
        */

        oppPersons[2] = new JButton("Secondary Left");
        oppPersons[2].setBounds(230, 10, CARD_WIDTH, CARD_HEIGHT);
        oppPersons[2].setVisible(true);
        add(oppPersons[2]);
        oppPersonAbilities[2] = new JLabel();
        oppPersonAbilities[2].setBounds(230 - CARD_WIDTH, 10, CARD_WIDTH, CARD_HEIGHT);
        oppPersonAbilities[2].setVisible(true);
        add(oppPersonAbilities[2]);

        oppPersons[1] = new JButton("Secondary Right");
        oppPersons[1].setBounds(450, 10, CARD_WIDTH, CARD_HEIGHT);
        oppPersons[1].setVisible(true);
        add(oppPersons[1]);
        oppPersonAbilities[1] = new JLabel();
        oppPersonAbilities[1].setBounds(450 - CARD_WIDTH, 10, CARD_WIDTH, CARD_HEIGHT);
        oppPersonAbilities[1].setVisible(true);
        add(oppPersonAbilities[1]);

        oppPersons[3] = new JButton("Tertiary Right");
        oppPersons[3].setBounds(120, 170, CARD_WIDTH, CARD_HEIGHT);
        oppPersons[3].setVisible(true);
        add(oppPersons[3]);
        oppPersonAbilities[3] = new JLabel();
        oppPersonAbilities[3].setBounds(120 - CARD_WIDTH, 170, CARD_WIDTH, CARD_HEIGHT);
        oppPersonAbilities[3].setVisible(true);
        add(oppPersonAbilities[3]);

        oppActive = new JButton("Active");
        oppActive.setBounds(340, 170, CARD_WIDTH, CARD_HEIGHT);
        oppActive.setVisible(true);
        add(oppActive);
        oppActiveAbility = new JLabel();
        oppActiveAbility.setBounds(340 - CARD_WIDTH, 170, CARD_WIDTH, CARD_HEIGHT);
        oppActiveAbility.setVisible(true);
        add(oppActiveAbility);

        oppPersons[0] = new JButton("Tertiary Left");
        oppPersons[0].setBounds(560, 170, CARD_WIDTH, CARD_HEIGHT);
        oppPersons[0].setVisible(true);
        add(oppPersons[0]);
        oppPersonAbilities[0] = new JLabel();
        oppPersonAbilities[0].setBounds(560 - CARD_WIDTH, 170, CARD_WIDTH, CARD_HEIGHT);
        oppPersonAbilities[0].setVisible(true);
        add(oppPersonAbilities[0]);

        //Current Player
        persons[0] = new JButton("Tertiary Left");
        persons[0].setBounds(120, 330, CARD_WIDTH, CARD_HEIGHT);
        persons[0].setVisible(true);
        add(persons[0]);
        personAbilities[0] = new JLabel("Test");
        personAbilities[0].setBounds(120 - CARD_WIDTH, 330, CARD_WIDTH, CARD_HEIGHT);
        personAbilities[0].setVisible(true);
        add(personAbilities[0]);

        persons[3] = new JButton("Tertiary Right");
        persons[3].setBounds(560, 330, CARD_WIDTH, CARD_HEIGHT);
        persons[3].setVisible(true);
        add(persons[3]);
        personAbilities[3] = new JLabel("Test");
        personAbilities[3].setBounds(560 - CARD_WIDTH, 330, CARD_WIDTH, CARD_HEIGHT);
        personAbilities[3].setVisible(true);
        add(personAbilities[3]);

        persons[1] = new JButton("Secondary Left");
        persons[1].setBounds(230, 490, CARD_WIDTH, CARD_HEIGHT);
        persons[1].setVisible(true);
        add(persons[1]);
        personAbilities[1] = new JLabel("Test");
        personAbilities[1].setBounds(230 - CARD_WIDTH, 490, CARD_WIDTH, CARD_HEIGHT);
        personAbilities[1].setVisible(true);
        add(personAbilities[1]);

        persons[2] = new JButton("Secondary Right");
        persons[2].setBounds(450, 490, CARD_WIDTH, CARD_HEIGHT);
        persons[2].setVisible(true);
        add(persons[2]);
        personAbilities[2] = new JLabel("Test");
        personAbilities[2].setBounds(450 - CARD_WIDTH, 490, CARD_WIDTH, CARD_HEIGHT);
        personAbilities[2].setVisible(true);
        add(personAbilities[2]);
        
        active = new JLabel("Active Slot", SwingConstants.CENTER);
        active.setHorizontalTextPosition(SwingConstants.CENTER);
        active.setVerticalTextPosition(SwingConstants.CENTER);
        active.setBounds(340, 330, CARD_WIDTH, CARD_HEIGHT);
        active.setVisible(true);
        add(active);

        deck = new JLabel();
        deck.setBounds(725, 330, CARD_WIDTH, CARD_HEIGHT);
        deck.setVisible(true);
        add(deck);

        options[0] = new JButton("Option 1");
        options[0].setBounds(670, 490, CARD_WIDTH, CARD_HEIGHT);
        options[0].setVisible(true);
        add(options[0]);

        options[1] = new JButton("Option 2");
        options[1].setBounds(780, 490, CARD_WIDTH, CARD_HEIGHT);
        options[1].setVisible(true);
        add(options[1]);

        for (int i = 0; i < persons.length; i++) {
            final int j = i;
            persons[i].addActionListener((e) -> {
                setLastClick(j);
                update();
                });
        }
        for (int i = 0; i < options.length; i++) {
            final int j = i + 4;
            options[i].addActionListener((e) -> {
                setLastClick(j);
                update();
            });
        }
        update();

        String walkText = "<html>WALKTHROUGH<br/><br/>Step 1: Select an orange or yellow ability in the bottom right.<br/>" +
                "Step 2: Select a blue person card to attach the ability to (King, Queen, Knight, Princess).<br/>" +
                "Step 3: Distribute your four energy across the person cards (1 click = 1 energy).<br/>" +
                "Step 4: Select your Active card. They will do the most expensive ability they can afford.<br/>" +
                "<br/>Now pass the controls to the other player!</html>";
        JLabel walkthrough = new JLabel(walkText, SwingConstants.CENTER);
        walkthrough.setBounds(575, 0, 300, 300);
        walkthrough.setOpaque(true);
        walkthrough.setVisible(true);
        add(walkthrough);
    }

    /**
     * Displays the game over message and the current rankings.
     * @param winStats the winning player and how many turns it took to win
     * @param rankings the full rankings
     */
    public void endScreen(String winStats, String[] rankings) {
        //Set all gameScreen elements as invisible
        for (JButton b : persons) {
            b.setVisible(false);
        }
        for (JLabel l : personAbilities) {
            l.setVisible(false);
        }
        for (JButton b : options) {
            b.setVisible(false);
        }
        for (JButton b : oppPersons) {
            b.setVisible(false);
        }
        for (JLabel l : oppPersonAbilities) {
            l.setVisible(false);
        }
        active.setVisible(false);
        deck.setVisible(false);
        oppActive.setVisible(false);
        oppActiveAbility.setVisible(false);

        //Create Game Over text
        String setText = "<html>";
        if (winStats.startsWith("Player 1")) {
            setText += "Player 1 Wins!<br/>";
        } else {
            setText += "Player 2 Wins!<br/>";
        }
        setText += "You won in " + winStats.substring(11) + " turns!<br/>";

        //Grab the top 5 best records
        setText += "<br/>Rankings:<br/>";
        for (int i = 0; i < 5; i++) {
            setText += (i + 1) + ". ";
            try {
                setText += rankings[i];
            } catch (Exception e) {
                setText += "No record";
            }
            setText += "<br/>";
        }

        setText += "<br/>Thank you for playing!</html>";

        //Create JLabel to display message
        JLabel message = new JLabel(setText, SwingConstants.CENTER);
        message.setBounds(0, 0, 900, 700);
        message.setFont(new Font("Serif", Font.PLAIN, 30));
        message.setVisible(true);
        add(message);
        update();
    }

    /**
     * Alternative to gameScreen() method if Rankings.txt could not be found.
     */
    public void textError() {
        //Set all gameScreen elements as invisible
        for (JButton b : persons) {
            b.setVisible(false);
        }
        for (JLabel l : personAbilities) {
            l.setVisible(false);
        }
        for (JButton b : options) {
            b.setVisible(false);
        }
        for (JButton b : oppPersons) {
            b.setVisible(false);
        }
        for (JLabel l : oppPersonAbilities) {
            l.setVisible(false);
        }
        active.setVisible(false);
        deck.setVisible(false);
        oppActive.setVisible(false);
        oppActiveAbility.setVisible(false);

        //Display Error Text
        JLabel message = new JLabel("Rankings.txt Text File is Missing!", SwingConstants.CENTER);
    }
}
