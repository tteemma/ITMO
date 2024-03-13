package Enums;

public enum Prepositions{
    BUT("А "),
    ON("на "),
    WHEN("когда"),
    HIM(" ему "),
    IN("в"),
    AND("и"),
    WHAT("что");
    private final String preposition;
    Prepositions(String preposition ){
        this.preposition = preposition;
    }

    @Override
    public String toString() {
        return preposition;
    }
}
