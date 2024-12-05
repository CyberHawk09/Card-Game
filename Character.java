import java.util.ArrayList;
public class Character extends Card{
    int energy;
    ArrayList<Ability> abilities = new ArrayList<Ability>();
    public Character(String pos, String name, String image, ArrayList<Ability> abilities) {
        super(pos, name, image);
        energy = 0;
        this.abilities = abilities;
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
