package za.co.bngweny.Controller;

import java.util.ArrayList;
import java.io.*;

import za.co.bngweny.Model.Hero;

public class GameController {
    public static ArrayList<Hero> getSavedHeroes() {
        ArrayList<Hero> heroeslist = null;
        try {
            FileInputStream fileIn = new FileInputStream("src/main/java/za/co/bngweny/Database/Heroes.txt");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         heroeslist = (ArrayList<Hero>)in.readObject();
         in.close(); 
         fileIn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return (heroeslist == null ? new ArrayList<Hero>() : heroeslist);
    }

    public static void saveHero(Hero myHero) {
        ArrayList<Hero> heroeslist = getSavedHeroes();
        boolean exists = false;
        for (Hero var : heroeslist) {
            if (var.getName().equals(myHero.getName()))
            {
                exists = true;
                var = myHero;
                break;
            }
        }
        if (!exists)
        {
            heroeslist.add(myHero);
        }
        try
        {
            FileOutputStream fos = new FileOutputStream("src/main/java/za/co/bngweny/Database/Heroes.txt", false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(heroeslist);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}