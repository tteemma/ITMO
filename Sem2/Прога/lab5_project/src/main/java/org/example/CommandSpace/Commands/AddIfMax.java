package CommandSpace.Commands;

import Collection.Forms.HumanBeingForm;
import Collection.HumanBeing;
import CommandSpace.Console;
import Exceptions.ExitProgram;
import Exceptions.FileModeException;
import Exceptions.InvalidArguments;
import Exceptions.InvalidForm;
import Managers.CollectionManager;

import java.util.Objects;

/**
 * Класс команды создания нового элемента и добавления его в коллекцию, если тот больше остальных
 */
public class AddIfMax extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public AddIfMax(Console console, CollectionManager collectionManager) {
        super("add_if_max", "{element}", "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) throws InvalidArguments, ExitProgram {
        if (!args.isBlank()) throw new InvalidArguments();
        try {
            console.println("Значение элемента вычисляется, как сумма расстояния до центра, скорости удара и 0 или 100, если герой реален и нет, соответственно");
            console.println("Значение текущего максимального элемента: " + collectionManager.getMaxPrice());
            console.println("Начало создания экземпляра HumanBeing...");
            HumanBeing newHumanBeing = new HumanBeingForm(console).build();
            console.println("Экземпляр HumanBeing успешно создан!");
            if (newHumanBeing.compareTo(collectionManager.getCollection().stream()
                    .filter(Objects::nonNull)
                    .max(HumanBeing::compareTo)
                    .orElse(null)) >= 1) {
                collectionManager.addElement(newHumanBeing);
                console.println("Объект успешно добавлен");
            } else {
                console.println("Новый элемент меньше максимального");
            }
        } catch (InvalidForm | FileModeException e) {
            console.printError("Поля невалидны => экземпляр не создан");
        }
    }
}
