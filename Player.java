import java.util.ArrayList;
import java.util.Random;
public class Player {
    private Random random = new Random();
    private ArrayList<Ability> deck = new ArrayList<Ability>();
    private Ability[] hand = new Ability[2];
    private Person active = null;
    private Person[] persons = new Person[4];

    public Player(ArrayList<Ability> aDeck) {
        deck = aDeck;
    }

    public int deckSize() {
        return deck.size();
    }
    public int handSize() {
        return deck.size();
    }
    public Ability getHand(int index) {
        return hand[index];
    }

    public Person getActive() {
        return active;
    }
    public void addAbility(int index, Ability a) {
        persons[index].addAbility(a);
    }
    public void addEnergy(int index) {
        persons[index].addEnergy(1);
    }
    public void setActive(int index) {
        active = persons[index];
    }

    public void deckDraw() {
        int deckSize = deckSize();
        if (deckSize >= 2) {
            for (int i = 0; i < 2; i++) {
                double ind = random.nextDouble() * deckSize;
                int index = (int)ind;
                hand[i] = deck.get(index);
            }
        } else if (deckSize == 1) {
            double ind = random.nextDouble() * deckSize;
            int index = (int)ind;
            hand[0] = deck.get(index);
            hand[1] = null;
        }
    }

    public boolean checkSlots() {
        for (Person p : persons) {
            if (p.getHealth() <= 0) {
                return false;
            }
        }
        return true;
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
