import Entity.Children;
import Entity.Kid;
import Entity.Person;
import Entity.Tamer;
import Enums.Gender;
import Enums.Prepositions;
import Exeptions.IncorrectHistoryNumber;
import Story.Teller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IncorrectHistoryNumber{
        var teller = new Teller();
        System.out.println("Enter the history number");
        Scanner scanner = new Scanner(System.in);
        int numberOfStory = Integer.parseInt(scanner.nextLine());
        if (numberOfStory != 1){
            throw new IncorrectHistoryNumber(numberOfStory);
        }
        teller.tell();
    }
}