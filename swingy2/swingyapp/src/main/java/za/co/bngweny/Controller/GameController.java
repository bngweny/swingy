package za.co.bngweny.Controller;

import java.util.ArrayList;
import java.io.*;

import za.co.bngweny.Model.Game;
import za.co.bngweny.Model.Hero;

public class GameController {
    public static ArrayList<Hero> getSavedHeroes() {
        ArrayList<Hero> heroeslist = null;
        try {
            FileInputStream fileIn = new FileInputStream("src/main/java/za/co/bngweny/Database/Heroes.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            heroeslist = (ArrayList<Hero>) in.readObject();
            in.close();
            fileIn.close();
        } catch (EOFException ex) {
            System.out.println("End of file");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return (heroeslist == null ? new ArrayList<Hero>() : heroeslist);
    }

    public static void saveHero(Hero myHero) {
        ArrayList<Hero> heroeslist = getSavedHeroes();
        boolean exists = false;
        for (int i = 0; i < heroeslist.size(); i++) {
            if (heroeslist.get(i).getName().equals(myHero.getName())) {
                exists = true;
                heroeslist.remove(i);
                heroeslist.add(myHero);
                break;
            }
        }
        if (!exists) {
            heroeslist.add(myHero);
        }
        try {
            FileOutputStream fos = new FileOutputStream("src/main/java/za/co/bngweny/Database/Heroes.txt", false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(heroeslist);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void deleteHero(Hero myHero) {
        ArrayList<Hero> heroeslist = getSavedHeroes();
        for (int i = 0; i < heroeslist.size(); i++) {
            if (heroeslist.get(i).getName().equals(myHero.getName())) {
                heroeslist.remove(i);
                try {
                    FileOutputStream fos = new FileOutputStream("src/main/java/za/co/bngweny/Database/Heroes.txt",
                            false);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(heroeslist);
                    oos.close();
                    fos.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
                break;
            }
        }
    }

    public static ArrayList<Object> getGameState()
    {
        ArrayList<Object> gamestate = null;
        try {
            FileInputStream fileIn = new FileInputStream("src/main/java/za/co/bngweny/Database/gamestate.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            gamestate = (ArrayList<Object>) in.readObject();
            in.close();
            fileIn.close();
        } catch (EOFException ex) {
            System.out.println("End of file");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return (gamestate == null ? new ArrayList<Object>() : gamestate);
    }

    public static void saveGameState(Game game, Hero myHero) {
        ArrayList<Object> gamestate = new ArrayList<Object>();
        gamestate.add(game);
        gamestate.add(myHero);
        try {
            FileOutputStream fos = new FileOutputStream("src/main/java/za/co/bngweny/Database/gamestate.txt", false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(gamestate);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}