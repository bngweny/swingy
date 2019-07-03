package za.co.bngweny.Model;

import za.co.bngweny.Controller.Factory;
import za.co.bngweny.*;

public class Game {
    private int level;
    private Villain map[][];


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

    public Villain[][] getMap() {
        return map;
    }

    public void setMap(Villain[][] map) {
        this.map = map;
    }

    private boolean isCollision(int x, int y)
    {
        return (map[x][y] != null); 
    }

    public void flightORfight(Hero myHero)
    {
        System.out.println("\n to fight or not to fight");
    }

    public boolean reachedEdge(Hero myHero)
    {
        if(myHero.getX() == 0 || myHero.getY() == 0)
        {
            return true;
        }
        else if (myHero.getX() == map.length || myHero.getY() == map.length)
        {
            return true;
        }
        else{
            return false;
        }
    }

    public int move(Hero myhero, int direction)
    {
        switch(direction)
        {
            case 0 : //left
                myhero.moveLeft();
                break;
            case 1  : //right
                myhero.moveRight();
                break;
            case 2 : //up
                myhero.moveUp();
                break;
            case 3 : //down
                myhero.moveDown();
                break;
            default :
                //TODO error
            break;
        }
        if (isCollision(myhero.getX(), myhero.getY()))
        {
            return 1;   //Collision. Fight or run
        }
        else if (reachedEdge(myhero))
        {
            return 2; // NO collision. Reached edge. Game over
        }
        else
        {
            return 0;   // NO collision, No enemy
        }
    }
}