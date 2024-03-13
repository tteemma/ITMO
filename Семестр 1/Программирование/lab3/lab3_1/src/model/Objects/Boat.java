package model.Objects;

import Interface.Declenable;
import model.Entity.Entity;

import java.util.Objects;

public class Boat extends Entity implements Declenable {
    private String name;

    public Boat(String name){
        this.name = name;
    }

    @Override
    public String declensions(){
        return "лодку";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Boat boat = (Boat) o;
        return Objects.equals(name, boat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return name;
    }
}
