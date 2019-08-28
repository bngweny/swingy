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
import za.co.bngweny.View.Gui.GUIView;
import za.co.bngweny.View.Gui.Menu;

public class ConsoleView {
    private Hero myhero;
    private int level;
    private Scanner sc;

    public ConsoleView(Hero myhero, int level) {
        this.myhero = myhero;
        this.level = myhero.getLevel();
        sc = new Scanner(System.in);
    }

    public ConsoleView(Game game, Hero myhero) {
        this.myhero = myhero;
        this.level = myhero.getLevel();
        if (sc != null) {
            sc.close();
        }
        sc = new Scanner(System.in);
        startGame(game);
    }

    public ConsoleView() {
        sc = new Scanner(System.in);
        menu();
    }

    public ConsoleView(int level) {
        this.level = level;
    }

    public void chooseHeroes() {
        ArrayList<Hero> saved = GameController.getSavedHeroes();
        if (saved.size() == 0) {
            System.out.println("....\nTHERE ARE CURENTLY NO SAVED HEROES!!! CREATE A NEW HERO");
            System.out.println("Press ENTER key to continue");
            sc.nextLine();
            createHero();
        } else {
            int i = 0;
            for (Hero curHero : saved) {
                System.out.print(++i + ".\n" + curHero + "\n");
            }
            System.out.println("\n Enter your number of choice");
            String output = sc.nextLine();
            if (output.equalsIgnoreCase("back") || output.equalsIgnoreCase("exit")) {
                menu();
            } else {
                int choice = -1;
                try {
                    choice = Integer.parseInt(output);
                } catch (NumberFormatException ex) {
                    System.out.println("You must enter a number");
                }
                if (choice > -1 && choice <= saved.size()) {
                    this.myhero = saved.get(choice - 1);
                    this.level = myhero.getLevel();
                    startGame(null);
                } else {
                    System.out.println("Try again");
                    System.out.println("Press ENTER key to continue");
                    sc.nextLine();
                    chooseHeroes();
                }
            }
        }
    }

    public void createHero() {
        System.out.println("Create Hero\n");
        System.out.println("1.\nHeroClass : Warrior\nDefence   : 45\nAttack\t  : 95\nHit Points: 60\n");
        System.out.println("2.\nHeroClass : Shield\nDefence   : 95\nAttack\t  : 60\nHit Points: 75\n");
        System.out.println("3.\nHeroClass : Balanced\nDefence   : 70\nAttack\t  : 70\nHit Points: 67\n");
        System.out.println("\n Enter your number of choice");
        String output = sc.nextLine();
        if (output.equalsIgnoreCase("1")) {
            output = "";
            while (output.equals("")) {
                System.out.println("\nEnter your Hero name");
                output = sc.nextLine();
            }
            this.myhero = Factory.getNewHero(output, "Warrior", 1, 0, 95, 45, 60);
        } else if (output.equalsIgnoreCase("2")) {
            output = "";
            while (output.equals("")) {
                System.out.println("\nEnter your Hero name");
                output = sc.nextLine();
            }
            this.myhero = Factory.getNewHero(output, "Shield", 1, 0, 60, 95, 75);
        } else if (output.equalsIgnoreCase("3")) {
            output = "";
            while (output.equals("")) {
                System.out.println("\nEnter your Hero name");
                output = sc.nextLine();
            }
            this.myhero = Factory.getNewHero(output, "Balanced", 1, 0, 70, 70, 67);
        } else {
            System.out.println("ERROR Incorrect input");
            System.out.println("Press ENTER key to continue");
            sc.nextLine();
            menu();
            return;
        };
        this.level = myhero.getLevel();
        System.out.println("Hero created successfully!\n\nPress ENTER key to continue");
        sc.nextLine();
        startGame(null);
    }

    public void switchtoGui(Game game) {
        if (game == null || myhero == null) {
            Menu.main();
        } else {
            GUIView.main(game, this.myhero);
        }
    }

    public void menu() {
        System.out.println("\n\nWELCOME TO THE GAME!!");
        System.out.println("---------OPTIONS----------");
        System.out.println("1. SELECT A HERO");
        System.out.println("2. CREATE YOUR OWN HERO");
        System.out.println("3. RESUME");
        System.out.println("4. SWITCH TO GUI");
        System.out.println("5. EXIT");
        System.out.println("--------------------------");
        System.out.println("NUMBER");
        System.out.println("\n Enter your number of choice");
        String output = sc.nextLine();

        if (output.equalsIgnoreCase("1")) {
            chooseHeroes();
        } else if (output.equalsIgnoreCase("2")) {
            createHero();
        } else if (output.equalsIgnoreCase("3")) {
            resume();
        } else if (output.equalsIgnoreCase("4")) {
            switchtoGui(null);
        } else if (output.equalsIgnoreCase("5")) {
            System.out.println("............");
        } else {
            System.out.println("Wrong input! Let's try that again");
            System.out.println("Press ENTER key to continue");
            sc.nextLine();
            menu();
        }
    }

