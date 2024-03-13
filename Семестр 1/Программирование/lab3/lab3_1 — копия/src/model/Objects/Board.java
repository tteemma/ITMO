package model.Objects;

import Interface.Declenable;
import model.Entity.Entity;

import java.util.Objects;

public class Board extends Entity implements Declenable {
    private String name;
    @Override
    public String declensions(){
        return "борт ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Board board = (Board) o;
        return Objects.equals(name, board.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return name;
    }
}
