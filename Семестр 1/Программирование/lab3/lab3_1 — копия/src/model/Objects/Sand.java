package model.Objects;

import Interface.Declenable;
import model.Entity.Entity;

import java.util.Objects;

public class Sand extends Entity implements Declenable {
    private String name;

/*    public Sand(String name){
        this.name = name;
    }*/
    @Override
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    @Override
    public String declensions(){
        return " песок";
    }
    public String mumiMam(){
        return "на песке";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Sand sand = (Sand) o;
        return Objects.equals(name, sand.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
