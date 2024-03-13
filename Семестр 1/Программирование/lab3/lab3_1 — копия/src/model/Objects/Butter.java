package model.Objects;

import Interface.Declenable;
import model.Entity.Entity;

public class Butter extends Entity implements Declenable {
    public Butter(String name){
        this.setName(name);
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public String declensions() {
        return "с маслом ";
    }
}
