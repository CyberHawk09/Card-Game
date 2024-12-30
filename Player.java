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

    public void setupHand() {
        for (int i = 0; i < 2; i++) {
            double randDouble = random.nextDouble() * personDeck.size();
            int index = (int) randDouble;
            personHand.add(personDeck.get(index));
            personDeck.remove(index);
        }
        for (int i = 0; i < 2; i++) {
            double randDouble = random.nextDouble() * abilDeck.size();
            int index = (int) randDouble;
            abilHand.add(abilDeck.get(index));
            abilDeck.remove(index);
        }

    }

    public int deckSize() {
        return personDeck.size() + abilDeck.size();
    }
    public int handSize() {
        return personHand.size() + abilDeck.size();
    }
    public ArrayList<Person> getPersonHand() {
        return personHand;
    }
    public ArrayList<Ability> getAbilHand() {
        return abilHand;
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
        double ind = random.nextDouble() * deckSize;
        int index = (int)ind;
        if (index < personDeck.size()) {
            personHand.add(personDeck.get(index));
            personDeck.remove(index);
        } else {
            index -= personDeck.size();
            abilHand.add(abilDeck.get(index));
            abilDeck.remove(index);
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
