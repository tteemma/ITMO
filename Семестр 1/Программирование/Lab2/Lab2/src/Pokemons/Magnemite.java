package Pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

import Attack.Status.ThunderWave;
import Attack.Special.ThunderShock;

public class Magnemite extends Pokemon {
    public Magnemite(String name, int levl){
        super(name,levl);
        setType(Type.ELECTRIC, Type.STEEL);
        setStats(25,35,70,95,55,45);
        setMove(new ThunderWave(), new ThunderShock());
    }
}
