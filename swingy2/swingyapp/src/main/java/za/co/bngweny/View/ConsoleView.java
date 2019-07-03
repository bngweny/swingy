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
   //    System.out.println("yup" + output);
        output = output.toLowerCase();
        if (output == "left")
        {
            return utils.left;
        }
        else if (output == "right")
        {
            return utils.right;
        }
        else if(output == "up")
        {
            return utils.up;
        }
        else if (output == "down")
        {
            return utils.down;
        }
        return -1;
    }

    public void startGame()
    {
        Game game = new Game(level);
        Factory.generateVillains(game.getMap(),  level);
        Scanner sc = new Scanner(System.in);
        while (game != null)
        {
            System.out.println(myhero);
            System.out.println(String.format("Player position (%d, %d)", myhero.getX(), myhero.getY()));
            System.out.println("\nEnter command (left, right, up, down) to move player");
            int key = -1;
            //while (key < 0)
//            {
                key = getKey(sc);
 /*               if (key < -1)
                {
                    System.out.println("Incorrect input. Try again");
                }
            }*/
            int out = game.move(myhero, key);
            if (out == 2)
            {
                break;
            }
            else if (out == 1)
            {
                game.flightORfight(myhero);
            }
        }
        sc.close();
  /*    Villain [][] temp = game.getMap();
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                System.out.print(temp[i][j] + " ");                
            }
            System.out.println();
        }*/
    }
}