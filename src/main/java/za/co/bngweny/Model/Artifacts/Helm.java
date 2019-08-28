package za.co.bngweny.Model.Artifacts;

import java.io.Serializable;

import za.co.bngweny.Model.Artifact;
import za.co.bngweny.Model.Hero;

public class Helm implements Artifact, Serializable
{
    private static final long serialVersionUID = 4350717095288481447L;
    private String name;
    private int value;

    public Helm(){
        this.name = "Rando Helm";
        this.value = (10 + (int)(Math.random() * 60));
    }

    public Helm(String name) {
        this.name = name;
        this.value = (10 + (int)(Math.random() * 80));
    }

    public void doStuff(Hero myHero)
    {
        int hp = myHero.getHitpoints() + value;
        myHero.setHitpoints(hp);
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
        String out = String.format("%-15s: %15s\n", "Name", this.name);
        out += String.format("%-15s: %+d %s\n", "Points:", this.value, "HP");
        return out;
    }
}