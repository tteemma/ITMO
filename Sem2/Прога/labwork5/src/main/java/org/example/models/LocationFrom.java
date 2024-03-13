package org.example.models;

public class LocationFrom {
    private double x;
    private double y;
    private String name; //Поле может быть null

    public LocationFrom(double x, double y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
       this.x = x;
    }
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "x = "+x + "; y = " + y  + "; name = " + name;
    }
}
