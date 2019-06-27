package za.co.bngweny;

import za.co.bngweny.Model.Hero;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void tryfin(Hero myhero)
    {
        myhero.setName("name");
    }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Hero myhero = new Hero("Boss", 23);
        System.out.println(myhero.getName() + " - should be boss");
        tryfin(myhero);
        System.out.println(myhero.getName());

        if (args.length >= 1)
        {
            System.out.println(args[0]);
        }
    }
}
