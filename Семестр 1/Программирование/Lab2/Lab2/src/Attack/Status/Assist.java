package Attack.Status;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Stat;

public class Assist extends StatusMove {

    public Assist(){
        super(Type.NORMAL,0,0);
    }
    @Override
    protected void applySelfEffects(Pokemon pokemon){

    }
    @Override
    protected String describe(){
        return "Using Assist move";
    }

}
