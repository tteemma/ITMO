package Entity;

import Enums.Gender;
import Enums.States;
import Exeptions.IncorrectStateOfChildren;
import Interface.IItems;

import java.util.Objects;

public class Children extends Person{

    public Children(String name, Gender gender){
        super(name, gender);
    }
    private States state = States.HARMFULLY;
    Flour flour = new Flour();


    public String harmfulToEat(States state){
        if (this.state != state){
            this.state = state;
            throw new IncorrectStateOfChildren(state, this);
            //return "Должно быть, есть " + flour.named() + " " + state + " только " + getName();
        }
        else {
            return "Должно быть, есть " + flour.named() + " " + States.HARMFULLY + " только " + getName();
        }
    }
    public static class Flour implements IItems {
        @Override
        public String named() {
            return "мучное";
        }
    }

    @Override
    public String toString() {
        return "Children {" +  "state=" + state + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Children children = (Children) o;
        return state == children.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), state);
    }
}
