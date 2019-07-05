package za.co.bngweny.Model;

import za.co.bngweny.Controller.Factory;

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

    public Villain getVillain(int x, int y)
    {
        return this.map[x][y];
    }

    private boolean isCollision(int x, int y)
    {
        return (map[x][y] != null); 
    }

    public int fight(Hero myHero) //1 = win 0 = lose
    {
       // int attDifference = this.map[myHero.getX()][myHero.getY()].getDefence() - myHero.getAttack(); // when hero attacks //take into account HP when
        //int defDifference = myHero.getDefence() - this.map[myHero.getX()][myHero.getY()].getAttack(); // when hero gets attacked
        int i = 1;
        while (myHero.getHitpoints() > 0 && this.map[myHero.getX()][myHero.getY()].getHealth() > 0)
        {
            int luckDen = (int)(Math.random() * 100); //10/100
            switch(i)
            {
                case 1 :
                    this.map[myHero.getX()][myHero.getY()].takeDamage(myHero.getAttack());
                    break;
                case -1:
                    myHero.takeDamage(this.map[myHero.getX()][myHero.getY()].getAttack());
                    break;                
            }
            if (luckDen > 90)
            {
                i = 1;
            }
            else
            {
                i = i * -1; 
            }
        }
        if (myHero.getHitpoints() <= 0)
        {
            return 3;
        }
        else
        {
            this.map[myHero.getX()][myHero.getY()] = null; //if success remove villain
            Artifact trophy = Factory.generateArtifacts();
            trophy.doStuff(myHero);
            myHero.addArtifact(trophy);
            return 0;
        }
    }

    public int run(Hero myHero)
    {
        int r = (int)(Math.random() * 10);
        System.out.println("r = "+r);
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
    {//0-win fight, 3-lose-fight, 1-fail to run, 2-successful run
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