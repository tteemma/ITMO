package Entity;

import Enums.Gender;
import Enums.Prepositions;
import Interface.IDeclenable;
import Interface.IItems;
import Interface.IUnderstood;

public class Kid extends Person implements IDeclenable, IUnderstood {
    private String name;
    private Gender gender;
    private boolean isUnderstood = Boolean.TRUE;
    private Kitchen kitchen = new Kitchen();

    public Kid(String name, Gender gender) {
        super(name, gender);
    }
    public String moved(){
        return " храбро двинулся " + Prepositions.ON + kitchen.named();
    }
    private class Kitchen implements IItems {
        @Override
        public String named(){
            return "кухню";
        }
    }

    @Override
    public String toString() {
        return " ему";
    }
    @Override
    public String understood(){
        if (isUnderstood == Boolean.FALSE){
            isUnderstood = Boolean.TRUE;
            return this.getName() + "0008/0024";
        }
        else {
            return this.getName()+  " прекрасно понимал";
        }
    }

    @Override
    public String declensions() {
        return "его";
    }
}
