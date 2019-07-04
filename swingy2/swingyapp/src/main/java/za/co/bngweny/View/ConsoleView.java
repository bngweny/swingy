package za.co.bngweny.View;


import java.util.ArrayList;
import java.util.Scanner;

import za.co.bngweny.Controller.Factory;
import za.co.bngweny.Controller.GameController;
import za.co.bngweny.Model.Game;
import za.co.bngweny.Model.Hero;
import za.co.bngweny.Model.Villain;
import za.co.bngweny.Model.utils;

public class ConsoleView
{
    private Hero myhero;
    private int level;

    public ConsoleView(Hero myhero, int level) {
        this.myhero = myhero;
        this.level = level;
    }

    public ConsoleView(int level) {
        this.level = level;
    }

    public void chooseHeroes()
    {
        ArrayList<Hero> saved = GameController.getSavedHeroes();
        if (saved.size() == 0)
        {
            System.out.println("....\nTHERE ARE CURENTLY NO SAVED HEROES!!! CREATE A NEW HERO");
            createHero();
        }
        else
        {
            int i = 0;
            for (Hero curHero : saved) {
                System.out.print(++i + ".\n" + curHero + "\n");
            }
            startGame();
        }
    }

    public void createHero()
    {
        System.out.println("Create Hero");
    }

    public void menu()
    {
        System.out.println("\n\nWELCOME TO THE GAME!!");
        System.out.println("---------OPTIONS----------");
        System.out.println("1. SELECT A HERO");
        System.out.println("2. CREATE YOUR OWN HERO");
        System.out.println("3. START GAME WITH RANDOM HERO");
        System.out.println("4. EXIT");
        System.out.println("--------------------------");
        System.out.println("NUMBER");
      //  Scanner sc = new Scanner(System.in);
    //    String output = sc.nextLine();
    //    sc.close();
        switch (3)
        {
            case 1:
                chooseHeroes();
                break;
            case 2:
                createHero();
                break;
            case 3:
                startGame();
                break;
        }
    }

    public int getKey(Scanner sc)
    {
        System.out.println("Enter key");
        String output = sc.nextLine();
  //      sc.close();
        if (output.equalsIgnoreCase("left"))
        {
            return utils.left;
        }
        else if (output.equalsIgnoreCase("right"))
        {
            return utils.right;
        }
        else if(output.equalsIgnoreCase("up"))
        {
            return utils.up;
        }
        else if (output.equalsIgnoreCase("down"))
        {
            return utils.down;
        }
        return -1;
    }

    public void startGame()
    {
        Game game = new Game(level);
        Factory.generateVillains(game.getMap(),  level);

        Villain [][] temp = game.getMap();
        

        Scanner sc = new Scanner(System.in);
        while (game != null)
        {
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[i].length; j++) {
                    if (i == myhero.getX() && j == myhero.getY())
                    {
                        System.out.print(String.format("%-5s", "0"));
                    }
                    else if (temp[i][j] != null)
                    {
                        System.out.print(String.format("%-5s", "X"));
                    }
                    else
                    {
                        System.out.print(String.format("%-5s", "-"));        
                    }            
                }
                System.out.println();
            }
            System.out.println(myhero);
            System.out.println(String.format("Player position (%d, %d)", myhero.getX(), myhero.getY()));
            System.out.println("\nEnter command (left, right, up, down) to move player");
            int key = -1;
            while (key < 0)
            {
                key = getKey(sc);
             if (key < -1)
                {
                    System.out.println("Incorrect input. Try again");
                }
            }
            int out = game.move(myhero, key);
            if (out == 2)
            {
                break;
            }
            else if (out == 1)
            {
                System.out.println("YOU have encountered the mighty Villain. Do you want to 'fight' or do you want to 'run'?");
                String output = sc.nextLine();
                game.flightORfight(myhero, output);
            }
        }
        sc.close();
    }
}