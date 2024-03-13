package Pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

import Attack.Special.ThunderShock;
import Attack.Physical.ShadowPunch;
import Attack.Status.ThunderWave;


public class Volbeat extends Pokemon {
    public Volbeat(String name, int levl){
        super(name,levl);
        setType(Type.BUG);
        setStats(65,73,75,47,85,85);
        setMove(new ThunderShock(), new ShadowPunch(), new ThunderWave());
    }
}
