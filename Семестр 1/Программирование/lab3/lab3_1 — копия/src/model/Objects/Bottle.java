package model.Objects;

import Interface.Declenable;
import model.Entity.Entity;

public class Bottle extends Entity implements Declenable {
    public Butter butter = new Butter("масло");
    public Bottle(String name){
        this.setName(name);
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public String declensions() {
        return "банку ";
    }
}
