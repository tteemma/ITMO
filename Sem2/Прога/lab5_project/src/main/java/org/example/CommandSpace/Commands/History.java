package CommandSpace.Commands;

import CommandSpace.Console;
import Exceptions.ExitProgram;
import Exceptions.InvalidArguments;
import Managers.CollectionManager;
import Managers.CommandManager;

import java.util.List;

/**
 * Класс команды для вывода 9 последних команд из истории
 */
public class History extends Command {
    private CommandManager commandManager;
    private Console console;

    public History(Console console, CommandManager commandManager) {
        super("history", "вывести последние 9 команд (без их аргументов)");
        this.console = console;
        this.commandManager = commandManager;
    }

    @Override
    public void execute(String args) throws InvalidArguments, ExitProgram {
        if (!args.isBlank()) throw new InvalidArguments();
        List<String> history = commandManager.getCommandHistory();
        if (history.isEmpty()) {
            console.println("История команд пуста");
            return;
        }
        for (String command : history.subList(Math.max(history.size() - 9, 0), history.size())) {
            console.println(command);
        }
    }
}
