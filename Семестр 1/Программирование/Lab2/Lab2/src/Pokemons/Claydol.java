package Pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

import Attack.Special.ThunderShock;
import Attack.Status.ThunderWave;
import Attack.Physical.Guillotine;
import Attack.Physical.FlameWheel;

import java.util.TreeMap;

public class Claydol extends Pokemon {
    public Claydol(String name, int levl){
        super(name,levl);
        setType(Type.GROUND,Type.PSYCHIC);
        setStats(60,70,105,70,120,75);
        setMove(new ThunderShock(), new ThunderWave(), new Guillotine(), new FlameWheel());

    }
}
