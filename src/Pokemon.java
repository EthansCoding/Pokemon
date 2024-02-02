import java.util.ArrayList;

public class Pokemon {
    private String name;
    private int HP;
    private ArrayList<Attack> attacks = new ArrayList<>();
    public Pokemon(String name, int HP) {
        this.name = name;
        this.HP = HP;
    }
    public String getName() {
        return name;
    }
    public int getHP() {
        return HP;
    }
    public void addAttack(Attack newAttack){
        if (attacks.size() < 2) {
            attacks.add(newAttack);
        }
    }
    public int useAttack(String attackName)
    {
        for (Attack a: attacks) {
            if (a.getName().equals(attackName))
            {
                return a.getDamage();
            }
        }
        return 0;
    }

    public ArrayList<Attack> getAttacks() {
        return attacks;
    }

    public void takeDamage(int damage)
    {
        HP-= damage;
    }



}
