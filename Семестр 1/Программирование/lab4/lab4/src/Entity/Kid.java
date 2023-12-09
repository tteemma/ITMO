package Entity;

import Enums.Gender;
import Interface.IDeclenable;
import Interface.IUnderstood;

public class Kid extends Person implements IDeclenable, IUnderstood {
    private String name;
    private Gender gender;
    private boolean isUnderstood = Boolean.TRUE;

    public Kid(String name, Gender gender) {
        super(name, gender);
    }
    public String moved(){
        return " храбро двинулся ";
    }

    @Override
    public String toString() {
        return "ему";
    }
    @Override
    public String understood(){
        if (isUnderstood == Boolean.FALSE){
            isUnderstood = Boolean.TRUE;
            return this.getName() + "0008";
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
