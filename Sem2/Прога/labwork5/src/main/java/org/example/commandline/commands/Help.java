package org.example.commandline.commands;

import org.example.commandline.Console;
import org.example.commandline.PaintConsole;
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
                .forEach(command -> console.println(PaintConsole.paint(command.getName(), PaintConsole.PURPLE) +
                        PaintConsole.paint(command.getDescription(), PaintConsole.CYAN)));
    }
}
