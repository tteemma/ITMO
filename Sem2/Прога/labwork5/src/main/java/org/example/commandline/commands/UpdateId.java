package org.example.commandline.commands;

import org.example.commandline.Console;
import org.example.commandline.PaintConsole;
import org.example.managers.CollectionManager;
import org.example.models.Route;
import org.example.models.form.RouteInput;
import org.example.exeptions.IllegalArgument;
import org.example.exeptions.InvalidForm;

/**
 * Update id команда для того, чтобы обновить значение элемента коллекции, id которого равен заданному
 */
public class UpdateId extends Command{
    private final Console console;
    private final CollectionManager collectionManager;

    public  UpdateId(Console console, CollectionManager collectionManager){
        super("update", ": обновить значение элемента коллекции, id которого равен заданному");
        this.collectionManager = collectionManager;
        this.console = console;
    }
    /**
     * Исполнить команду
     * @param args аргументы команды
     * @throws IllegalArgument неверные аргументы команды
     */
    @Override
    public void execute(String args) throws IllegalArgument{
        if (args.isBlank()) throw new IllegalArgument();
        class NoSuchId extends RuntimeException{

        }
        try {
            int id = Integer.parseInt(args.trim());
            if (!collectionManager.checkExist(id)) throw new NoSuchId();
            console.println(PaintConsole.paint("Введите новые значения для объекта Route...", PaintConsole.CYAN));
            Route newRoute = new RouteInput(console).create();
            console.println(PaintConsole.paint("Изменение объекта Route успешно окончено :)", PaintConsole.CYAN));
            collectionManager.editById(id,newRoute);
        } catch (InvalidForm invalidForm) {
            console.printError("Поля объекта не валидны! Объект не создан!");
        } catch (NoSuchId noSuchId){
            int id1 = Integer.parseInt(args.trim());
            console.printError("Объекта с id " + id1 + " нет в коллекции. Введите верный id, чтобы изменить объект...");
        } catch (NumberFormatException formatException){
            console.printError("id должно быть числом типа int");
        }
    }
}