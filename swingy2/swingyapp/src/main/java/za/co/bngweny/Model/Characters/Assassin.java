package za.co.bngweny.Model.Characters;

import za.co.bngweny.Model.Villain;

public class Assassin extends Villain{

    public Assassin() {
    }

    public Assassin(String name, int level, int defence, int attack, int health) {
        super(name, level, defence, attack, health);
    }

    public Assassin(String name, int level)
    {
        super(name, level, ((40 + (int)(Math.random() * 40)) + (15 * level)), ((int)(Math.random() * 25) + (15 * level)), ((int)(Math.random() * 20) + (15 * level)));
    }
    
}