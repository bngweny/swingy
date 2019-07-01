package za.co.bngweny.Model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class Hero
{
    @NotNull
    private String name;
    @NotNull
    private String heroclass;
    @Range(min=0, max=100, message="Honourable member dont do dat")
    private int level;
    private int experience, attack, defence;
    private int hitpoints; //An numeral indication of how much damage a character can sustain. The loss of all hit points results in the death of the character
    private int x, y;

    public Hero(String name, String heroclass, int level, int experience, int attack, int defence, int hitpoints) {
        this.name = name;
        this.heroclass = heroclass;
        this.level = level;
        this.experience = experience;
        this.attack = attack;
        this.defence = defence;
        this.hitpoints = hitpoints;
        x = ((level-1)*5+10-(level%2)) / 2;
        y = x;
    }

    public Hero(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeroclass() {
        return heroclass;
    }

    public void setHeroclass(String heroclass) {
        this.heroclass = heroclass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
// public Hero(String name, String heroclass, int level, int experience, int attack, int defence, int hitpoints) {
    @Override
    public String toString()
    {
        String output = String.format("-10%s : 15%s\n","Name", this.name);
        output += String.format("-10%s : 15%s\n","Class", this.heroclass);
        output += String.format("-10%s : 15%d\n","Level", this.level);
        output += String.format("-10%s : 15%d\n","Experience", this.experience);
        output += String.format("-10%s : 15%d\n","Attack", this.attack);
        output += String.format("-10%s : 15%d\n","Defence", this.defence);
        output += String.format("-10%s : 15%d","Hitpoints", this.hitpoints);
        return output;
    }

}