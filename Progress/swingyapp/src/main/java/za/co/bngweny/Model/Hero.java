package za.co.bngweny.Model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;


public class Hero implements Serializable
{
    private static final long serialVersionUID = -9187020593331216877L;
    @NotNull
    private String name;
    @NotNull
    private String heroclass;
    @Range(min=0, max=45, message="Level limit reached")
    private int level;
    @Range(min=0, max=20000, message="Points limit reached")
    private int experience, attack, defence;
    @Range(min=0, max=20000, message="HP limit reached")
    private int hitpoints; //An numeral indication of how much damage a character can sustain. The loss of all hit points results in the death of the character
    private int x, y;
    private int previousXY[];
    private ArrayList<Artifact> artifacts;

    public Hero(String name, String heroclass, int level, int experience, int attack, int defence, int hitpoints) {
        this.name = name;
        this.heroclass = heroclass;
        this.level = level;
        this.experience = experience;
        this.attack = attack;
        this.defence = defence;
        this.hitpoints = hitpoints;
        setup(level);
        artifacts = new ArrayList<Artifact>();
    }

    public void setup(int level)
    {
        this.level = level;
        this.x = ((level-1)*5+10-(level%2));
        this.x = this.x/2;
        this.y = this.x;
        this.previousXY =  new int[2];
        this.previousXY[0] = this.x;
        this.previousXY[1] = this.y;
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

    public void levelUp()
    {
        level = level*1000 + (int)Math.pow((level - 1), 2) * 450;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveLeft() //TODO end game when edge reached
    {
        previousXY[0] = x; 
        previousXY[1] = y;
        --y;
    }

    public void moveRight()
    {
        previousXY[0] = x; 
        previousXY[1] = y;
        ++y;
    }

    public void moveDown()
    {
        previousXY[0] = x;
        previousXY[1] = y;        
        ++x;
    }

    public void moveUp()
    {
        previousXY[0] = x;
        previousXY[1] = y;
        --x;
    }

    /**
     * @return the previousXY
     */
    public int[] getPreviousXY() {
        return previousXY;
    }

    public void takeDamage(int damage)
    {
        if (damage >= this.defence)
        {
            damage -= this.defence;
            this.hitpoints = (damage >= this.hitpoints ? 0 : this.hitpoints - damage);
            this.defence = 0;
        }
        else{
            this.defence -= damage;
        }
    }

// public Hero(String name, String heroclass, int level, int experience, int attack, int defence, int hitpoints) {
    @Override
    public String toString()
    {
        String output = String.format("%-10s : %15s\n","Name", this.name);
        output += String.format("%-10s : %15s\n","Class", this.heroclass);
        output += String.format("%-10s : %15d\n","Level", this.level);
        output += String.format("%-10s : %15d\n","Experience", this.experience);
        output += String.format("%-10s : %15d\n","Attack", this.attack);
        output += String.format("%-10s : %15d\n","Defence", this.defence);
        output += String.format("%-10s : %15d","Hitpoints", this.hitpoints);
        return output;
    }

    public ArrayList<Artifact> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(ArrayList<Artifact> artifacts) {
        this.artifacts = artifacts;
    }

    public void addArtifact(Artifact newArtifact)
    {
        this.artifacts.add(newArtifact);
    }

    public void gainExperience(int exp)
    {
        this.experience += exp * 1.5;
    }
}