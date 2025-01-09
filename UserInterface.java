import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
public class UserInterface extends JFrame{
    private int CARD_WIDTH = 100;
    private int CARD_HEIGHT = 150;
    private static int lastClick = 7;
    private JButton[] persons = new JButton[4];

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

        Icon testimg = new ImageIcon("C:\\Users\\Gregory\\Desktop\\Comp_Sci_11_AP\\Card-Game\\Capture.PNG");
        JButton oppDeck = new JButton(testimg);
        oppDeck.setBounds(10, 170, CARD_WIDTH, CARD_HEIGHT);
        oppDeck.setIcon(new ImageIcon("C:\\Users\\Gregory\\Desktop\\Comp_Sci_11_AP\\Card-Game\\Capture.PNG"));
        oppDeck.setVisible(true);
        add(oppDeck);

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

        for (int i = 0; i < persons.length; i++) {
            final int j = i;
            persons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setLastClick(j);
                }
            });
        }
        repaint();
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
