package Exeptions;

public class IncorrectStateOfChildren extends RuntimeException{
    public IncorrectStateOfChildren(){
        super("Incorrect data entry\n");
    }
}
