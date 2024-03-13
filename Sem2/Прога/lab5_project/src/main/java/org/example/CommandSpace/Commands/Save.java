package CommandSpace.Commands;

import CommandSpace.Console;
import Exceptions.ExitProgram;
import Exceptions.InvalidArguments;
import Exceptions.InvalidForm;
import Managers.FileManager;

/**
 * Класс команды для сохранения коллекции в файл
 */
public class Save extends Command {
    private final Console console;
    private final FileManager fileManager;

    public Save(Console console, FileManager fileManager) {
        super("save", "сохранить коллекцию в файл");
        this.console = console;
        this.fileManager = fileManager;
    }

    @Override
    public void execute(String args) throws InvalidArguments, ExitProgram {
        if (!args.isBlank()) throw new InvalidArguments();
        fileManager.saveObjects();
        console.println("Объекты сохранены успешно");
    }
}
