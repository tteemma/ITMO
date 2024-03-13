package Pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import Attack.Physical.ShadowPunch;
import Attack.Status.ThunderWave;
import Attack.Special.ThunderShock;

import java.util.Set;


public class Minim extends Pokemon {
    public Minim(String name, int levl){
        super(name,levl);
        setType(Type.ELECTRIC);
        setStats(60,40,50,75,85,95);
        setMove(new ThunderWave(), new ThunderShock(), new ShadowPunch());
    }
}
