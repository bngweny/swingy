package za.co.bngweny.Model;

import za.co.bngweny.Controller.Factory;

public class Game {
    private int level;
    private int map[][];

    public Game(int level) {
        this.level = level;
        this.map = Factory.getMap(level);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }
}