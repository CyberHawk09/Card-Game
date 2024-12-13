public class Ability extends Card{
    private int damage;
    private int attackCost;
    
    public Ability(String name, int damage, int attackCost) {
        super(name);
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
}
