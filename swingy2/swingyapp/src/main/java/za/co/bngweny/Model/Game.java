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

    public int fight(Hero myHero) //1 = win 0 = lose
    {
        //this.map[myHero.getX()][myHero.getY()] = null; if success remove villain
        return 0;
    }

    public int run(Hero myHero)
    {
        int r = (int)(Math.random() * 10);
        if (r < 5)
        {           
            return 1; //GAME OVER
        }
        else
        {
            int temp[] = myHero.getPreviousXY();
            myHero.setX(temp[0]);
            myHero.setY(temp[1]);
            return 2; //successful run
        }
    }

    public int flightORfight(Hero myHero, String choice)
    {//0-win fight, 1-lose-fight, 1-fail to run, 2-successful run
        //  System.out.println("\n to fight or not to fight");
        if (choice.equalsIgnoreCase("fight"))
        {
            return fight(myHero);
        }
        else if (choice.equalsIgnoreCase("run"))
        {
            return run(myHero);
        }
        return -1;
    }

    public void exitGame(Hero myhero)
    {
        //TODO persist game data
    }

    public boolean reachedEdge(Hero myHero)
    {
        if(myHero.getX() == 0 || myHero.getY() == 0)
        {
            return true;
        }
        else if (myHero.getX() == map.length  || myHero.getY() == map.length)
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
                System.out.println("ERROR");
            break;
        }
        if (isCollision(myhero.getX(), myhero.getY()))
        {
            System.out.println("fight bro please");
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