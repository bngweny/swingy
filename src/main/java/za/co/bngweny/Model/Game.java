package za.co.bngweny.Model;

import java.io.Serializable;

import za.co.bngweny.Controller.Factory;

public class Game implements Serializable
{
    private static final long serialVersionUID = 3693145125792593067L;
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

    public void acceptArtifact(Artifact item, Hero myHero)
    {
        item.doStuff(myHero);
        myHero.addArtifact(item);
    }

    public int levelUpBasedOnXp(int xp)
    {
        int powerup = level * 1000 + (int)Math.pow((level - 1), 2) * 450;
        if (xp >= powerup)
        {
            return 7;
        }
        else {
            return 0;
        }
    }

    public int fight(Hero myHero) //1 = win 0 = lose
    {
        int i = 1;
        int power = this.map[myHero.getX()][myHero.getY()].getAttack() + this.map[myHero.getX()][myHero.getY()].getDefence() + this.map[myHero.getX()][myHero.getY()].getHealth();
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
            myHero.gainExperience(power);
            this.map[myHero.getX()][myHero.getY()] = null; //if success remove villain
            return levelUpBasedOnXp(myHero.getExperience());
        }
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
    {//0-win fight, 3-lose-fight, 1-fail to run, 2-successful run
        if (choice.equalsIgnoreCase("fight"))
        {
            int i = fight(myHero);
            if (i == 0 && reachedEdge(myHero))
            {
                return 4;
            }
            else{
                return i;
            }
        }
        else if (choice.equalsIgnoreCase("run"))
        {
            return run(myHero);
        }
        return -1;
    }

    public boolean reachedEdge(Hero myHero)
    {
        if(myHero.getX() == 0 || myHero.getY() == 0)
        {
            return true;
        }
        else if (myHero.getX() == map.length - 1  || myHero.getY() == map.length - 1)
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
            return 1;   //Collision. Fight or run
        }
        else if (reachedEdge(myhero))
        {
            myhero.setExperience(myhero.getExperience() + myhero.levelUp());
            return 2; // NO collision. Reached edge. Game over
        }
        else
        {
            return 0;   // NO collision, No enemy
        }
    }
}