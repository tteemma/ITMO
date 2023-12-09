package Entity;

import Enums.Gender;

public class Housemaids extends Person{
    public Housemaids(String name, Gender gender) {
        super(name, gender);
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
        return "домомучительниц";
    }
}
