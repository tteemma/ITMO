package model.Entity;

public enum Gender {
    MALE("он"),
    FEMALE("она");

    private final String pronoun;

    Gender(String pronoun){
        this.pronoun = pronoun;
    }
    public String getPronoun(){
        return pronoun;
    }

    @Override
    public String toString() {
        return pronoun;
    }
}
