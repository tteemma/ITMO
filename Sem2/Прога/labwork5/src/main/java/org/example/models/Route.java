package org.example.models;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.TreeSet;

public class Route implements Comparable{
    private int id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private LocationFrom from; //Поле может быть null
    private LocationTo to; //Поле может быть null
    private long distance; //Поле может быть null, Значение поля должно быть больше 1


    private static int idPoint = 1;
    /**
     * @param name
     * @param coordinates
     * @param from
     * @param to
     * @param distance
     */
    public Route(String name, Coordinates coordinates, LocationFrom from, LocationTo to, long distance) {
        this.creationDate = LocalDateTime.now();
        //this.id = (int)java.util.UUID.randomUUID().getLeastSignificantBits();// Уникальный номер экземпляра класса
        this.id = incNextId();
        this.setName(name);
        this.setCoordinates(coordinates);
        this.setFrom(from);
        this.setTo(to);
        this.setDistance(distance);
    }

    private static int incNextId(){
        return idPoint++;
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    /**
     * метод обновляет переменную nextId,
     * чтобы она содержала следующий доступный идентификатор
     * для объектов типа Route на основе их текущих id в коллекции.
     * @param collection коллекция в которой работаем
     */
    public static void updateId(TreeSet<Route> collection){
        idPoint = collection.stream().filter(Objects::nonNull).map(Route::getId).mapToInt(Integer::intValue).max().orElse(0) + 1;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocationFrom getFrom() {
        return from;
    }

    public LocationTo getTo() {
        return to;
    }

    public long getDistance() {
        return distance;
    }
    public void setName(String name) {
        if(name == null){
            throw new IllegalArgumentException("Поле не может быть null");
        } else if (name.isEmpty()){
            throw new IllegalArgumentException("Строка не может быть пустой");
        }
        else {
        this.name = name;
        }
    }

    public void setCoordinates(Coordinates coordinates) {
        if (coordinates == null){
            throw new IllegalArgumentException("Координаты не могут быть равны null");
        }
        else {
            this.coordinates = coordinates;
        }
    }

    public void setFrom(LocationFrom from) {
        if (from == null){
            throw new IllegalArgumentException("Координаты не могут быть равны null");
        }
        else {
            this.from = from;
        }
    }

    public void setTo(LocationTo to) {
        this.to = to;
    }

    public void setDistance(long distance) {
        if (distance <= 1) {
            throw new IllegalArgumentException("Значение этого поля должно быть больше 1");
        }
        else {
            this.distance = distance;
        }
    }
    @Override
    public int compareTo(Object o) {
        try {
            return (int) (this.distance - (long) o.getClass().getMethod("getDistance").invoke(o));
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "\nRoute" +
                "\nid = " + id +
                "\nname = \'" + name + '\'' +
                "\ncoordinates: " + coordinates +
                "\ncreationDate: " + creationDate +
                "\nfrom: " + from +
                "\nto: " + to +
                "\ndistance = " + distance;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route other = (Route) o;

        if (id != other.id) return false;
        if(!name.equals(other.name)) return false;
        if (!coordinates.equals(other.coordinates)) return false;
        if (!creationDate.equals(other.creationDate)) return false;
        if (!to.equals(other.to)) return false;
        if (distance != other.distance) return false;
        return from.equals(other.from);
    }

    @Override
    public int hashCode() {
        int result = 0;
        result += 31 * id;
        result += name.hashCode();
        result += coordinates.hashCode();
        result += creationDate.hashCode();
        result += to.hashCode();
        result += from.hashCode();
        result += 31 * distance;
        return result;
    }

//    @Override
//    public int compareTo(Object o) {
//        try {
//            return (int) (this.distance - (long) o.getClass().getMethod("getDistance").invoke(o));
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        } catch (NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
