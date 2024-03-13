package Exeptions;

import Story.Teller;

public class IncorrectHistoryNumber extends Exception{
    public IncorrectHistoryNumber(int numberOfHistory){
        super("There is no story with number " + numberOfHistory + " yet =)");
    }
}
