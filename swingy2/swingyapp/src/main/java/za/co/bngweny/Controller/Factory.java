package za.co.bngweny.Controller;

import za.co.bngweny.Model.Hero;

public class Factory {

    public static Hero[][] getMap(int level) {
        int x = (level-1)*5+10-(level%2);
        return new Hero[x][x];
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
    
    public static void generateVillains(Hero map[][])
    {
        
    }
}