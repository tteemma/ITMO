package org.example.commandline.commands;

import org.example.commandline.Console;
import org.example.managers.CollectionManager;
import org.example.models.Route;
import org.example.exeptions.IllegalArgument;

import java.util.*;

/**
 * Команда print_field_descending_distance нужна, чтобы
 * вывести значения поля distance всех элементов в порядке убывания
 */
public class PrintFieldDescendingDistance extends Command{
    private final Console console;
    private final CollectionManager collectionManager;
    public PrintFieldDescendingDistance(Console console, CollectionManager collectionManager){
        super("print_field_descending_distance",": вывести значения поля distance всех элементов в порядке убывания");
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
//        TreeSet<Route> collection = collectionManager.getCollection();
//        List<Route> distanceList = new ArrayList<>(collection.stream().toList());
//        Collections.sort(distanceList);
//        for (Route route: distanceList){
//            console.println(ConsoleColor.toColor(String.valueOf(route.getDistance()),ConsoleColor.BLUE));
//        }
        ArrayList<Route> collection = new ArrayList<>(collectionManager.getCollection());
        collection.sort(Collections.reverseOrder());
        for (Route routeDistance: collection){
            if (routeDistance == null){
                console.printError("Нет элементов");
            } else {
                console.println(String.valueOf(routeDistance.getDistance()));
            }
        }
    }
}
