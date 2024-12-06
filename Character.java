import java.util.ArrayList;
public class Character extends Card{
    private int energy;
    private ArrayList<Ability> abilities = new ArrayList<Ability>();
    private int health;
    final private int MAX_HEALTH;
    public Character(String position, String name, String image, ArrayList<Ability> abilities, int health, int max) {
        super(position, name, image);
        energy = 0;
        this.abilities = abilities;
        this.health = health;
        MAX_HEALTH = max;
    }

    public int getEnergy() {
        return energy;
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
}
