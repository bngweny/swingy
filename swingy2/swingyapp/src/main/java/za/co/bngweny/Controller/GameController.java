package za.co.bngweny.Controller;

import java.util.ArrayList;
import java.io.*;
import za.co.bngweny.Model.Hero;

public class GameController {
    public static ArrayList<Hero> getSavedHeroes() {
        ArrayList<Hero> heroeslist = new ArrayList<Hero>();
        try {
            FileReader file = new FileReader("../Database/heroes.txt");
            BufferedReader reader = new BufferedReader(file);

            String line = reader.readLine();      
            while (line != null) {
                String cmd[] = line.split(" ");
                heroeslist.add(Factory.getNewHero(cmd[0], cmd[1], cmd[2], cmd[3], cmd[4], cmd[5], cmd[6]));
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception ex) {

        }
        return null;
    }

    public static void saveHero(Hero myHero) {
        System.out.println("saveHero");
    }
}