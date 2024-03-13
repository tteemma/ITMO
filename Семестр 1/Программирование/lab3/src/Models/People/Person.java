package Models.People;

import java.util.Objects;

public class Person {
    private String name;
    private Gender gender;

    public Person(String name, Gender gender){
        this.name = name;
        this.gender = gender;
    }

    public Gender getGender(){
        return gender;
    }
    public void setGender(Gender gender){
        this.gender = gender;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
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
