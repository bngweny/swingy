package za.co.bngweny;

import za.co.bngweny.View.ConsoleView;
import za.co.bngweny.View.Gui.Menu;

public class App {

    public static void main(String[] args) {

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
        else if (args.length == 0)
        {
            Menu.main();
        }
    }
}
