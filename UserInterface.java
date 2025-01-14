import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
public class UserInterface extends JFrame{
    private int CARD_WIDTH = 100;
    private int CARD_HEIGHT = 150;
    private static int lastClick = 7;
    private JButton[] persons = new JButton[4];
    private JButton active = new JButton();
    private JLabel deck = new JLabel();
    private JButton[] options = new JButton[2];
    private JButton[] oppPersons = new JButton[4];
    private JButton oppActive = new JButton();
    private JLabel oppDeck = new JLabel();

    public UserInterface() {
        setBounds(100, 50, 900, 700);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
    }

    public int getLastClick() {
        return lastClick;
    }
    public void setLastClick(int num) {
        lastClick = num;
    }

    public void update() {
        repaint();
    }
    public void update(Player p1, Player p2) {
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < persons.length; i++) {
                String setText;
                String abilities;
                Person person = p1.getPerson(i);
                if (j == 0) {
                    person = p2.getPerson(i);
                }

                String name = person.getName();
                String spacing = "<br/><br/><br/><br/><br/><br/>";
                String health = "Health: " + person.getHealth() + "/" + person.getMaxHealth();
                String energy = "Energy: " + person.getEnergy();
                setText = "<html>" + name + spacing + health + "<br/>" + energy + "</html>";
    
                abilities = "<html>";
                for (Ability a : person.getAbilities()) {
                    abilities += a.getName();
                    abilities += "....";
                    abilities += "Energy Cost: " + a.getAttackCost();
                    abilities += "  ";
                    if (a.getDamage() > 0) {
                        abilities += "Damage: " + a.getDamage();
                    } else {
                        abilities += "Heals: " + (a.getDamage() * -1);
                    }
                    abilities += "<br/>";
                }
                abilities += "</html>";
    
                if (j == 0) {
                    persons[i].setText(setText);
                    persons[i].setToolTipText(abilities);
                    persons[i].setIcon(new ImageIcon(person.getImage()));
                    if (i == p1.getActiveIndex()) {
                        active.setText(setText);
                        active.setToolTipText(abilities);
                        active.setIcon(new ImageIcon(person.getImage()));
                    }
                } else {
                    oppPersons[i].setText(setText);
                    oppPersons[i].setToolTipText(abilities);
                    oppPersons[i].setIcon(new ImageIcon(person.getImage()));
                    if (i == p2.getActiveIndex()) {
                        oppActive.setText(setText);
                        oppActive.setToolTipText(abilities);
                        oppActive.setIcon(new ImageIcon(person.getImage()));
                    }
                }
            }
        }

        for (int i = 0; i < options.length; i++) {
            Ability opt = p1.getHand(i);
            if (opt == null) {
                options[i].setVisible(false);
            } else {
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
                options[i].setIcon(new ImageIcon(opt.getImage()));
            }
        }

        repaint();
    }

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

        oppPersons[0] = new JButton("Secondary Left");
        oppPersons[0].setBounds(230, 10, CARD_WIDTH, CARD_HEIGHT);
        oppPersons[0].setVisible(true);
        add(oppPersons[0]);

        oppPersons[1] = new JButton("Secondary Right");
        oppPersons[1].setBounds(450, 10, CARD_WIDTH, CARD_HEIGHT);
        oppPersons[1].setVisible(true);
        add(oppPersons[1]);

        oppPersons[2] = new JButton("Tertiary Right");
        oppPersons[2].setBounds(120, 170, CARD_WIDTH, CARD_HEIGHT);
        oppPersons[2].setVisible(true);
        add(oppPersons[2]);

        oppActive = new JButton("Active");
        oppActive.setBounds(340, 170, CARD_WIDTH, CARD_HEIGHT);
        oppActive.setVisible(true);
        add(oppActive);

        oppPersons[3] = new JButton("Tertiary Left");
        oppPersons[3].setBounds(560, 170, CARD_WIDTH, CARD_HEIGHT);
        oppPersons[3].setVisible(true);
        add(oppPersons[3]);

        Icon testimg = new ImageIcon("C:\\Users\\Cyber_Hawk09\\OneDrive\\Desktop\\Earl of March\\Grade_11_AP_Comp_Sci\\Card-Game\\Capture.PNG");
        oppDeck = new JLabel(testimg);
        oppDeck.setBounds(10, 170, CARD_WIDTH, CARD_HEIGHT);
        oppDeck.setIcon(new ImageIcon("C:\\Users\\Cyber_Hawk09\\OneDrive\\Desktop\\Earl of March\\Grade_11_AP_Comp_Sci\\Card-Game\\Capture.PNG"));
        oppDeck.setVisible(true);
        add(oppDeck);
        repaint();

        //Current Player
        persons[0] = new JButton("Tertiary Left");
        persons[0].setBounds(120, 330, CARD_WIDTH, CARD_HEIGHT);
        persons[0].setVisible(true);
        add(persons[0]);

        persons[1] = new JButton("Tertiary Right");
        persons[1].setBounds(560, 330, CARD_WIDTH, CARD_HEIGHT);
        persons[1].setVisible(true);
        add(persons[1]);

        persons[2] = new JButton("Secondary Left");
        persons[2].setBounds(230, 490, CARD_WIDTH, CARD_HEIGHT);
        persons[2].setVisible(true);
        add(persons[2]);

        persons[3] = new JButton("Secondary Right");
        persons[3].setBounds(450, 490, CARD_WIDTH, CARD_HEIGHT);
        persons[3].setVisible(true);
        add(persons[3]);
        
        active = new JButton("Active");
        active.setBounds(340, 330, CARD_WIDTH, CARD_HEIGHT);
        active.setVisible(true);
        add(active);

        deck = new JLabel("Deck");
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
            persons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setLastClick(j);
                    update();
                }
            });
        }
        for (int i = 0; i < options.length; i++) {
            final int j = i + 4;
            options[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setLastClick(j);
                    update();
                }
            });
        }
        update();
    }
    
    public static String getInput() {
        /* 
        Scanner console = new Scanner(System.in);
        System.out.println("What card would you like to add energy to?");
        String input = console.nextLine();
        console.close();
        return input; */
    } 
}
