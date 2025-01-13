import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
public class UserInterface extends JFrame{
    private int CARD_WIDTH = 100;
    private int CARD_HEIGHT = 150;
    private static int lastClick = 7;
    private JButton[] cards = new JButton[4];
    private JLabel[] oppCards = new JLabel[4];

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
        for (int i = 0; i < cards.length; i++) {
            Person person = p1.getPerson(i);
            String name = person.getName();
            String spacing = "<br/><br/><br/><br/><br/><br/>";
            String health = "Health: " + person.getHealth() + "/" + person.getMaxHealth();
            String energy = "Energy: " + person.getEnergy();
            cards[i].setText("<html>" + name + spacing + health + "<br/>" + energy + "</html>");

            String abilities = person.getAbilities().toString();
            //cards[i].setToolTipText(abilities.substring(1, abilities.length() - 1));
            JLabel j = new JLabel("<html>Fireball   E:4 D:3" + "<br/>Heal   E:1 H:3</html>");
            j.setBounds(100, 480, CARD_WIDTH, CARD_HEIGHT);
            j.setVisible(true);
            add(j);

            cards[i].setIcon(new ImageIcon(person.getImage()));
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

        JButton oppSL = new JButton("Secondary Left");
        oppSL.setBounds(230, 10, CARD_WIDTH, CARD_HEIGHT);
        oppSL.setVisible(true);
        add(oppSL);

        JButton oppSR = new JButton("Secondary Right");
        oppSR.setBounds(450, 10, CARD_WIDTH, CARD_HEIGHT);
        oppSR.setVisible(true);
        add(oppSR);

        JButton oppTR = new JButton("Tertiary Right");
        oppTR.setBounds(120, 170, CARD_WIDTH, CARD_HEIGHT);
        oppTR.setVisible(true);
        add(oppTR);

        JButton oppActive = new JButton("Active");
        oppActive.setBounds(340, 170, CARD_WIDTH, CARD_HEIGHT);
        oppActive.setVisible(true);
        add(oppActive);

        JButton oppTL = new JButton("Tertiary Left");
        oppTL.setBounds(560, 170, CARD_WIDTH, CARD_HEIGHT);
        oppTL.setVisible(true);
        add(oppTL);

        Icon testimg = new ImageIcon("C:\\Users\\Cyber_Hawk09\\OneDrive\\Desktop\\Earl of March\\Grade_11_AP_Comp_Sci\\Card-Game\\Capture.PNG");
        JButton oppDeck = new JButton(testimg);
        oppDeck.setBounds(10, 170, CARD_WIDTH, CARD_HEIGHT);
        oppDeck.setIcon(new ImageIcon("C:\\Users\\Cyber_Hawk09\\OneDrive\\Desktop\\Earl of March\\Grade_11_AP_Comp_Sci\\Card-Game\\Capture.PNG"));
        oppDeck.setVisible(true);
        add(oppDeck);

        //Current Player
        cards[0] = new JButton("Tertiary Left");
        cards[0].setBounds(120, 330, CARD_WIDTH, CARD_HEIGHT);
        cards[0].setVisible(true);
        add(cards[0]);

        cards[1] = new JButton("Tertiary Right");
        cards[1].setBounds(560, 330, CARD_WIDTH, CARD_HEIGHT);
        cards[1].setVisible(true);
        add(cards[1]);

        cards[2] = new JButton("Secondary Left");
        cards[2].setBounds(230, 490, CARD_WIDTH, CARD_HEIGHT);
        cards[2].setVisible(true);
        add(cards[2]);

        cards[3] = new JButton("Secondary Right");
        cards[3].setBounds(450, 490, CARD_WIDTH, CARD_HEIGHT);
        cards[3].setVisible(true);
        add(cards[3]);
        
        JButton Active = new JButton("Active");
        Active.setBounds(340, 330, CARD_WIDTH, CARD_HEIGHT);
        Active.setVisible(true);
        add(Active);

        JButton deck = new JButton("Deck");
        deck.setBounds(725, 330, CARD_WIDTH, CARD_HEIGHT);
        deck.setVisible(true);
        add(deck);

        JButton opt1 = new JButton("Option 1");
        opt1.setBounds(670, 490, CARD_WIDTH, CARD_HEIGHT);
        opt1.setVisible(true);
        add(opt1);

        JButton opt2 = new JButton("Option 2");
        opt2.setBounds(780, 490, CARD_WIDTH, CARD_HEIGHT);
        opt2.setVisible(true);
        add(opt2);

        for (int i = 0; i < cards.length; i++) {
            final int j = i;
            cards[i].addActionListener(new ActionListener() {
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
