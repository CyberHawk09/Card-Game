import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
public class UserInterface extends JFrame{
    private int CARD_WIDTH = 100;
    private int CARD_HEIGHT = 150;
    private static int lastClick = 7;
    private JButton[] persons1Buttons = new JButton[4];
    private JLabel[] persons1Labels = new JLabel[4];

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

    public void update(){
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

        /* 
        Icon testimg = new ImageIcon("C:\\Users\\Gregory\\Desktop\\Comp_Sci_11_AP\\Card-Game\\Capture.PNG");
        JButton oppDeck = new JButton("yap", testimg);
        oppDeck.setBounds(10, 170, CARD_WIDTH, CARD_HEIGHT);
        //oppDeck.setIcon(new ImageIcon("C:\\Users\\Gregory\\Desktop\\Comp_Sci_11_AP\\Card-Game\\craiyon_131032_A_knight_with_torch_in_a_dungeon__pixel_art.png"));
        oppDeck.setText("yas");
        oppDeck.setVerticalTextPosition(SwingConstants.TOP);
        oppDeck.setHorizontalTextPosition(SwingConstants.LEFT);
        oppDeck.setVisible(true);
        add(oppDeck);
        */
        Icon testimg = new ImageIcon("C:\\\\Users\\\\Gregory\\\\Desktop\\\\Comp_Sci_11_AP\\\\Card-Game\\\\Capture.PNG");
        JButton oppDeck = new JButton(testimg); // Set text and icon during initialization
        oppDeck.setBounds(10, 170, CARD_WIDTH, CARD_HEIGHT);
        oppDeck.setText("<html>FINALLY<br/>I<br/>GOT IT</html>");
        oppDeck.setBounds(10, 170, 100, 100);
        oppDeck.setHorizontalTextPosition(SwingConstants.CENTER);
        oppDeck.setVerticalTextPosition(SwingConstants.CENTER);
        oppDeck.setVisible(true);
        add(oppDeck);

        //Current Player
        persons1Buttons[0] = new JButton("<html>Knight<br/><br/><br/><br/><br/>Health: 10/10<br/>Energy: 6</html>");
        persons1Buttons[0].setBounds(120, 330, CARD_WIDTH, CARD_HEIGHT);
        persons1Buttons[0].setVisible(true);
        persons1Buttons[0].setIconTextGap(0);
        persons1Buttons[0].setIcon(new ImageIcon("C:\\Users\\Gregory\\Desktop\\Comp_Sci_11_AP\\Card-Game\\Knight.png"));
        persons1Buttons[0].setToolTipText("<html>Naah <br />yo</html>");

        add(persons1Buttons[0]);

        persons1Buttons[1] = new JButton("Tertiary Right");
        persons1Buttons[1].setBounds(560, 330, CARD_WIDTH, CARD_HEIGHT);
        persons1Buttons[1].setVisible(true);
        add(persons1Buttons[1]);

        persons1Buttons[2] = new JButton("Secondary Left");
        persons1Buttons[2].setBounds(230, 490, CARD_WIDTH, CARD_HEIGHT);
        persons1Buttons[2].setVisible(true);
        add(persons1Buttons[2]);

        persons1Buttons[3] = new JButton("Secondary Right");
        persons1Buttons[3].setBounds(450, 490, CARD_WIDTH, CARD_HEIGHT);
        persons1Buttons[3].setVisible(true);
        add(persons1Buttons[3]);
        
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

        for (int i = 0; i < persons1Buttons.length; i++) {
            final int j = i;
            persons1Buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setLastClick(j);
                    update();
                }
            });
        }
        repaint();
    }
}
