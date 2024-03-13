package CommandSpace.Commands;

import CommandSpace.Console;
import Exceptions.ExitProgram;
import Exceptions.InvalidArguments;
import Exceptions.NoSuchId;
import Managers.CollectionManager;

/**
 * Класс команды для удаления элемента коллекции по его id
 */
public class RemoveById extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public RemoveById(Console console, CollectionManager collectionManager) {
        super("remove_by_id", "id","удалить элемент из коллекции по его id");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) throws InvalidArguments, ExitProgram {
        if (args.isBlank()) throw new InvalidArguments();
        try {
            long id = Long.parseLong(args.trim());
            if (!collectionManager.checkExistById(id)) throw new NoSuchId();
            collectionManager.removeElement(collectionManager.getById(id));
            console.println("Элемент удален успешно");
        } catch (NoSuchId e) {
            console.printError("Нет элемента с таким id");
        } catch (NumberFormatException e) {
            console.printError("id должен быть числом типа long");
        }
    }
}
