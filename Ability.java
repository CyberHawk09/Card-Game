public class Ability extends Card{
    private String description;
    private int damage;
    public Ability(String position, String name, String image, String description, int damage) {
        super(position, name, image);
        this.description = description;
        this.damage = damage;
    }

    public String getDescription() {
        return description;
    }
    public int getDamage() {
        return damage;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
