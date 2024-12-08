import java.util.ArrayList;
import java.util.Random;
public class Player {
    private Random random = new Random();
    private ArrayList<Person> personDeck = new ArrayList<Person>();
    private ArrayList<Ability> abilDeck = new ArrayList<Ability>();
    private ArrayList<Person> personHand = new ArrayList<Person>();
    private ArrayList<Ability> abilHand = new ArrayList<Ability>();
    private Person active = null;
    private Person secondaryL = null;
    private Person secondaryR = null;
    private Person tertiaryL = null;
    private Person tertiaryR = null;

    public Player(ArrayList<Person> pDeck, ArrayList<Ability> aDeck) {
        personDeck = pDeck;
        abilDeck = aDeck;
    }

    public void deckDraw() {
        double d = random.nextDouble() * 2;
        if (d < 1) {
            double c = random.nextDouble() * personDeck.size();
        }
    }
}
