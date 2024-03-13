package CommandSpace.Commands;

import Collection.Forms.HumanBeingForm;
import CommandSpace.Console;
import Exceptions.FileModeException;
import Exceptions.InvalidArguments;
import Exceptions.InvalidForm;
import Managers.CollectionManager;

/**
 * Класс команды создания нового элемента и добавления его в коллекцию
 */
public class AddElement extends Command {
    private final CollectionManager collectionManager;
    private final Console console;

    public AddElement(Console console, CollectionManager collectionManager) {
        super("add", "добавить новый элемент в коллекцию");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) throws InvalidArguments {
        if (!args.isBlank()) throw new InvalidArguments();
        try {
            console.println("Начало создания экземпляра HumanBeing...");
            collectionManager.addElement(new HumanBeingForm(console).build());
            console.println("Экземпляр HumanBeing успешно создан!");
        } catch (InvalidForm | FileModeException e) {
            console.printError("Поля невалидны => экземпляр не создан");
        }
    }
}
