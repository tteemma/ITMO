package Object;

import Interface.IItems;

public class Coffee implements IItems {
    @Override
    public String named(){
        return " кофе";
    }


    @Override
    public String toString() {
        return "Coffee";
    }
}
