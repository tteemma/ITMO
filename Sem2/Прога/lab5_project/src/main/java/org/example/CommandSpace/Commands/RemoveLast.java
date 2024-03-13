package CommandSpace.Commands;

import CommandSpace.Console;
import Exceptions.ExitProgram;
import Exceptions.InvalidArguments;
import Managers.CollectionManager;

import java.util.EmptyStackException;

/**
 * Класс команды для удаления последнего элемента коллекции
 */
public class RemoveLast extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public RemoveLast(Console console, CollectionManager collectionManager) {
        super("remove_last", "удалить последний элемент из коллекции");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) throws InvalidArguments {
        if (!args.isBlank()) throw new InvalidArguments();
        try {
            collectionManager.removeLast();
            console.println("Элемент успешно удален");
        } catch (EmptyStackException e) {
            console.printError("Коллекция пуста");
        }
    }
}
