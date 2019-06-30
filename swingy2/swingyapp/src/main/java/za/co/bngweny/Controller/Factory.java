package za.co.bngweny.Controller;

public class Factory {

    public static int[][] getMap(int level) {
        int x = (level-1)*5+10-(level%2);
        return new int[x][x];
    }

    public static Hero getNewHero(String name, String heroclass, int level)
    {
//String name, String heroclass, int level, int experience, int attack, int defence, int hitpoints
        return new Hero(name, heroclass, level, 0, 80, 80, 100);
    }
}