package za.co.bngweny.Controller;

import java.util.ArrayList;
import java.io.*;

import za.co.bngweny.Model.Hero;

public class GameController {
    public static ArrayList<Hero> getSavedHeroes() {
        ArrayList<Hero> heroeslist = new ArrayList<Hero>();
        try {
            FileReader file = new FileReader(new File("src/main/java/za/co/bngweny/Database/Heroes.txt"));
            BufferedReader reader = new BufferedReader(file);

            String line = reader.readLine();
            while (line != null) {
                String cmd[] = line.split(",");
                if (cmd.length == 7)
                {
                    heroeslist.add(Factory.getNewHero(cmd[0], cmd[1], cmd[2], cmd[3], cmd[4], cmd[5], cmd[6]));
                }
                else
                {
                    //TODO Exception abt length
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return heroeslist;
    }

    public static void saveHero(Hero myHero) {
        System.out.println("saveHero");
    }
}