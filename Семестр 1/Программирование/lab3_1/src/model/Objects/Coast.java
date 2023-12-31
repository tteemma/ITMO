package model.Objects;

import Interface.Declenable;
import model.Entity.Entity;
import model.Entity.Gender;

import java.util.Objects;

public class Coast extends Entity implements Declenable {
    private String name;
    public Coast(String name){
        this.name = name;
    }

    @Override
    public String declensions(){
        return "к бурегу";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Coast coast = (Coast) o;
        return Objects.equals(name, coast.name);
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
