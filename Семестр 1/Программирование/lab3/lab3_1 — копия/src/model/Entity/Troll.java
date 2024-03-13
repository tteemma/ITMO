package model.Entity;

import java.util.Objects;

public class Troll extends Entity{
    public Troll(String name, Gender gender){
        this.name = name;
        this.gender = gender;
    }
    public Troll(String name){
        this.name = name;
    }
    private String name;
    @Override
    public String getName(){
        return name;
    }
    protected Gender gender = Gender.MALE;

    public boolean isMale(){
        return gender == Gender.MALE;
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
        Troll troll = (Troll) o;
        return Objects.equals(name, troll.name) && gender == troll.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, gender);
    }
}
