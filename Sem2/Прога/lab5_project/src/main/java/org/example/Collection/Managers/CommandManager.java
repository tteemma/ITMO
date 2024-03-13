package Managers;

import CommandSpace.Commands.Command;
import CommandSpace.Console;
import Exceptions.CommandRuntimeError;
import Exceptions.ExitProgram;
import Exceptions.InvalidArguments;
import Exceptions.NoSuchCommand;
import com.sun.tools.jconsole.JConsoleContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс менеджера комманд, содержащий информацию о них и их историю
 */
public class CommandManager {
    private final HashMap<String, Command> commandsHashMap = new HashMap<>();
    private final List<String> commandHistory = new ArrayList<>();

    public void addCommandToHashMap(Command command) {
        this.commandsHashMap.put(command.getName(), command);
    }

    public void addCommandToHashMap(Collection<Command> commands) {
        this.commandsHashMap.putAll(commands.stream().collect((Collectors.toMap(Command::getName, s -> s))));
    }

    public Collection<Command> getCommandsHashMap() {
        return commandsHashMap.values();
    }

    public void addToHistory(String line) {
        if (line.isBlank()) return;
        this.commandHistory.add(line);
    }

    public List<String> getCommandHistory() {
        return commandHistory;
    }

    public void execute(String name, String args) throws ExitProgram, InvalidArguments, NoSuchCommand, CommandRuntimeError {
        Command command = commandsHashMap.get(name);
        if (command == null) throw new NoSuchCommand();
        command.execute(args);
    }
}
