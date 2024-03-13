package org.example.managers;

import org.example.commandLine.commands.Command;
import org.example.exeptions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Командный менеджер.
 * Реализует паттерн программирования Command
 */
public class CommandManager {
    /**
     * Поле для хранения комманд в виде Имя-Комманда
     */
    private final HashMap<String, Command> commands = new HashMap<String, Command>();
    /**
     * Поле для хранения истории команд
     */
    private final List<String> commandHistory = new ArrayList<>();

    /**
     * Метод для добавления команды
     */
    public void addCommand(Command command){
        this.commands.put(command.getName(),command);
    }
    public void addCommand(Collection<Command> commands){
        this.commands.putAll(commands.stream().collect(Collectors.toMap(Command::getName, s -> s)));
    }
    public Collection<Command> getCommands(){
       return this.commands.values();
    }
    public void addHistory(String arg){
        if(arg.isBlank()) return;
        this.commandHistory.add(arg);
    }
    public List<String> getCommandHistory(){
        return this.commandHistory;
    }

    /**
     * Выполняет команду
     * @param name название команды
     * @param args аргументы команды
     * @throws NoSuchCommand такая команда отсутствует
     * @throws IllegalArgument неверные аргументы команды
     * @throws CommandRuntimeError команда выдала ошибку при исполнении
     * @throws ExitErr команда вызвала выход из программы
     */
    public void execute(String name, String args) throws NoSuchCommand, IllegalArgument, CommandRuntimeError, ExitErr {
        Command command = commands.get(name);
        if (command == null) throw new NoSuchCommand();
        command.execute(args);
    }
}
