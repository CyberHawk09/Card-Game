import java.util.ArrayList;
public class Person extends Card{
    private int energy;
    private int moveCost;
    private int attackCost;
    private ArrayList<Ability> abilities = new ArrayList<Ability>();
    private int health;
    final private int MAX_HEALTH;

    public Person(String name, int moveCost, int attackCost, ArrayList<Ability> abilities, int max) {
        super(name);
        this.moveCost = moveCost;
        this.attackCost = attackCost;
        energy = 0;
        this.abilities = abilities;
        MAX_HEALTH = max;
        health = MAX_HEALTH;
    }

    public int getEnergy() {
        return energy;
    }
    public int getMoveCost() {
        return moveCost;
    }
    public int getAttackCost() {
        return attackCost;
    }
    public ArrayList<Ability> getAbilities() {
        return abilities;
    }
    public int getHealth() {
        return health;
    }
    public void addEnergy(int num) {
        if (num > 0) {
            energy += num;
        }
    }
    public void subtractEnergy(int num) {
        if (num > 0) {
            energy -= num;
        }
        if (energy < 0) {
            energy = 0;
        }
    }
    public void addAbility(Ability a) {
        boolean hasAbility = false;
        for (Ability e : abilities) {
            if (e.equals(a)) {
                hasAbility = true;
            }
        }
        if (!hasAbility) {
            abilities.add(a);
        }
    }
    public void addHealth(int num) {
        if (num > 0) {
            health += num;
        }
        if (health > MAX_HEALTH) {
            health = MAX_HEALTH; 
        }
    }
    public void subtractHealth(int num) {
        if (num > 0) {
            health -= num;
        }
        if (health < 0) {
            health = 0;
        }
    }
    public void setMoveCost(int num) {
        if (num < 0) {
            moveCost = 0;
        } else {
            moveCost = num;
        }
    }
    public void setAttackCost(int num) {
        if (num < 0) {
            attackCost = 0;
        } else {
            attackCost = num;
        }
    }

    public int abilityIndex(String name) {
        for (int i = 0; i < abilities.size(); i++) {
            if (abilities.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