    private void resume() {
        ArrayList<Object> gamestate = GameController.getGameState();
        if (gamestate.size() == 0) {
            System.out.println("....\nTHERE ARE NO SAVED GAMES.");
            System.out.println("Press ENTER key to continue");
            sc.nextLine();
            menu();
        } else {
            this.myhero = (Hero) gamestate.get(1);
            startGame((Game) gamestate.get(0));
        }
    }

    public int getKey() {
        System.out.println("north,south,west,east,exit,save,gui - Enter key");
        String output = sc.nextLine();
        if (output.equalsIgnoreCase("west")) {
            return utils.left;
        } else if (output.equalsIgnoreCase("east")) {
            return utils.right;
        } else if (output.equalsIgnoreCase("north")) {
            return utils.up;
        } else if (output.equalsIgnoreCase("south")) {
            return utils.down;
        } else if (output.equalsIgnoreCase("exit")) {
            return 4;
        } else if (output.equalsIgnoreCase("save")) {
            return 5;
        } else if (output.equalsIgnoreCase("gui")) {
            return 6;
        }
        return -1;
    }

    public void startGame(Game game) {
        boolean gameover = false;
        if (game == null) {
            game = new Game(level);
            Factory.generateVillains(game.getMap(), level);
        }
        Villain[][] temp = game.getMap();

        while (game != null) {
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[i].length; j++) {
                    if (i == myhero.getX() && j == myhero.getY()) {
                        System.out.print(String.format("%-5s", "0"));
                    } else if (temp[i][j] != null) {
                        System.out.print(String.format("%-5s", "*"));
                    } else {
                        System.out.print(String.format("%-5s", "*"));
                    }
                }
                System.out.println();
            }
            System.out.println(myhero);
            System.out.println(String.format("Player position (%d, %d)", myhero.getX(), myhero.getY()));
            System.out.println("\nEnter command (left, right, up, down) to move player");
            int key = -1;
            while (key < 0) {
                key = getKey();
                if (key < -1) {
                    System.out.println("Incorrect input. Try again");
                }
            }
            if (key == 4) {
                GameController.saveGameState(game, this.myhero);
                break;
            }
            if (key == 5) {
                GameController.saveHero(myhero);
                System.out.println("Hero saved successfully!\n\n");
            } else if (key == 6) {
                switchtoGui(game);
                break;
            } else {
                int out = game.move(myhero, key);
                if (out == 2) {
                    System.out.println("\n*************************************\n");
                    System.out.println("Congratulations! On to level " + (this.level + 1));
                    System.out.println("Press ENTER key to continue");
                    sc.nextLine();

                    nextLevel(myhero);
                    break;
                } else if (out == 1) {
                    System.out.println("YOU have encountered the mighty Villain.");
                    System.out.println(game.getVillain(myhero.getX(), myhero.getY()));

                    String output = "";
                    while (!output.equalsIgnoreCase("fight") && !output.equalsIgnoreCase("run")) {
                        System.out.println("Do you want to 'fight' or do you want to 'run'?");
                        output = sc.nextLine();
                    }
                    int result = game.flightORfight(myhero, output);
                    if (result == 1) {
                        System.out.println("You lost! You failed to evade the enemy");
                        System.out.println("Press ENTER key to continue");
                        sc.nextLine();
                        gameover = true;
                        break;
                    } else if (result == 3) {
                        System.out.println("The Hero has fallen in Battle. GAME OVER :(");
                        System.out.println("Press ENTER key to continue");
                        sc.nextLine();
                        gameover = true;
                        break;
                    } else if (result == 2) {
                        System.out.println("The hero has successfully evaded the Villain!");
                        System.out.println("Press ENTER key to continue");
                        sc.nextLine();
                    } else if (result == 0) {
                        System.out.println("The hero WON the battle! Yay");
                        System.out.println("Press ENTER key to continue");
                        sc.nextLine();
                        if ((Math.random() * 100) >= 70) {
                            Artifact item = Factory.generateArtifacts();
                            System.out.println("You have won an item.");
                            System.out.println(item);
                            System.out.println("Do you want to keep it? (Y/N)");
                            String outputString = sc.nextLine();
                            if (outputString.equalsIgnoreCase("Y")) {
                                game.acceptArtifact(item, myhero);
                            }
                        }
                    } else if (result == 7 || result == 4) {
                        System.out.println("\n*************************************\n");
                        System.out.println(
                                "Congratulations!  Your courage in battle has afforded you entry into the next level "
                                        + (this.level + 1));
                        System.out.println("Press ENTER key to continue");
                        sc.nextLine();

                        nextLevel(myhero);
                        break;
                    }
                }
            }
        }
        if (gameover) {
            sc.close();
        }
    }

    private void nextLevel(Hero myHero) {
        this.level += 1;
        myHero.setup(this.level);
        startGame(null);
    }
}