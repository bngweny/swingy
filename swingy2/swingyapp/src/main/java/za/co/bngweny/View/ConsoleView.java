package za.co.bngweny.View;


import java.util.ArrayList;
import java.util.Scanner;

import za.co.bngweny.Controller.Factory;
import za.co.bngweny.Controller.GameController;
import za.co.bngweny.Model.Artifact;
import za.co.bngweny.Model.Game;
import za.co.bngweny.Model.Hero;
import za.co.bngweny.Model.Villain;
import za.co.bngweny.Model.utils;

public class ConsoleView
{
    private Hero myhero;
    private int level;
    private  Scanner sc;

    public ConsoleView(Hero myhero, int level) {
        this.myhero = myhero;
        this.level = level;
        sc = new Scanner(System.in);
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

        System.out.println("\n Enter your number of choice");
        String output = sc.nextLine();
        int choice = Integer.parseInt(output);
        switch (choice)
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

    public int getKey()
    {
        System.out.println("up,down,left,right,exit - Enter key");
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
        else if (output.equalsIgnoreCase("exit"))
        {
            return 4;
        }
        return -1;
    }

    public void startGame()
    {
        Game game = new Game(level);
        Factory.generateVillains(game.getMap(),  level);

        Villain [][] temp = game.getMap();
       
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
                key = getKey();
             if (key < -1)
                {
                    System.out.println("Incorrect input. Try again");
                }
            }
            if (key == 4)
            {
                game.exitGame(myhero);
                break;
            }

            int out = game.move(myhero, key);
            if (out == 2)
            {
                System.out.println("\n*************************************\n");
                System.out.println("Congratulations! On to level "+ (this.level + 1));
                System.out.println("Press ENTER key to continue");
                sc.nextLine();

                nextLevel(myhero);
                break;
            }
            else if (out == 1)
            {
                System.out.println("YOU have encountered the mighty Villain.");
                System.out.println(game.getVillain(myhero.getX(), myhero.getY()));
                System.out.println("Do you want to 'fight' or do you want to 'run'?");

                String output = sc.nextLine();
                int result = game.flightORfight(myhero, output);
                if (result == 1)
                {
                    System.out.println("You lost! You failed to evade the enemy");
                    System.out.println("Press ENTER key to continue");
                    sc.nextLine();
                    break;
                }
                else if (result == 3)
                {
                    System.out.println("The Hero has fallen in Battle. GAME OVER :(");
                    System.out.println("Press ENTER key to continue");
                    sc.nextLine();
                    break;
                }
                else if (result == 2)
                {
                    System.out.println("The hero has successfully evaded the Villain!");
                    System.out.println("Press ENTER key to continue");
                    sc.nextLine();
                }
                else if (result == 0)
                {
                    System.out.println("The hero WON the battle! Yay");
                    Artifact item = Factory.generateArtifacts();
                    System.out.println("You have won an item.");
                    System.out.println(item);
                    System.out.println("Do you want to keep it? (Y/N)");
                    String outputString = sc.nextLine();
                    if (outputString.equalsIgnoreCase("Y"))
                    {
                        game.acceptArtifact(item, myhero);
                    }               
                }
                else if (result == 7)
                {
                    System.out.println("\n*************************************\n");
                    System.out.println("Congratulations!  Your courage in battle has afforded you entry into the next level "+ (this.level + 1));
                    System.out.println("Press ENTER key to continue");
                    sc.nextLine();

                    nextLevel(myhero);
                    break;
                }
            }
        }
        sc.close();
    }

    private void nextLevel(Hero myHero)
    {
        this.level += 1;
        myHero.setup(this.level);
        startGame();
    }
}