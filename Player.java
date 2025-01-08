import java.util.ArrayList;
import java.util.Random;
public class Player {
    private Random random = new Random();
    private ArrayList<Ability> deck = new ArrayList<Ability>();
    private Ability[] hand = new Ability[2];
    private Person active = null;
    private Person secondaryL = null;
    private Person secondaryR = null;
    private Person tertiaryL = null;
    private Person tertiaryR = null;

    public Player(ArrayList<Ability> aDeck) {
        deck = aDeck;
    }

    public int deckSize() {
        return deck.size();
    }
    public int handSize() {
        return deck.size();
    }
    public Ability[] getHand() {
        return hand;
    }

    public Person getActive() {
        return active;
    }
    public Person getSecondaryL() {
        return secondaryL;
    }
    public Person getSecondaryR() {
        return secondaryR;
    }
    public Person getTertiaryL() {
        return tertiaryL;
    }
    public Person getTertiaryR() {
        return tertiaryR;
    }

    public void deckDraw() {
        int deckSize = deckSize();
        if (deckSize <= 0) {
            return;
        }
        for (int i = 0; i < 2; i++) {
            double ind = random.nextDouble() * deckSize;
            int index = (int)ind;
            hand[i] = deck.get(index);
        }
    }

    public boolean checkSlots() {
        if (active == null) {
            return true;
        } else {
            return false;
        }
    }

    public void healthUpdate() {
        if (active.getHealth() <= 0) {
            active = null;
        }
        if (secondaryL.getHealth() <= 0) {
            secondaryL = null;
        }
        if (secondaryR.getHealth() <= 0) {
            secondaryR = null;
        }
        if (tertiaryL.getHealth() <= 0) {
            tertiaryL = null;
        }
        if (tertiaryR.getHealth() <= 0) {
            tertiaryR = null;
        }
    }

    public static void doAttack(Player attacker, int attackIndex, Player defender) {
        int attackerDamage = attacker.getActive().getAbilities().get(attackIndex).getDamage();
        if (attackerDamage > 0) {
            defender.getActive().subtractHealth(attackerDamage);
        } else {
            attacker.getActive().addHealth(attackerDamage * -1);
        }
    }
}
