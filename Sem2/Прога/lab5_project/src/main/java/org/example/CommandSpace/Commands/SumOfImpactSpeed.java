package CommandSpace.Commands;

import CommandSpace.Console;
import Exceptions.ExitProgram;
import Exceptions.InvalidArguments;
import Managers.CollectionManager;

import java.util.Collection;
import java.util.Objects;
import java.util.Stack;

/**
 * Класс команды для вывода суммы скоростей всех героев коллекции
 */
public class SumOfImpactSpeed extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public SumOfImpactSpeed(Console console, CollectionManager collectionManager) {
        super("sum_of_impact_speed", "вывести сумму значений поля impactSpeed для всех элементов коллекции");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) throws InvalidArguments, ExitProgram {
        if (!args.isBlank()) throw new InvalidArguments();
        if (collectionManager.getCollection().isEmpty()) {
            console.printError("Коллекция пуста");
            return;
        }
        console.print("Сумма значений поля impactSpeed: ");
        int resultSum = collectionManager.getCollection().stream()
                .filter(Objects::nonNull)
                .mapToInt(i -> i.getImpactSpeed()).sum();
        console.println(String.valueOf(resultSum));
    }
}
