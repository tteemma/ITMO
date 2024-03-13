package Attack.Physical;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class JumpKick extends PhysicalMove {
    public JumpKick(){
        super(Type.FIGHTING, 100,95);
    }
    @Override
    protected String describe(){
        return "Usimg Jump Kick hit";
    }
}
