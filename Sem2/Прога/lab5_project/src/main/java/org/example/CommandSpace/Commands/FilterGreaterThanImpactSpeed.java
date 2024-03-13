package CommandSpace.Commands;

import CommandSpace.Console;
import Exceptions.ExitProgram;
import Exceptions.FileModeException;
import Exceptions.InvalidArguments;
import Exceptions.InvalidForm;
import Managers.CollectionManager;

import java.util.Objects;
import java.util.logging.Filter;
import java.util.stream.Collectors;

/**
 * Класс команды для вывода элементов коллекции, скорость героя которых больше заданной
 */
public class FilterGreaterThanImpactSpeed extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public FilterGreaterThanImpactSpeed(Console console, CollectionManager collectionManager) {
        super("filter_greater_than_impact_speed", "impactSpeed",
                "вывести элементы значение поля impactSpeed (int) которых больше заданного");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) throws InvalidArguments, ExitProgram {
        if (args.isBlank()) throw new InvalidArguments();
        try {
            int valueMark = Integer.parseInt(args.trim());
            console.println("Элементы со значением поля impactSpeed, большим " + valueMark + ":");
            console.println(collectionManager.getCollection().stream()
                    .filter(Objects::nonNull)
                    .filter(i -> i.getImpactSpeed() > valueMark)
                    .map(Object::toString)
                    .collect(Collectors.joining("\n")));
        } catch (NumberFormatException e) {
            console.printError("Аргумент должен быть числом типа int");
        }
    }
}
