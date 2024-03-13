package CommandSpace.Commands;

import Collection.HumanBeing;
import CommandSpace.Console;
import CommandSpace.Printable;
import Exceptions.ExitProgram;
import Exceptions.InvalidArguments;
import Managers.CollectionManager;

import java.util.Objects;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Класс команды для вывода уникальных значений настроения героев
 */
public class PrintUniqueMood extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public PrintUniqueMood(Console console, CollectionManager collectionManager) {
        super("print_unique_mood", "вывести уникальные значения поля mood всех элементов коллекции");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) throws InvalidArguments, ExitProgram {
        if (!args.isBlank()) throw new InvalidArguments();
        console.println("Уникальные значения поля mood элементов коллекции:"); //добавить вариант на пустоту
        collectionManager.getCollection().stream()
                .filter(Objects::nonNull)
                .map(HumanBeing::getMood)
                .distinct()
                .forEach(x -> console.println(String.valueOf(x)));
    }
}
