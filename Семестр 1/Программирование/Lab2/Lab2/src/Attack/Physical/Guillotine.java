package Attack.Physical;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Effect;
import

public class Guillotine extends PhysicalMove {
    public Guillotine(){
        super(Type.NORMAL,0,30);
    }
    @Override
    protected void applyOppEffects(Pokemon pokemon){
        Effect.paralyze(pokemon);
    }
    @Override
    protected String describe(){
        return "Pokemon is paralyze";
    }
}
