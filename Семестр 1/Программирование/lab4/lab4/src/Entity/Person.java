package Entity;

import Enums.Gender;

import java.util.Objects;

public abstract class Person {
    private final String name;
    private final Gender gender;

    public Person(String name, Gender gender){
        this.name = name;
        this.gender = gender;
    }

    public String getName(){
        return name;
    }
    public boolean isMale(){
        return gender == Gender.MALE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender);
    }

    @Override
    public String toString() {
        return name;
    }
}
