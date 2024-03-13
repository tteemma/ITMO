package org.example.commandLine.commands;

import org.example.commandLine.Console;
import org.example.commandLine.ConsoleColor;
import org.example.managers.CollectionManager;
import org.example.exeptions.IllegalArgument;

/**
 * Команда 'info'
 * Выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
 */
public class Info extends Command{
    private final Console console;
    private final CollectionManager collectionManager;

    public Info(Console console, CollectionManager collectionManager){
        super("info",": вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        this.console = console;
        this.collectionManager = collectionManager;
    }
    /**
     * Исполнить команду
     * @param args аргументы команды
     * @throws IllegalArgument неверные аргументы команды
     */
    @Override
    public void execute(String args) throws IllegalArgument {
        if (!args.isBlank()) throw new IllegalArgument();
        String lastInitTime = (collectionManager.getLastInitTime() == null)
                ? "Коллекция еще не инициализирована"
                : collectionManager.getLastInitTime();
        String lastSaveTime = (collectionManager.getLastSaveTime() == null)
                ? "Коллекция еще не сохранена"
                : collectionManager.getLastSaveTime();
        StringBuilder info = new StringBuilder();
        info.append("Сведения о коллекции...\n")
                .append(ConsoleColor.toColor("Тип: ",ConsoleColor.CYAN) + collectionManager.getCollectionType() + "\n")
                .append(ConsoleColor.toColor("Размер коллекции: ",ConsoleColor.CYAN) + collectionManager.getCollectionSize() + "\n")
                .append(ConsoleColor.toColor("Дата последней инициализации: ", ConsoleColor.CYAN) + lastInitTime + "\n")
                .append(ConsoleColor.toColor("Дата последнего сохранения: ", ConsoleColor.CYAN) + lastSaveTime + "\n");
        console.println(info.toString());
    }
}
