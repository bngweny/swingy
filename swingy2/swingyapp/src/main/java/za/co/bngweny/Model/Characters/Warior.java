package za.co.bngweny.Model.Characters;

import za.co.bngweny.Model.Villain;

public class Warior extends Villain
{

    public Warior(String name,int level, int defence, int attack,int health) {
        super(name, level, defence, attack, health);
    }

    public Warior(String name, int level)
    {
        super(name, level, 100, 100, 100);
    }
    
}