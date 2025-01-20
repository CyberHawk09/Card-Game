import java.util.ArrayList;
import java.util.Random;

/**
 * An object that contains all information on a single player in the Card-Game project.
 */
public class Player {
    /**
     * Random object to be called upon during random actions (e.g. deckDraw).
     */
    private Random random = new Random();
    /**
     * ArrayList of type Ability that contains all the abilities in the deck that are yet to be used.
     */
    private ArrayList<Ability> deck = new ArrayList<Ability>();
    /**
     * Array of type Ability that contains maximum two abilities to be shown as options for the user to choose from.
     */
    private Ability[] hand = new Ability[2];
    /**
     * Index of the active person within the persons array.
     */
    private int active = 0;
    /**
     * Array of type Person that contains all four person cards on the board.
     */
    private Person[] persons = new Person[4];

    /**
     * Constructs a Player object with the specified ArrayList of type Ability for the deck and array of type Person for the persons.
     * @param aDeck the deck whose contents will be used for this Player's deck
     * @param persons the persons whose contents will be used for this Player's persons
     */
    public Player(ArrayList<Ability> aDeck, Person[] persons) {
        deck = aDeck;
        this.persons = persons;
    }

    /**
     * Returns the size of the deck.
     * @return the size of the deck
     */
    public int deckSize() {
        return deck.size();
    }

    /**
     * Returns the Ability at the specified position in hand.
     * @param index the index of the Ability to return
     * @return the Ability in hand at the given index
     */
    public Ability getHand(int index) {
        return hand[index];
    }

    /**
     * Returns the active Person.
     * @return the active Person
     */
    public Person getActive() {
        return persons[active];
    }

    /**
     * Returns the index of the active Person.
     * @return the index of the active Person
     */
    public int getActiveIndex() {
        return active;
    }

    /**
     * Returns the Person at the specified position in persons.
     * @param index the index of the Person to return
     * @return the Person in persons at the given index
     */
    public Person getPerson(int index) {
        return persons[index];
    }

    /**
     * Appends the specified Ability to the abilities of the Person at the specified position in persons.
     * @param index the index of the Person whose abilities is to be appended to
     * @param a the Ability to be appended to the abilities of the specified Person
     */
    public void addAbility(int index, Ability a) {
        persons[index].addAbility(a);
    }

    /**
     * Increments the energy of the Person at the specified position in persons by one.
     * @param index the index of the Person whose energy is to be incremented
     */
    public void addEnergy(int index) {
        persons[index].addEnergy(1);
    }

    /**
     * Sets the Person at the specified position in persons to be used as the active card.
     * @param index the index of the Person which is to be set as the active card
     */
    public void setActive(int index) {
        active = index;
    }

    /**
     * Draws up to two Ability cards from the deck at random depending on the size of abilities and places them in the hand.
     */
    public void deckDraw() {
        //Determine how many times to draw cards
        int deckSize = deckSize();
        int repetitions = 0;
        //Only try to draw 2 if there are at least two Ability objects in deck. Otherwise, draw as many as possible.
        if (deckSize >= 2) {
            repetitions = 2;
        } else if (deckSize == 1) {
            repetitions = 1;
        }

        //Draw from deck as many times as previously determined
        for (int i = 0; i < repetitions; i++) {
            int index = deckSize > 1 ? random.nextInt(deckSize - 1) : 0;
            hand[i] = deck.get(index);
            deck.remove(index);
        }
    }

    /**
     * Resets the deck by re-inserting the unchosen Ability from the hand back into the deck.
     * @param chosen the Ability from the hand that was chosen
     */
    public void deckReset(Ability chosen) {
        if (chosen.compareTo(hand[0]) == 0) {
            deck.add(hand[1]);
        } else {
            deck.add(hand[0]);
        }
        hand[0] = null;
        hand[1] = null;
    }

    /**
     * Checks the health of each Person in persons and returns their status.
     * @return true if all Person objects in persons have health values more than zero
     */
    public boolean checkSlots() {
        for (Person p : persons) {
            if (p.getHealth() <= 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Performs the Ability at the specified position in the abilities of the active Person of the specified Player (attacker) on the active Person of the specified Player (attacker/defender).
     * @param attacker the player whose active Person performs their Ability
     * @param attackIndex the index of the Ability to be performed on either the attacker or defender
     * @param defender the player whose active Person may have an Ability performed on
     */
    public static void doAttack(Player attacker, int attackIndex, Player defender) {
        //Get the damage and energy cost of the chosen attack
        int attackerDamage = attacker.getActive().getAbilities().get(attackIndex).getDamage();
        int attackerCost = attacker.getActive().getAbilities().get(attackIndex).getAttackCost();

        //Heal Person if damage is less than zero. Deal damage to defender if damage is more than zero.
        if (attackerDamage > 0) {
            defender.getActive().subtractHealth(attackerDamage);
        } else {
            attacker.getActive().addHealth(attackerDamage * -1);
        }

        //Remove energy from the Person performing their Ability
        attacker.getActive().subtractEnergy(attackerCost);
    }
}
