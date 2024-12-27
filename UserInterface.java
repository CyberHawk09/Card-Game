import javax.swing.*;
import java.awt.event.*;
public class UserInterface extends JFrame{
    private int CARD_WIDTH = 100;
    private int CARD_HEIGHT = 150;

    public UserInterface() {
        setBounds(100, 50, 1000, 650);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
    }

    public void gameScreen() {
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
