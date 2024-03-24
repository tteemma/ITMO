package org.example.commandline.commands;

import org.example.commandline.Console;
import org.example.commandline.PaintConsole;
import org.example.managers.CollectionManager;
import org.example.models.Route;
import org.example.models.form.RouteInput;
import org.example.exeptions.IllegalArgument;
import org.example.exeptions.InvalidForm;

import java.util.Objects;

/**
 * Команда add_if_min предназначена, чтобы
 * добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
 */
public class AddIfMin extends Command{
    private final Console console;
    private final CollectionManager collectionManager;

    public AddIfMin(Console console, CollectionManager collectionManager){
        super("add_if_min",": добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
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
        if (!args.isBlank()) throw new IllegalArgument();
        try {
            if (collectionManager.getCollection() == null || collectionManager.getCollection().isEmpty()){
                console.printError("Коллекция пустая");
                return;
            }
            console.println(PaintConsole.paint("Введите данные объекта Route", PaintConsole.CYAN));
            Route newRoute = new RouteInput(console).create();
            if (newRoute.compareTo(collectionManager.getCollection().
                    stream().filter(Objects::nonNull).
                    min(Route::compareTo).orElse(null)) <= 1){
                collectionManager.addElement(newRoute);
                console.println(PaintConsole.paint("Объект успешно добавлен", PaintConsole.CYAN));
            } else {
                console.printError("Нуполучилось!Элемент больше наименьшего элемента в коллекции");
            }
        } catch (InvalidForm invalidForm){
            console.printError("Поля объекта не валидны! Объект не создан!");
        } catch (NullPointerException nullPointerException){
            console.printError("В коллекции нет элементов");
        }
    }
}
