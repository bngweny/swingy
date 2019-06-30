package za.co.bngweny.Controller;

import za.co.bngweny.Model.Hero;

public class Factory {

    public static int[][] getMap(int level) {
        int x = (level-1)*5+10-(level%2);
        return new int[x][x];
    }

    public static Hero getNewHero(String name, String heroclass, int level)
    {
        return new Hero(name, heroclass, level, 0, 80, 80, 100);
    }
}