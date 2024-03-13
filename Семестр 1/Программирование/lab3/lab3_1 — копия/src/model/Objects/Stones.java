package model.Objects;

import Interface.Declenable;
import model.Entity.Entity;
import model.Entity.Stone;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Stones extends Entity implements Declenable {
    List<Stone> stones = new ArrayList<>();

    public List<Stone> getStones(){
        return stones;
    }
    public void setStones(List<Stone> stones){
        this.stones = stones;
    }

    @Override
    public String declensions(){
        return " камней";
    }

    @Override
    public String toString() {
        return "по камню";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Stones stones1 = (Stones) o;
        return Objects.equals(stones, stones1.stones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stones);
    }
}
