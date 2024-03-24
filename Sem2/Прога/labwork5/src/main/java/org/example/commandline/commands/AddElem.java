package org.example.commandline.commands;

import org.example.commandline.Console;
import org.example.commandline.PaintConsole;
import org.example.managers.CollectionManager;
import org.example.models.form.RouteInput;
import org.example.exeptions.IllegalArgument;
import org.example.exeptions.InvalidForm;

/**
 * Команда add {element} для добавления элемента в коллекцию
 */
public class AddElem extends Command{
    private final Console consol;
    private final CollectionManager collectionManager;

    public AddElem(Console console, CollectionManager collectionManager){
        super("add",": добавить новый элемент в коллекцию");
        this.consol = console;
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
            consol.println(PaintConsole.paint("Введите данные объекта Route", PaintConsole.CYAN));
            collectionManager.addElement(new RouteInput(consol).create());
            consol.println(PaintConsole.paint("Создание объекта Route успешно окончено!", PaintConsole.CYAN));
        } catch (InvalidForm invalidForm){
            consol.printError("Поля объекта не валидны! Объект не создан!");
        }
    }
}
