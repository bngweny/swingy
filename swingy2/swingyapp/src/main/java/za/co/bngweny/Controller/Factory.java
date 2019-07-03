package za.co.bngweny.Controller;

import java.util.logging.Level;

import za.co.bngweny.Model.Hero;
import za.co.bngweny.Model.Villain;

public class Factory {

    public static Villain[][] getMap(int level) {
        int x = (level-1)*5+10-(level%2);
        return new Villain[x][x];
    }
    //TODO generate artifacts
    public static void generateArtifacts()
    {

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
        return new Villain("named villain", 1000, 100, 100, 100);
        //TODO generate different types of villains
    }
    
    public static void generateVillains(Villain villains[][], int level)
    {
        int i = villains.length;;
        for(int j = 0; j < i; j++)
        {
            villains[(int)(Math.random() * i)][(int)(Math.random() * i)] = getRandomVillain(level);
        }
        int temp = villains.length;
        villains[temp/2][temp/2] = null;
    }
}