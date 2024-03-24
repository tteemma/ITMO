package org.example.commandline.commands;

import org.example.commandline.Console;
import org.example.commandline.PaintConsole;
import org.example.managers.CollectionManager;
import org.example.models.Route;
import org.example.models.form.RouteInput;
import org.example.exeptions.IllegalArgument;

import java.util.Collection;
import java.util.Objects;

/**
 * Команда 'remove_greater'
 * Нужна для того, чтобы удалить из коллекции все элементы, превышающие заданный
 */
public class RemoveGreater extends Command{
    private final Console console;
    private final CollectionManager collectionManager;

    public RemoveGreater(Console console, CollectionManager collectionManager){
        super("remove_greater",": удалить из коллекции все элементы, превышающие заданный");
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
        class NoElement extends RuntimeException{

        }
        try {
            console.println(PaintConsole.paint("Введите данные объекта Route", PaintConsole.CYAN));
            Route newRoute = new RouteInput(console).create();
            Collection<Route> what_need_remove = collectionManager.getCollection().stream()
                    .filter(Objects::nonNull).filter(route -> route.compareTo(newRoute) >= 1).toList();
            if (collectionManager.getCollection() == null || collectionManager.getCollection().isEmpty()){
                console.printError("Невозномно выполнить удаление данного элемента т.к\nКоллекция пустая");
                return;
            }
            collectionManager.removeElements(what_need_remove);
            console.println(PaintConsole.paint("Из коллекции удалены элемены, больше заданного", PaintConsole.PINK));
        } catch (NoElement e){
            console.printError("В коллекции нет элементов");
        }

    }
}
