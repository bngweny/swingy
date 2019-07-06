package za.co.bngweny.Model.Characters;

import za.co.bngweny.Model.Villain;

public class Warior extends Villain
{

    public Warior(String name,int level, int defence, int attack,int health) {
        super(name, level, defence, attack, health);
    }

    public Warior(String name, int level)
    {
        super(name, level, ((35 + (int)(Math.random()) * 40) + (10 * level)), ((int)(Math.random() * 25) + (5 * level)), ((int)(Math.random() * 20) + (15 * level)));
    }
}