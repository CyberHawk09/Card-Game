public class Ability extends Card{
    String description;
    int damage;
    public Ability(String pos, String name, String image, String description, int damage) {
        super(pos, name, image);
        this.description = description;
        this.damage = damage;
    }
}
