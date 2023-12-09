package Object;

import Interface.IItems;

public class Kitchen1 implements IItems {
    @Override
    public String named() {
        return "кухню";
    }

    @Override
    public String toString() {
        return "кухня";
    }
}
