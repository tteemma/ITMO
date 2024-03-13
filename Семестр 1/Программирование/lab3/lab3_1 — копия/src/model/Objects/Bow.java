package model.Objects;

import Interface.Pokedable;
import model.Entity.Entity;

import java.util.Objects;

public class Bow extends Entity implements Pokedable {
    private String name;

    public String getBow(){
        return " нос";
    }
    @Override
    public String poked(){
        return " мягко ткнулся ";
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bow bow = (Bow) o;
        return Objects.equals(name, bow.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
