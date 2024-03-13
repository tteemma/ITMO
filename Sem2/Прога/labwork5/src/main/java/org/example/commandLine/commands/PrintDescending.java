package org.example.commandLine.commands;

import org.example.commandLine.Console;
import org.example.commandLine.ConsoleColor;
import org.example.managers.CollectionManager;
import org.example.models.Route;
import org.example.exeptions.IllegalArgument;

import java.util.Collection;
import java.util.TreeSet;

/**
 *  Команда print_descending используется, чтобы
 *  вывести элементы коллекции в порядке убывания
 */
public class PrintDescending extends Command{
    private final Console console;
    private final CollectionManager collectionManager;

    public PrintDescending(Console console, CollectionManager collectionManager){
        super("print_descending",": вывести элементы коллекции в порядке убывания");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    /**
     * Исполнить команду
     * @param args аргументы команды
     * @throws IllegalArgument ошибка, говорящая пользователю, что аргументы команды неверные
     */
    @Override
    public void execute(String args) throws  IllegalArgument{
        if (!args.isBlank()) throw new IllegalArgument();
        Collection<Route> reversCollection = collectionManager.getCollection();
        if (reversCollection == null || reversCollection.isEmpty()){
            console.println(ConsoleColor.toColor("Коллекция пустая", ConsoleColor.PINK));
            return;
        }
        console.println(collectionManager.reversCollections((TreeSet<Route>)reversCollection));
    }
}
