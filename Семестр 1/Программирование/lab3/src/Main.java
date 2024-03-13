import Models.People.Gender;
import Models.People.Group;
import Models.People.Person;
import Models.Story.Sentence;
import Models.Story.Story;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var story = new Story();
        story.addCharacter(new Person("All",Gender.MALE));

        var they = story.getCharacter("Them");


        ///story.addScentence(new Sentence());


    }
}