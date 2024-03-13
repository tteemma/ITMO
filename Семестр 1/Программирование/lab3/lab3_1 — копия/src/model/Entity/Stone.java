package model.Entity;

import Interface.Declenable;

import java.util.List;

public class Stone extends Entity {
    public Stone(String name){
        this.setName(name);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return getName();
    }
}
