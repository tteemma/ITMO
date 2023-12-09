package Object;

import Interface.IItems;

public class Buns implements IItems {

    @Override
    public String named() {
        return "плюшками";
    }

    @Override
    public String toString() {
        return "плюшка";
    }
}
