package model.Objects;

import Interface.Declenable;
import model.Entity.Entity;

import java.util.Objects;

public class Shoal extends Entity implements Declenable {
    private String name;

    public Shoal(String name){
        this.name = name;
    }
    @Override
    public String declensions(){
        return "отмелями, ";
    }

    @Override
    public String toString() {
        return name;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Shoal shoal = (Shoal) o;
        return  Objects.equals(name,shoal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
