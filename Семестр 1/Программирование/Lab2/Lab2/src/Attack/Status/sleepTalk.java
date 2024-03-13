package Attack.Status;

import ru.ifmo.se.pokemon.*;

import java.lang.Math.*;

public class sleepTalk extends StatusMove
{
        public sleepTalk()
        {
            super(Type.NONE, 0,0);
        }
        @Override
        protected void applyOppEffects(Pokemon pokemon){
            Effect.sleep(pokemon);
        }
        @Override
        protected String describe(){
            return "Using Sleep Talk power";
        }
}
