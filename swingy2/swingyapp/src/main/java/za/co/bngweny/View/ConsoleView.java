package za.co.bngweny.View;


import java.util.ArrayList;

import za.co.bngweny.Controller.Factory;
import za.co.bngweny.Controller.GameController;
import za.co.bngweny.Model.Game;
import za.co.bngweny.Model.Hero;
import za.co.bngweny.Model.Villain;

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
        System.out.println("3. EXIT");
        System.out.println("--------------------------");
    }

    public void startGame()
    {
        Game game = new Game(level);
        Factory.generateVillains(game.getMap(),  level);
  /*    Villain [][] temp = game.getMap();
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                System.out.print(temp[i][j] + " ");                
            }
            System.out.println();
        }*/
    }
}