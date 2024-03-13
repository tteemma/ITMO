package CommandSpace.Commands;

import CommandSpace.Console;
import CommandSpace.Printable;
import Exceptions.InvalidArguments;
import Exceptions.InvalidForm;
import Managers.CollectionManager;

import java.util.Collection;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Класс команды для вывода всей коллекции
 */
public class Show extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public Show(Console console, CollectionManager collectionManager) {
        super("show", "вывести в стандратный поток вывода все элементы коллекции в строковом представлении");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) throws InvalidArguments {
        if (!args.isBlank()) throw new InvalidArguments();
        if (collectionManager.getCollection() == null) {
            console.printError("Коллекция в сессии не инициализирована");
            return;
        }
        console.println(collectionManager.toString());
    }
}
