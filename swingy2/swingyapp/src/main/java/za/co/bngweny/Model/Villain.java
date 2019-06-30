package za.co.bngweny.Model;

public class Villain
{
    private String name;

    private int level, defence, attack, health;
    public Villain()
    {    
    }

    public Villain(String name, int level, int defence, int attack, int health) {
        this.name = name;
        this.level = level;
        this.defence = defence;
        this.attack = attack;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
}