package Pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

import Attack.Status.ThunderWave;
import Attack.Special.ThunderShock;
import Attack.Physical.Guillotine;

public class Magneton extends Pokemon {
    public Magneton(String name, int levl){
        super(name,levl);
        setType(Type.STEEL, Type.ELECTRIC);
        setStats(50,60,95,120,70,70);
        setMove(new ThunderShock(), new ThunderWave(), new Guillotine());
    }
}
