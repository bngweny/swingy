package za.co.bngweny.Model.Characters;

import za.co.bngweny.Model.Hero;

public class Healer extends Hero
{

    private static final long serialVersionUID = 7680421171341299243L;

    public Healer(String name, String heroclass, int level, int experience, int attack, int defence, int hitpoints) {
        super(name, heroclass, level, experience, attack, defence, hitpoints);
    }

    public Healer(String name, int level) {
        super(name, level);
    }
    
}