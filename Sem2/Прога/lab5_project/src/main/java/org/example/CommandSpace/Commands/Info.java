package CommandSpace.Commands;

import CommandSpace.Console;
import CommandSpace.Inputable;
import Exceptions.InvalidArguments;
import Managers.CollectionManager;

/**
 * Класс команды для вывода текущей информации о коллекции
 */
public class Info extends Command {
    private final CollectionManager collectionManager;
    private final Console console;

    public Info(Console console, CollectionManager collectionManager) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args) throws InvalidArguments {
        if (!args.isBlank()) throw new InvalidArguments();
        String lastInitTime = (collectionManager.getLastInitTime() == null)
                ? "коллекция в сессии не инициализирована"
                : collectionManager.getLastInitTime();
        String lastSaveTime = (collectionManager.getLastSaveTime() == null)
                ? "-"
                : collectionManager.getLastSaveTime();
        StringBuilder resultInfo = new StringBuilder();
        resultInfo.append("*** Сведения о коллекции ***" + "\n")
                .append("Тип: " + collectionManager.getCollectionType() + "\n")
                .append("Количество элементов: " + collectionManager.getSize() + "\n")
                .append("Дата последней инициализации: " +  lastInitTime + "\n")
                .append("Дата последнего изменения: " + lastSaveTime + "\n");
        console.print(resultInfo.toString());
    }
}
