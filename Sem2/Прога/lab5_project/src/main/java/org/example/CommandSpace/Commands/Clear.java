package CommandSpace.Commands;

import CommandSpace.Console;
import Exceptions.InvalidArguments;
import Managers.CollectionManager;

/**
 * Класс команды очистки коллекции
 */
public class Clear extends Command {
    private final CollectionManager collectionManager;
    private final Console console;

    public Clear(Console console, CollectionManager collectionManager) {
        super("clear", "очистить коллекцию");
        this.collectionManager = collectionManager;
        this.console = console;
    }

    @Override
    public void execute(String args) throws InvalidArguments {
        if (!args.isBlank()) throw new InvalidArguments();
        collectionManager.clear();
        console.println("Коллекция очищена");
    }
}
