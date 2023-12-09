package Enums;

public enum Sounds {
    SILENCE("тишине"),
    NOISE("шуме"),
    EMPTINESS("пустоте");

    private final String sound;
    Sounds(String sound){
        this.sound = sound;
    }

    @Override
    public String toString() {
        return sound;
    }
}
