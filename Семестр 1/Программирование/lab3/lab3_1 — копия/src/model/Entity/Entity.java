package model.Entity;

import java.util.Objects;

public abstract class Entity {
    private String name;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
