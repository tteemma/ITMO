package Entity;

import Enums.Gender;
import Interface.IAfraid;

public class Tamer extends Person implements IAfraid {

    public Tamer(String name, Gender gender) {
        super(name, gender);
    }
    public String help(){
        return "помогал лучший";
    }

    @Override
    public String afraid(Kid kid) {
        return (kid.toString() + " нечего было бояться");
    }
}
