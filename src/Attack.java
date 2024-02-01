public class Attack {
    private String name;
    private int damage;
    public Attack(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }
    public String getName() {
        return name;
    }
}
