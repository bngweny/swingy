package za.co.bngweny.Model.Characters;

import za.co.bngweny.Model.Hero;

public class Warior extends Hero
{

    public Warior(String name, String heroclass, int level, int experience, int attack, int defence, int hitpoints) {
        super(name, heroclass, level, experience, attack, defence, hitpoints);
    }

    public Warior(String name, int level) {
        super(name, level);
    }
    
}