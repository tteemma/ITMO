package Models.Story;

import Interfaces.Tell_Impl;
import Models.People.Group;
import Models.People.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringJoiner;

public class Story implements Tell_Impl {

    private final ArrayList<Sentence> sentences;
    private final HashMap<String, Person> characters;
    private final ArrayList<Group<Person>> groups;

    public Story(){
        this.sentences = new ArrayList<>();
        this.characters = new HashMap<>();
        this.groups = new ArrayList<>();
    }
    public  void addCharacter(Person character){
        this.characters.put(character.getName(),character);
    }
    public Person getCharacter(String name){
        return this.characters.get(name);
    }
    public void addCharacterGroup(Group<Person> group){
        this.groups.add(group);
        for (Person person : group.getMembers()){
            this.characters.put(person.getName(),person);
        }
    }
    public Group<Person> getCharacterGroup(int index){
        return this.groups.get(index);
    }
    public void tell(){
        for (Sentence sentence : sentences){
            sentence.print();
        }
    }
    public  void addScentence(Sentence sentence){
        sentences.add(sentence);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Story story = (Story) o;
        return Objects.equals(sentences, story.sentences) &&
                Objects.equals(characters, story.characters) &&
                Objects.equals(groups, story.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentences, characters, groups);
    }

    @Override
    public String toString() {
        var sb = new StringJoiner("\n");
        for (Sentence sentence : sentences){
            sb.add(sentence.toString());
        }
        return sb.toString();
    }
}
