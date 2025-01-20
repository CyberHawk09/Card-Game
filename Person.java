import java.util.ArrayList;

/**
 * An object that contains all the information of a given Person object in the Card-Game project
 */
public class Person extends Card implements Copyable{
    /**
     * The amount of energy this Person has.
     */
    private int energy;
    /**
     * An ArrayList of type Ability with all the abilities this Person can perform.
     */
    private ArrayList<Ability> abilities = new ArrayList<Ability>();
    /**
     * The amount of health this Person has.
     */
    private int health;
    /**
     * The maximum amount of health this Person can have.
     */
    final private int MAX_HEALTH;

    /**
     * Constructs a Person object with the specified name, abilities, and maximum health.
     * @param name the name of this Person
     * @param abilities the ArrayList of type Ability to be used as the abilities for this Person
     * @param max the maximum amount of health this Person can have
     */
    public Person(String name, ArrayList<Ability> abilities, int max) {
        super(name);
        this.abilities = abilities;
        MAX_HEALTH = max;
        energy = 0;
        health = MAX_HEALTH;
    }

    /**
     * Returns the energy of this Person.
     * @return the energy of this Person
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * Returns the abilities of this Person.
     * @return an ArrayList of type Ability representing the abilities of the Person
     */
    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    /**
     * Returns the health of this Person.
     * @return the health of this Person
     */
    public int getHealth() {
        return health;
    }

    /**
     * Returns the maximum amount of health for this Person.
     * @return the maximum amount of health for this Person
     */
    public int getMaxHealth() {
        return MAX_HEALTH;
    }

    /**
     * Increments the energy value of this Person by the specified positive number.
     * @param num the positive number to increment the energy value of this Person by
     */
    public void addEnergy(int num) {
        if (num > 0) {
            energy += num;
        }
    }

    /**
     * Decrements the energy value of this Person by the specified positive number. Energy will not drop below 0.
     * @param num the positive number to decrement the energy value of this Person by
     */
    public void subtractEnergy(int num) {
        if (num > 0) {
            energy -= num;
        }
        if (energy < 0) {
            energy = 0;
        }
    }

    /**
     * Appends the specified Ability to the end of the abilities of this Person.
     * @param a the specified Ability to be appended to the abilities of this Person
     */
    public void addAbility(Ability a) {
        //Check if Ability is already in abilities of this Person
        boolean hasAbility = false;
        for (Ability e : abilities) {
            if (e.equals(a)) {
                hasAbility = true;
            }
        }
        //Do not add Ability if it already has it
        if (!hasAbility) {
            abilities.add(a);
        }
    }

    /**
     * Increments the health value of this Person by the specified positive number. Health will not exceed MAX_HEALTH.
     * @param num the positive number to increment the health value by
     */
    public void addHealth(int num) {
        if (num > 0) {
            health += num;
        }
        if (health > MAX_HEALTH) {
            health = MAX_HEALTH; 
        }
    }

    /**
     * Decrements the health value of this Person by the specified positive number. Health will not drop below 0.
     * @param num the positive number to decrement the health value by
     */
    public void subtractHealth(int num) {
        if (num > 0) {
            health -= num;
        }
        if (health < 0) {
            health = 0;
        }
    }

    /**
     * Returns a copy of this Person without using a reference.
     * @return a copy of this Person
     */
    public Person copy() {
        Object o = getAbilities().clone();
        ArrayList<Ability> a = (ArrayList<Ability>)o;
        return new Person(getName(), a, getMaxHealth());
    }
}
