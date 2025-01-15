import java.util.ArrayList;
import java.util.Random;
public class Player {
    private Random random = new Random();
    private ArrayList<Ability> deck = new ArrayList<Ability>();
    private Ability[] hand = new Ability[2];
    private int active = 0;
    private Person[] persons = new Person[4];

    public Player(ArrayList<Ability> aDeck, Person[] persons) {
        deck = aDeck;
        this.persons = persons;
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
        return persons[active];
    }
    public int getActiveIndex() {
        return active;
    }
    public Person getPerson(int index) {
        return persons[index];
    }
    public void addAbility(int index, Ability a) {
        persons[index].addAbility(a);
    }
    public void addEnergy(int index) {
        persons[index].addEnergy(1);
    }
    public void setActive(int index) {
        active = index;
    }

    public void deckDraw() {
        int deckSize = deckSize();
        int repetitions = 0;
        if (deckSize >= 2) {
            repetitions = 2;
        } else if (deckSize == 1) {
            repetitions = 1;
        }
        for (int i = 0; i < repetitions; i++) {
            //double ind = random.nextDouble() * deckSize - 1;
            //int index = (int)ind;
            int index = random.nextInt(deckSize - 1);
            hand[i] = deck.get(index);
            deck.remove(index);
        }
    }
    public void deckReset(Ability chosen) {
        if (chosen.compareTo(hand[0]) == 0) {
            deck.add(hand[1]);
        } else {
            deck.add(hand[0]);
        }
        hand[0] = null;
        hand[1] = null;
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
