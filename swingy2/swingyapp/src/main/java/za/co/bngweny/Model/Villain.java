package za.co.bngweny.Model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

public class Villain implements Serializable
{
    @NotNull
    private String name;

    @Range(min=0, max=20000, message="point limit reached")
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

    public void takeDamage(int damage)
    {
        if (damage >= this.defence)
        {
            damage -= this.defence;
            this.health = (damage >= this.health ? 0 : this.health - damage);
            this.defence = 0;
        }
        else{
            this.defence -= damage;
        }
    }

    @Override
    public String toString()
    {
//int level, int defence, int attack, int health) {
        String output = String.format("%-10s : %15s\n","Name", this.name);
        output += String.format("%-10s : %15d\n","Level", this.level);
        output += String.format("%-10s : %15d\n","Defence", this.defence);
        output += String.format("%-10s : %15d\n","Attack", this.attack);
        output += String.format("%-10s : %15d\n","Health", this.health);
        return output;
    }
}