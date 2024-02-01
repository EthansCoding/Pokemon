public class Pokemon {
    private String name;
    private int HP;
    private Attack attack1;
    private Attack attack2;
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
        if (attack1 == null) {
            attack1 = newAttack;
        }
        else if (attack2 == null)
        {
            attack2 = newAttack;
        }
    }
    public int useAttack(String attackName)
    {
        if (attack1 != null)
        {
            if (attack1.getName().equals(attackName)) {
                return attack1.getDamage();
            }
        }
        else if (attack2 != null)
        {
            if (attack2.getName().equals(attackName))
            {
                return attack2.getDamage();
            }
        }
        return 0;
    }
    public void takeDamage(int damage)
    {
        HP-= damage;
    }



}
