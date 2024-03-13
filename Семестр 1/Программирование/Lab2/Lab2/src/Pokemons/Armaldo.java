package Pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import Attack.Physical.JumpKick;
import Attack.Physical.MetalClaw;
import Attack.Status.Assist;
import Attack.Status.sleepTalk;

public class Armaldo extends Pokemon {

    public Armaldo(String name, int levl){
        super(name,levl);
        setStats(75,125,100,70,80,45);
        setType(Type.ROCK,Type.BUG);
        setMove(new sleepTalk(), new JumpKick(), new Assist(), new MetalClaw());
    }
}
