package za.co.bngweny.Controller;

import za.co.bngweny.Model.Artifact;
import za.co.bngweny.Model.Hero;
import za.co.bngweny.Model.Villain;
import za.co.bngweny.Model.utils;
import za.co.bngweny.Model.Artifacts.Armor;
import za.co.bngweny.Model.Artifacts.Helm;
import za.co.bngweny.Model.Artifacts.Weapon;
import za.co.bngweny.Model.Characters.Assassin;
import za.co.bngweny.Model.Characters.Giant;
import za.co.bngweny.Model.Characters.Warior;

public class Factory {

    public static Villain[][] getMap(int level) {
        int x = (level-1)*5+10-(level%2);
        return new Villain[x][x];
    }

    //TODO generate artifacts
    public static Artifact generateArtifacts()
    {
        int r = (int)(Math.random() * 10);
        switch(r)
        {
            case 1 :
            case 2 :
            case 3 :
                return new Armor(utils.armorNames[(int)(Math.random() * 10)]);
            case 4 :
            case 5 :
            case 6 :
                return new Weapon(utils.weaponNames[(int)(Math.random() * 12)]);
            default :
                return new Helm(utils.helmNames[0]);
        }
    }
    
    public static Hero getNewHero(String name, String heroclass, int level)
    {
        return new Hero(name, heroclass, level, 0, 80, 80, 100);
    }

    public static Hero getNewHero(String name, String heroclass, int level, int experience, int attack, int defence, int hitpoints) {
        return new Hero(name, heroclass, level, experience, attack, defence, hitpoints);
    }

    public static Hero getNewHero(String name, String heroclass, String level, String experience, String attack, String defence, String hitpoints) {
        return new Hero(name, heroclass, Integer.parseInt(level), Integer.parseInt(experience), Integer.parseInt(attack), Integer.parseInt(defence), Integer.parseInt(hitpoints));
    }

    public static Villain getRandomVillain(int level)
    {
        int r = (int)(Math.random() * 10);
        switch(r)
        {
            case 1 :
            case 2 :
            case 3 :
                return new Assassin(utils.villainNames[(int)(Math.random() * 20)], level);
            case 4 :
            case 5 :
            case 6 :
                return new Giant(utils.villainNames[(int)(Math.random() * 20)], level);
            default :
                return new Warior(utils.villainNames[(int)(Math.random() * 20)], level);
        }
        //TODO generate different types of villains
    }
    
    public static void generateVillains(Villain villains[][], int level)
    {
        int i = (int)Math.pow(villains.length, 2) / 4;
        int temp = villains.length;
        for(int j = 0; j < i; j++)
        {
            villains[(int)(Math.random() * temp)][(int)(Math.random() * temp)] = getRandomVillain(level);
        }
        villains[temp/2][temp/2] = null;
    }
}