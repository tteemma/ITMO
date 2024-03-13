package model.Entity;

import Interface.Stretchedable;

import java.util.ArrayList;
import java.util.List;

public class Everyone<T  extends Troll> implements Stretchedable {
    @Override
    public String Stretched(){
        return " потянулись через ";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return Prepositions.All.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    public String watched(){
        return "посмотреть";
    }
}
