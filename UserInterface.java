import javax.swing.*;
import java.awt.event.*;
public class UserInterface extends JFrame{
    private int CARD_WIDTH = 100;
    private int CARD_HEIGHT = 150;

    public UserInterface() {
        setBounds(100, 50, 900, 700);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
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

        JButton rowA = new JButton("Testing");
        rowA.setBounds(10, 10, CARD_WIDTH, CARD_HEIGHT);
        rowA.setVisible(true);
        add(rowA);

        JButton oppTR = new JButton("Tertiary Right");
        oppTR.setBounds(120, 10, CARD_WIDTH, CARD_HEIGHT);
        oppTR.setVisible(true);
        add(oppTR);

        JButton oppActive = new JButton("Active");
        oppActive.setBounds(340, 10, CARD_WIDTH, CARD_HEIGHT);
        oppActive.setVisible(true);
        add(oppActive);

        JButton oppTL = new JButton("Tertiary Left");
        oppTL.setBounds(560, 10, CARD_WIDTH, CARD_HEIGHT);
        oppTL.setVisible(true);
        add(oppTL);

        JButton rowB = new JButton("Testing");
        rowB.setBounds(10, 170, CARD_WIDTH, CARD_HEIGHT);
        rowB.setVisible(true);
        add(rowB);

        JButton TL = new JButton("Tertiary Left");
        TL.setBounds(120, 170, CARD_WIDTH, CARD_HEIGHT);
        TL.setVisible(true);
        add(TL);

        JButton Active = new JButton("Active");
        Active.setBounds(340, 170, CARD_WIDTH, CARD_HEIGHT);
        Active.setVisible(true);
        add(Active);

        JButton TR = new JButton("Tertiary Right");
        TR.setBounds(560, 170, CARD_WIDTH, CARD_HEIGHT);
        TR.setVisible(true);
        add(TR);

        JButton rowC = new JButton("Testing");
        rowC.setBounds(10, 330, CARD_WIDTH, CARD_HEIGHT);
        rowC.setVisible(true);
        add(rowC);

        JButton SL = new JButton("Secondary Left");
        SL.setBounds(230, 330, CARD_WIDTH, CARD_HEIGHT);
        SL.setVisible(true);
        add(SL);

        JButton SR = new JButton("Secondary Right");
        SR.setBounds(450, 330, CARD_WIDTH, CARD_HEIGHT);
        SR.setVisible(true);
        add(SR);

        JButton rowD = new JButton("Testing");
        rowD.setBounds(10, 490, CARD_WIDTH, CARD_HEIGHT);
        rowD.setVisible(true);
        add(rowD);
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
