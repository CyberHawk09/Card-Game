import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
public class UserInterface extends JFrame{
    private int CARD_WIDTH = 100;
    private int CARD_HEIGHT = 150;
    private static int lastClick = 7;
    private JButton[] persons = new JButton[4];
    private JLabel[] personAbilities = new JLabel[4];
    private JButton active = new JButton();
    private JLabel deck = new JLabel();
    private JButton[] options = new JButton[2];
    private JButton[] oppPersons = new JButton[4];
    private JLabel[] oppPersonAbilities = new JLabel[4];
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
        revalidate();
        repaint();
    }
    public void update(Player p1, Player p2) {
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < persons.length; i++) {
                String setText;
                //String abilities = "<html>Abilities:<br/>";
                String abilities = "<html>";
                Person person;
                if (j == 0) {
                    person = p1.getPerson(i);
                } else {
                    person = p2.getPerson(i);
                }

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
    
                if (j == 0) {
                    persons[i].setText(setText);
                    //personAbilities[i].setFont(new Font("Arial", Font.PLAIN, 8));
                    personAbilities[i].setText(abilities);
                    personAbilities[i].setBounds(persons[i].getX() - CARD_WIDTH, persons[i].getY(), CARD_WIDTH, CARD_HEIGHT);
                    persons[i].setIcon(new ImageIcon(person.getImage()));
                    if (i == p1.getActiveIndex()) {
                        active.setText(setText);
                        active.setIcon(new ImageIcon(person.getImage()));
                    }
                } else {
                    oppPersons[i].setText(setText);
                    oppPersonAbilities[i].setText(abilities);
                    oppPersons[i].setIcon(new ImageIcon(person.getImage()));
                    if (i == p2.getActiveIndex()) {
                        oppActive.setText(setText);
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
                options[i].setIcon(new ImageIcon(opt.getImage()));
            }
        }

        update();
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

        oppPersons[0] = new JButton("Tertiary Left");
        oppPersons[0].setBounds(560, 170, CARD_WIDTH, CARD_HEIGHT);
        oppPersons[0].setVisible(true);
        add(oppPersons[0]);
        oppPersonAbilities[0] = new JLabel();
        oppPersonAbilities[0].setBounds(560 - CARD_WIDTH, 170, CARD_WIDTH, CARD_HEIGHT);
        oppPersonAbilities[0].setVisible(true);
        add(oppPersonAbilities[0]);

        oppDeck = new JLabel();
        oppDeck.setBounds(10, 170, CARD_WIDTH, CARD_HEIGHT);
        oppDeck.setVisible(true);
        add(oppDeck);
        update();

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
}
