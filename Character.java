import java.util.ArrayList;
public class Character extends Card{
    private int energy;
    private ArrayList<Ability> abilities = new ArrayList<Ability>();
    public Character(String position, String name, String image, ArrayList<Ability> abilities) {
        super(position, name, image);
        energy = 0;
        this.abilities = abilities;
    }

    public int getEnergy() {
        return energy;
    }
    public ArrayList<Ability> getAbilities() {
        return abilities;
    }
    public void addEnergy(int num) {
        energy += num;
    }
    public void subtractEnergy(int num) {
        energy -= num;
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
}
