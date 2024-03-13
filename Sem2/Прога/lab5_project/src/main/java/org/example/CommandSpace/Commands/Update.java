package CommandSpace.Commands;

import Collection.Forms.HumanBeingForm;
import CommandSpace.Console;
import Exceptions.*;
import Managers.CollectionManager;

/**
 * Класс команды для обновления элемента коллекции по его id
 */
public class Update extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public Update(Console console, CollectionManager collectionManager) {
        super("update", "id {element}", "обновить значение элемента коллекции, id которого равен заданному");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) throws InvalidArguments, ExitProgram {
        if (args.isBlank()) throw new InvalidArguments();
        try {
            int id = Integer.parseInt(args.trim());
            if (!collectionManager.checkExistById(id)) throw new NoSuchId();
            console.println("Начало создания экземпляра HumanBeing...");
            collectionManager.editById(id, new HumanBeingForm(console).build());
            console.println("Экземпляр HumanBeing успешно создан!");
        } catch (NoSuchId e) {
            console.printError("Нет элемента с таким id");
        } catch (InvalidForm | FileModeException e) {
            console.printError("Поля невалидны => экземпляр не создан");
        } catch (NumberFormatException e) {
            console.printError("id должен быть числом типа long");
        }
    }
}
