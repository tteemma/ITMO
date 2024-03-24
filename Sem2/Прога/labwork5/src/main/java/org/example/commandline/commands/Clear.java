package org.example.commandline.commands;

import org.example.commandline.Console;
import org.example.commandline.PaintConsole;
import org.example.managers.CollectionManager;
import org.example.models.Route;
import org.example.exeptions.IllegalArgument;


/**
 *  Команда clear позволяет очистить всю коллекцию
 */
public class Clear extends Command{
    private final CollectionManager collectionManager;
    private final Console console;
    private Route route_id;

    public Clear(Console console, CollectionManager collectionManager){
        super("clear",": очистить коллекцию");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    /**
     * Исполнить команду
     * @param args аргументы команды
     * @throws IllegalArgument неверные аргументы команды
     */
    @Override
    public void execute(String args) throws IllegalArgument {
        if (!args.isBlank()) throw  new IllegalArgument();
        if (collectionManager.getCollection() == null || collectionManager.getCollection().isEmpty()){
            console.printError("Коллекция уже пустая");
            return;
        }
        collectionManager.clear();
        console.println(PaintConsole.paint("Коллекция успешно очищена", PaintConsole.CYAN));
    }
}
