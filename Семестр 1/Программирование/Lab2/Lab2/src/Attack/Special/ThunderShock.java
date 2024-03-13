package Attack.Special;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.DamageMove;
import ru.ifmo.se.pokemon.Effect;

public class ThunderShock extends SpecialMove {
    public ThunderShock(){
        super(Type.ELECTRIC,40,100);
    }
    @Override
    protected void applyOppDamage(Pokemon pokemon, double damage){
        damage = 40;
        if (Math.random() < 0.1){
            Effect.paralyze(pokemon);
        }
    }
    @Override
    protected void applyOppEffects(Pokemon pokemon){
        if (Math.random() < 0.1){
            Effect.paralyze(pokemon);
        }
    }
    @Override
    protected String describe(){
        return "Using Thunder Shock ";
    }
}
