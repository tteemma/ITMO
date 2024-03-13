package org.example.models;

public class LocationTo {
    private int x;
    private Long y; //Поле не может быть null
    private String name; //Поле может быть null

    public LocationTo(int x, Long y, String name) {
        this.x = x;
        this.setY(y);
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Long getY() {
        return y;
    }
    public void setY(Long y){
        this.y = y;
    }

//    public void setY(Long y) {
//        if (y == null){
//            throw new IllegalArgumentException("Поле не может быть null");
//        } else {
//            this.y = y;
//        }
//    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
       this.name = name;
    }

    @Override
    public String toString() {
        return "x = "+x + "; y = " + y + "; name = " + name;
    }
}
