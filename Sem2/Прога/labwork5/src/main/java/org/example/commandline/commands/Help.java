package org.example.commandLine.commands;

import org.example.commandLine.Console;
import org.example.commandLine.ConsoleColor;
import org.example.managers.CommandManager;
import org.example.exeptions.IllegalArgument;

/**
 * Команда help нужна для того, чтобы вывести справку по доступным командам
 */
public class Help extends Command{
    private final Console console;
    private final CommandManager commandManager;
    public Help(Console console,CommandManager commandManager){
        super("help",": вывести справку по доступным командам");
        this.commandManager = commandManager;
        this.console = console;
    }

    /**
     * Исполнить команду
     * @param args аргументы команды
     * @throws IllegalArgument неверные аргументы команды
     */
    @Override
    public void execute(String args) throws IllegalArgument{
        if (!args.isBlank()) throw new IllegalArgument();
        commandManager.getCommands()
                .forEach(command -> console.println(ConsoleColor.toColor(command.getName(),ConsoleColor.PURPLE) +
                        ConsoleColor.toColor(command.getDescription(),ConsoleColor.CYAN)));
    }
}
