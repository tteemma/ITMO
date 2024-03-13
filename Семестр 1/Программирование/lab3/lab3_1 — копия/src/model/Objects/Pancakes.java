package model.Objects;

import model.Entity.Entity;

public class Pancakes extends Entity {
    public Pancakes(String name){
        this.setName(name);
    }

    @Override
    public String toString() {
        return getName();
    }
}
