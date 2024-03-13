package org.example.commandLine.commands;

import org.example.commandLine.Console;
import org.example.commandLine.ConsoleColor;
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
        fileManager.saveObjects();
        console.println(ConsoleColor.toColor("Коллекция успешно сохранена", ConsoleColor.CYAN));
    }
}
