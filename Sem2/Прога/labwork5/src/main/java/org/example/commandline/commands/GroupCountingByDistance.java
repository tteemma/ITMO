package org.example.commandLine.commands;

import org.example.commandLine.Console;
import org.example.commandLine.ConsoleColor;
import org.example.managers.CollectionManager;
import org.example.models.Route;
import org.example.exeptions.IllegalArgument;

import java.util.*;

/**
 *  Команда group_counting_by_distance нужна, чтобы
 *  сгруппировать элементы коллекции по значению поля distance, вывести количество элементов в каждой группе
 */
public class GroupCountingByDistance extends Command{
    private final Console console;
    private final CollectionManager collectionManager;

    public GroupCountingByDistance(Console console, CollectionManager collectionManager){
        super("group_counting_by_distance",": сгруппировать элементы коллекции по значению поля distance, вывести количество элементов в каждой группе");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    /**
     * Исполнить команду
     * @param args аргументы команды
     * @throws IllegalArgument ошибка, говорящая пользователю, что аргументы команды неверные
     */
    @Override
    public void execute(String args) throws IllegalArgument{
        if (!args.isBlank()) throw new IllegalArgument();
        TreeSet<Route> collect = collectionManager.getCollection();
        List<Route> distanceList = new ArrayList<>(collect);
//        for (Route route_D: distanceList){
//            console.println(String.valueOf(route_D.getDistance()));
//        }
        HashMap<Long, List<Route>> groupByDistance =  new HashMap<>();
        // Цыкл группировки по distance
        for (Route route: distanceList){
            groupByDistance.computeIfAbsent(route.getDistance(), key -> new ArrayList<>()).add(route);
        }
        for (Map.Entry<Long, List<Route>> group : groupByDistance.entrySet()){
            console.println(ConsoleColor.toColor("Значение поля distance: " + group.getKey() + "\nКоличество в коллекции: " + group.getValue().size() + "\n" ,ConsoleColor.BLUE));
        }
    }
}
