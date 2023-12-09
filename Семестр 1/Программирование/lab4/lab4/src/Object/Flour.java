package Object;

import Interface.IItems;

public class Flour implements IItems {

    @Override
    public String named() {
        return "мучное";
    }
}
