package za.co.bngweny;

import za.co.bngweny.Controller.Factory;
import za.co.bngweny.Controller.GameController;
import za.co.bngweny.Model.Hero;
import za.co.bngweny.View.ConsoleView;

/**
 * Hello world!
 *
 */
public class App {

    public static void tryfin(Hero myhero) {
        myhero.setName("name");
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Hero myhero = Factory.getNewHero("Boss", "bourgeoisie", 15);
        /*
         * System.out.println(myhero.getName() + " - should be boss"); tryfin(myhero);
         * System.out.println(myhero.getName()); System.out.println(myhero);
         * GameController.saveHero(myhero);
         */
        ConsoleView start = new ConsoleView(myhero, 1);
        start.chooseHeroes();
        if (args.length >= 1) {
            System.out.println(args[0]);
        }
    }
}
