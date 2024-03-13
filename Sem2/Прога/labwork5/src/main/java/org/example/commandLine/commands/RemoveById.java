package org.example.commandLine.commands;

import org.example.commandLine.Console;
import org.example.commandLine.ConsoleColor;
import org.example.managers.CollectionManager;
import org.example.exeptions.IllegalArgument;

/**
 * Команда remove_by_id нужна для удаления элемента коллекции по его id
 */
public class RemoveById extends Command{
    private final Console console;
    private final CollectionManager collectionManager;

    public RemoveById(Console console, CollectionManager collectionManager){
        super("remove_by_id", ": удалить элемент из коллекции по его id");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    /**
     * Исполнить команду
     * @param args аргументы команды
     * @throws IllegalArgument ошибка, говорящая пользователю, что аргументы команды неверные
     */
    @Override
    public void execute(String args) throws IllegalArgument {
        if (args.isBlank()) throw new IllegalArgument();
        class NoSuchId extends RuntimeException{

        }
        try {
            int id = Integer.parseInt(args.trim());
            if (!collectionManager.checkExist(id)) throw new NoSuchId();
            collectionManager.removeElement(collectionManager.getById(id));
            console.println(ConsoleColor.toColor("Удаление объекта с id = " + id + " завершено успешно...",ConsoleColor.CYAN));
        } catch (NoSuchId idException){
            int id1 = Integer.parseInt(args.trim());
            console.printError("Объекта с id " + id1 + " нет в коллекции. Введите элемент, ID котрого есть в коллекции, чтобы удалить его");
        } catch (NumberFormatException formatException){
            console.printError("Значение id должно быть типа int");
        }
    }
}
