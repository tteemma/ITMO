package model.Entity;

import Interface.Declenable;
import Interface.Jumpable;
import Interface.Maneuverable;
import Interface.Takeable;
import model.Objects.Boat;
import model.Objects.Coast;

public class Mumi_Troll extends Troll implements Maneuverable, Takeable, Jumpable {
    public Mumi_Troll(String name){
        super(name,Gender.MALE);
    }

    @Override
    public String maneuver(){
        return "Изящно лавируя между ";
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public String take(Boat boat, Coast coast) {
        return /*this.gender + */ " провел " + boat.declensions() + " " + coast.declensions();
    }
    @Override
    public String jump(){
        String with_What = " спрыгнул c фалинем";
        String where = " на сушу, ";
        return with_What + where;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
