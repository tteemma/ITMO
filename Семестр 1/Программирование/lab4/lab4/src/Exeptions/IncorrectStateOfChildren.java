package Exeptions;

import Entity.Children;
import Enums.Gender;
import Enums.States;

public class IncorrectStateOfChildren extends RuntimeException{
    States errState;
    Children children;
    public IncorrectStateOfChildren(States states, Children children){
            this.errState = states;
            this.children = children;
    }
    @Override
    public  String getMessage(){
        return String.format("The object " + children.getName() + " has an incorrect state %s" , this.errState);
    }
}
