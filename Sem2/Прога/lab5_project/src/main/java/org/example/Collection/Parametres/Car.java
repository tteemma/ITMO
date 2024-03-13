package Collection.Parametres;

import Collection.Validator;

import java.util.Objects;

/**
 * Класс машины
 */
public class Car implements Validator {
    private String name; //Поле не может быть null

    public Car(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean validate() {
        return name != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Car p = (Car) o;
        return this.name.equals(p.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Car: " + name;
    }
}
