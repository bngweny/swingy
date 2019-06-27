package za.co.bngweny.Model.Artifacts;

import za.co.bngweny.Model.Artifact;
import za.co.bngweny.Model.Hero;

public class Weapon implements Artifact
{

    private String name;
    private int value;

    public Weapon(){
        this.name = "Rando Weapon";
        this.value = (10 + (int)(Math.random() * 80));
    }

    public Weapon(String name){
        this.name = name;
        this.value = (10 + (int)(Math.random() * 80));
    }

    public void doStuff(Hero myHero)
    {
        
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
}