package za.co.bngweny.Model.Characters;

import za.co.bngweny.Model.Villain;

public class Giant extends Villain {

    public Giant() {
    }

    public Giant(String name, int level, int defence, int attack, int health) {
        super(name, level, defence, attack, health);
    }

    public Giant(String name, int level)
    {
        super(name, level, ((45 + (int)(Math.random() * 50)) + (10 * level)), ((int)(Math.random() * 25) + (15 * level)), ((int)(Math.random() * 20) + (10 * level)));
    }
    
}