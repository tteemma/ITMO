package Collection;

import Collection.Parametres.Car;
import Collection.Parametres.Coordinates;
import Collection.Parametres.Mood;
import Collection.Parametres.WeaponType;
import Managers.CollectionManager;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.Stack;

/**
 * Класс основного элемента коллекции
 */
public class HumanBeing implements Comparable<HumanBeing>, Validator {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Boolean realHero; //Поле не может быть null
    private Boolean hasToothpick; //Поле может быть null
    private Integer impactSpeed; //Поле не может быть null
    private WeaponType weaponType; //Поле не может быть null
    private Mood mood; //Поле может быть null
    private Car car; //Поле не может быть null

    private static long idPoint = 0L;

    public HumanBeing(String name, Coordinates coordinates, Date creationDate, Boolean realHero,
                      Boolean hasToothpick, Integer impactSpeed, WeaponType weaponType, Mood mood, Car car) {
        this.id = incIdPoint();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.weaponType = weaponType;
        this.mood = mood;
        this.car = car;
    }

    private static long incIdPoint() {
        return ++idPoint;
    }

    public static void updateIdPoint(Stack<HumanBeing> collection) {
        idPoint = collection.stream()
                .filter(Objects::nonNull)
                .map(HumanBeing::getId)
                .mapToLong(Long::longValue)
                .max().orElse(0);
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setRealHero(Boolean realHero) {
        this.realHero = realHero;
    }

    public void setHasToothpick(Boolean hasToothpick) {
        this.hasToothpick = hasToothpick;
    }

    public void setImpactSpeed(Integer impactSpeed) {
        this.impactSpeed = impactSpeed;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Boolean getRealHero() {
        return realHero;
    }

    public Boolean getHasToothpick() {
        return hasToothpick;
    }

    public Integer getImpactSpeed() {
        return impactSpeed;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public Mood getMood() {
        return mood;
    }

    public Car getCar() {
        return car;
    }

    public float getPrice() {
        PriceElement<Integer, Double, Integer, Boolean> price =
                (x, y, impactSpeed, realHero) -> (float) Math.sqrt(x * x + y * y) +
                        impactSpeed + (realHero ? 100 : 0);
        return price.getPriceElement(getCoordinates().getX(), getCoordinates().getY(), getImpactSpeed(), getRealHero());
    }

    @Override
    public boolean validate() {
        if (this.id == null || this.id <= 0) return false;
        if (this.name == null || this.name.isEmpty()) return false;
        if (this.coordinates == null) return false;
        if (this.creationDate == null) return false;
        if (this.realHero == null) return false;
        if (this.hasToothpick == null) return false;
        if (this.impactSpeed == null) return false;
        if (this.weaponType == null) return false;
        if (this.mood == null) return false;
        return this.car != null;
    }

    @Override
    public int compareTo(HumanBeing o) {
        if (o == null) return 1;
        return Float.compare(getPrice(), o.getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        HumanBeing p = (HumanBeing) o;
        if (!this.id.equals(p.id)) return false;
        if (!this.name.equals(p.name)) return false;
        if (!this.coordinates.equals(p.coordinates)) return false;
        if (!this.creationDate.equals(p.creationDate)) return false;
        if (!this.realHero.equals(p.realHero)) return false;
        if (!this.hasToothpick.equals(p.hasToothpick)) return false;
        if (!this.impactSpeed.equals(p.impactSpeed)) return false;
        if (!this.weaponType.equals(p.weaponType)) return false;
        return this.car.equals(p.car);
    }

    @Override
    public int hashCode() {
        int result = 0;
        result += id.hashCode();
        result += name.hashCode();
        result += coordinates.hashCode();
        result += creationDate.hashCode();
        result += realHero.hashCode();
        result += hasToothpick.hashCode();
        result += impactSpeed.hashCode();
        result += weaponType.hashCode();
        result += car.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "*** " + name + " ***\n" +
                "id = " + id + "\n" +
                "name = " + name + "\n" +
                coordinates + "\n" +
                "creationDate = " + CollectionManager.formatTime(creationDate) + "\n" +
                "realHero = " + realHero + "\n" +
                "hasToothpick = " + hasToothpick + "\n" +
                "impactSpeed = " + impactSpeed + "\n" +
                "weaponType = " + weaponType + "\n" +
                "mood = " + mood + "\n" +
                car + "\n";
    }
}
