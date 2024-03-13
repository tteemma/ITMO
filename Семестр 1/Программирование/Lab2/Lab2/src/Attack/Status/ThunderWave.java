package Attack.Status;

import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Move;


public class ThunderWave extends StatusMove {
    public ThunderWave(){
        super(Type.ELECTRIC,0,90);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon){
        if (Math.random() < 0.25) {
            Effect.paralyze(pokemon);
        }
    }
    @Override
    protected String describe(){
        return "Using Thurnder Wave Effect";
    }
}
