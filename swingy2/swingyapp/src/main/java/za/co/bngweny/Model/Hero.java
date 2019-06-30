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
    private int experience, attack, defence, hitpoints;

    public Hero(String name, String heroclass, int level, int experience, int attack, int defence, int hitpoints) {
        this.name = name;
        this.heroclass = heroclass;
        this.level = level;
        this.experience = experience;
        this.attack = attack;
        this.defence = defence;
        this.hitpoints = hitpoints;
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
}