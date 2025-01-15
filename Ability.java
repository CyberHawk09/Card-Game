public class Ability extends Card implements Comparable{
    private int damage;
    private int attackCost;
    
    public Ability(String name, String image, int damage, int attackCost) {
        super(name, image);
        this.damage = damage;
        this.attackCost = attackCost;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getAttackCost() {
        return attackCost;
    }
    public void setAttackCost(int attackCost) {
        this.attackCost = attackCost;
    }

    public int compareTo(Ability a) {
        if (this.getName() == a.getName()) {
            return 0;
        } else {
            return this.getName().compareTo(a.getName());
        }
    }
}
