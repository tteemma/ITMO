package Attack.Physical;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Status;

public class FlameWheel extends PhysicalMove {
    public FlameWheel(){
        super(Type.FIRE, 60,100);
    }
    @Override
    protected void applyOppEffects(Pokemon pokemon){
        if (Math.random() < 0.1){
            Effect.burn(pokemon);
        }
    }
    @Override
    protected String describe(){
        return "Using Flame Wheel skilt";
    }
}
