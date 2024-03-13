package Entity;

import Enums.Gender;
import Enums.Prepositions;
import Enums.Sounds;
import Interface.IDeclenable;
import Interface.IDelighted;
import Interface.IItems;
import Interface.IJamming;

import java.util.Objects;


public class MissBok extends Person implements IDelighted, IDeclenable, IJamming {
    public MissBok(String name, Gender gender){
        super(name, gender);
    }

    private boolean isGointTo = Boolean.FALSE;
    private Sounds sounds;

    @Override
    public String delighted(Kid him) {
       return (this.getName() + " еще меньше обрадовалась " + him.declensions() + " появлению");
    }

    @Override
    public String toString() {
        return "Она ";
    }
    public String cooked(IItems coffee){
        return  "как раз варила " + this.declensions() + coffee.named();
    }

    public String goingTo(boolean isGointTo){
        this.isGointTo = isGointTo;
        if (isGointTo == Boolean.FALSE){
            isGointTo = Boolean.TRUE;
            return (" " + this.toString().replace("О", "о") + "NE собиралась провести ");
        }
        else {
            return (" " + this.toString().replace("О", "о") + "собиралась провести ");
        }
    }
    public String setSound(Sounds sounds){
        if(this.sounds != sounds){
            this.sounds = sounds;
            return Prepositions.IN + " " + sounds.toString()+ "\n" + "несколько приятных минут, ";
        }
        else {
            return Prepositions.IN + " " +Sounds.SILENCE + "\n" + "несколько приятных мину, ";
        }
    }
    @Override
    public String eat(IItems coffee, IItems buns){
        return "заедая" + coffee.named() + " свежими " + buns.named();
    }
    @Override
    public String declensions() {
        return "себе";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MissBok missBok = (MissBok) o;
        return isGointTo == missBok.isGointTo && sounds == missBok.sounds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isGointTo, sounds);
    }
}
