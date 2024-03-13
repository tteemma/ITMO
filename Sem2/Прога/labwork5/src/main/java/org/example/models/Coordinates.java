package org.example.models;

import java.util.Objects;

public class Coordinates {
    private int x;
    private Float y; //Поле не может быть null

    public Coordinates(int  x, Float y) {
        this.x = x;
        this.setY(y);
    }

    public long getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    public  Float getY(){
        return y;
    }
    public void setY(Float y){
        if (y == null){
            throw new IllegalArgumentException("Поле не может быть null");
        }
        else {
            this.y = y;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return " x = " + x + "; y = " + y;
    }
}
