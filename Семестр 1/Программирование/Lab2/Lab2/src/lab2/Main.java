package lab2;

import Pokemons.*;
import ru.ifmo.se.pokemon.*;

public class Main {

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                System.out.println("I'm dead");
            }
        });

        var battle = new Battle();

        battle.addAlly(new Armaldo("Detrolex",10));
        battle.addAlly(new Magnemite("Cendol", 3));
        battle.addAlly(new Volbeat("Venarus",2));

        battle.addFoe(new Minim("Mizin",5));
        battle.addFoe(new Magneton("Ergoferon",3));
        battle.addFoe(new Claydol("DexPanTenol",10));

        battle.go();
    }
}