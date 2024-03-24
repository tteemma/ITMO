package org.example.commandline.commands;

import org.example.commandline.Console;
import org.example.commandline.PaintConsole;
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
                .append(PaintConsole.paint("Тип: ", PaintConsole.CYAN) + collectionManager.getCollectionType() + "\n")
                .append(PaintConsole.paint("Размер коллекции: ", PaintConsole.CYAN) + collectionManager.getCollectionSize() + "\n")
                .append(PaintConsole.paint("Дата последней инициализации: ", PaintConsole.CYAN) + lastInitTime + "\n")
                .append(PaintConsole.paint("Дата последнего сохранения: ", PaintConsole.CYAN) + lastSaveTime + "\n");
        console.println(info.toString());
    }
}
