package Attack.Physical;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Effect;


public class Tackle extends PhysicalMove {
    public Tackle(){
        super(Type.NORMAL,40,100);
    }
    @Override
    protected String describe(){
        return "Using Tackle shot";
    }
}
