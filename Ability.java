/**
 * An object that contains all the information of a given Ability object in the Card-Game project.
 */
public class Ability extends Card implements Comparable{
    /**
     * The amount of damage this Ability deals. If this value is negative, it will heal by its absolute value.
     */
    private int damage;
    /**
     * The amount of energy needed to perform this Ability.
     */
    private int attackCost;

    /**
     * Constructs an Ability with the specified name, image directory, damage, and attack cost.
     * @param name the name of this Ability
     * @param damage the damage value of this Ability
     * @param attackCost the attackCost value of this Ability
     */
    public Ability(String name, int damage, int attackCost) {
        super(name);
        this.damage = damage;
        this.attackCost = attackCost;
    }

    /**
     * Returns the damage value of this Ability.
     * @return the damage value of this Ability
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Returns the attackCost value of this Ability.
     * @return the attackCost value of this Ability
     */
    public int getAttackCost() {
        return attackCost;
    }

    /**
     * Compares the name of the specified Ability with the name of this Ability lexicographically.
     * @param o the object to be compared.
     * @return an integer value representing 0 if they are equal, less than zero if the name of the specified Ability is lexicographically less, more than zero if the name of the specified Ability is lexicographically more
     */
    @Override
    public int compareTo(Object o) {
        //Cast Object o as Ability a
        Ability a;
        try {
             a = (Ability)o;
        } catch (Exception e) {
            return 1;
        }
        //Lexicographically compare names
        if (this.getName() == a.getName()) {
            return 0;
        } else {
            return this.getName().compareTo(a.getName());
        }
    }
}
