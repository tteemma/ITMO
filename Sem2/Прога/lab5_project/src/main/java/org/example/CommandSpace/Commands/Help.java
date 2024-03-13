package CommandSpace.Commands;

import CommandSpace.Console;
import Exceptions.InvalidArguments;
import Managers.CommandManager;

/**
 * Класс команды для вывода доступных команд и их описаний
 */
public class Help extends Command {
    private final CommandManager commandManager;
    private final Console console;

    public Help(Console console, CommandManager commandManager) {
        super("help", "вывести справку по доступным командам");
        this.commandManager = commandManager;
        this.console = console;
    }

    public void execute(String args) throws InvalidArguments {
        if (!args.isBlank()) throw new InvalidArguments();
        commandManager.getCommandsHashMap().forEach(
                command -> console.println(command.toString()));
    }
}
