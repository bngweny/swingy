package za.co.bngweny.Model.Artifacts;

import za.co.bngweny.Model.Artifact;
import za.co.bngweny.Model.Hero;

public class Armor implements Artifact
{
    private String name;
    private int value;
    public Armor(){
        this.name = "Random Armor";
        this.value = (10 + (int)(Math.random() * 80));
    }

    public Armor(String name)
    {
        this.name = name;
        this.value = (10 + (int)(Math.random() * 80));
    }

    public void doStuff(Hero myHero)
    {
        int defence = myHero.getDefence() + value;
        myHero.setDefence(defence);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString()
    {
        String out = String.format("%-15s: %-15s\n", "Name", this.name);
        out += String.format("%-15s: %+d %s\n", "Points:", this.value, "Defence");
        return out;
    }
}