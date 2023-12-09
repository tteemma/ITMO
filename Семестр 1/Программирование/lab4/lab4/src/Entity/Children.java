package Entity;

import Enums.Gender;
import Enums.States;
import Exeptions.IncorrectStateOfChildren;
import Object.Flour;

import java.util.Objects;

public class Children extends Person{
    public Children(String name, Gender gender){
        super(name, gender);
    }

    private States state = States.HARMFULLY;


    public String harmfulToEat(States state, Flour flour){
        if (this.state != state){
            this.state = state;
            throw new IncorrectStateOfChildren();
            //return "Должно быть, есть " + flour.named() + " " + state + " только " + getName();
        }
        else {
            return "Должно быть, есть " + flour.named() + " " + States.HARMFULLY + " только " + getName();
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
