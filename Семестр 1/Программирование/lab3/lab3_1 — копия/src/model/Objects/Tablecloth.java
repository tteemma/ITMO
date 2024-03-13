package model.Objects;

import Interface.NotCarriable;
import model.Entity.Entity;

public class Tablecloth extends Entity implements NotCarriable {
    public Tablecloth(String name){
        this.setName(name);
    }
    @Override
    public String notCarry(){
        return ", чтобы ее не унесло ветром";
    }

    @Override
    public String toString() {
        return getName();
    }
}
