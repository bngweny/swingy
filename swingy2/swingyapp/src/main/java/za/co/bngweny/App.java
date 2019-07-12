package za.co.bngweny;

import za.co.bngweny.Controller.Factory;
import za.co.bngweny.Controller.GameController;
import za.co.bngweny.Model.Hero;
import za.co.bngweny.View.ConsoleView;
import za.co.bngweny.View.Gui.Menu;

/**
 * Hello world!
 *
 */
public class App {

    public static void tryfin(Hero myhero) {
        myhero.setName("name");
    }

    public static void main(String[] args) {
    //    System.out.println("Hello World!");
    //    Hero myhero = Factory.getNewHero("Boss", "bourgeoisie", 1);
        // Hero myhero1 = Factory.getNewHero("Brandon", "WTC", 1);
        // Hero myhero2 = Factory.getNewHero("name", "heroclass", 1, 122, 321, 213, 432);
        /*
         * System.out.println(myhero.getName() + " - should be boss"); tryfin(myhero);
         * System.out.println(myhero.getName()); System.out.println(myhero);
         * GameController.saveHero(myhero);
         */
       //ConsoleView start = new ConsoleView(myhero, 1);
    //   ConsoleView start = new ConsoleView();

   //     GameController.saveHero(myhero);
     //   GameController.saveHero(myhero1);
      //  GameController.saveHero(myhero2);
        // System.out.println(GameController.getSavedHeroes().size());
    //    za.co.bngweny.View.Gui.GUIView.main(myhero);
     //   for (Hero var : GameController.getSavedHeroes()){
      //      System.out.println(var);
       // }
  //     Menu.main();

        //GUIView view = new GUIView();
    //    GUIView.main(args);
        if (args.length >= 1) {
            if (args[0].equalsIgnoreCase("console"))
            {
                ConsoleView start = new ConsoleView();
            }
            else if (args[0].equalsIgnoreCase("gui"))
            {
                Menu.main();
            }
        }
    }
}
