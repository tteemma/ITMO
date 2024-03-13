package Attack.Physical;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Stat;

public class MetalClaw extends StatusMove {
    public MetalClaw(){
        super(Type.STEEL, 50,95);
    }
    @Override
    protected void applySelfEffects(Pokemon pokemon){
        if (Math.random() < 0.1){
            pokemon.setMod(Stat.ATTACK, +1);
        }
    }
    @Override
    protected String describe(){
        return "Using Mental Claw eff";
    }

}
