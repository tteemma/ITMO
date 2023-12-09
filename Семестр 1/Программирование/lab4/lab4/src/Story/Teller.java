package Story;

import Entity.*;
import Enums.Gender;
import Enums.Prepositions;
import Enums.Sounds;
import Enums.States;
import Object.Kitchen;
import Object.Coffee;
import Object.Buns;
import Object.Flour;


import java.security.Permission;
import java.util.StringJoiner;

public class Teller {
    Kid kid = new Kid("Малыш", Gender.MALE);
    Kitchen kitchen = new Kitchen();
    Tamer tamer = new Tamer("1", Gender.MALE);
    Person hosusemaids = new Housemaids("домоучительниц ", Gender.OTHER);
    MissBok missBok = new MissBok("фрекен Бок", Gender.FEMALE);
    Children children = new Children("детям", Gender.OTHER);
    Coffee coffee = new Coffee();
    Flour flour = new Flour();
    Buns buns = new Buns();


    public void tell(){
        StringJoiner joiner = new StringJoiner(". ");
        joiner.add(Prepositions.BUT.toString() +kid + kid.moved() + Prepositions.ON + kitchen.named());
        joiner.add("Теперь, " + Prepositions.WHEN + Prepositions.HIM + tamer.help() +((tamer.isMale()) ? " укротитель " : " укротительница ") + hosusemaids + tamer.afraid(kid));
        joiner.add("\nНа этот раз " + missBok.delighted(kid));
        joiner.add(missBok.toString() + missBok.cooked(coffee)+ ", " + Prepositions.AND +" "+ kid.understood() + ", "+ Prepositions.WHAT + missBok.goingTo(Boolean.TRUE) + missBok.setSound(Sounds.SILENCE) + missBok.eat(coffee,buns));
        joiner.add(children.harmfulToEat(States.HARMFULLY, flour));
        joiner.add("");
        String join = joiner.toString();
        System.out.println(join);
    }
}
