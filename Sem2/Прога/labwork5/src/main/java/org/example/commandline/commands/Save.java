package org.example.commandline.commands;

import org.example.commandline.Console;
import org.example.commandline.PaintConsole;
import org.example.managers.FileManager;
import org.example.exeptions.IllegalArgument;

/**
 * Команда 'save'
 * Сохраняет коллекцию в файл
 */
public class Save extends Command {
    private final Console console;
    private final FileManager fileManager;

    public Save(Console console, FileManager fileManager) {
        super("save", ": сохранить коллекцию в файл");
        this.console = console;
        this.fileManager = fileManager;
    }

    /**
     * Исполнить команду
     *
     * @param args аргументы команды
     * @throws IllegalArgument неверные аргументы команды
     */
    @Override
    public void execute(String args) throws IllegalArgument {
        if (!args.isBlank()) throw new IllegalArgument();
        fileManager.saveToFile();
        console.println(PaintConsole.paint("Коллекция успешно сохранена", PaintConsole.CYAN));
    }
}
