package Enums;

import javax.swing.plaf.nimbus.State;

public enum States {
    HARMFULLY("вредно"),
    GFYH("полезно"),
    NEUTRAL("нейтрально");

    private final String state;

    States(String state){
        this.state = state;
    }

    @Override
    public String toString() {
        return this.state;
    }
}
