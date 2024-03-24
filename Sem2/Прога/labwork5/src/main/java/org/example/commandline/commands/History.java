package org.example.commandline.commands;

import org.example.commandline.Console;
import org.example.commandline.PaintConsole;
import org.example.managers.CommandManager;
import org.example.exeptions.IllegalArgument;

import java.util.List;

public class History extends Command{
    private final Console console;
    private final CommandManager commandManager;

    public History(Console console, CommandManager commandManager){
        super("history", ": вывести последние 6 команд (без их аргументов)");
        this.console = console;
        this.commandManager = commandManager;
    }
    /**
     * Исполнить команду
     * @param args аргументы команды
     * @throws IllegalArgument неверные аргументы команды
     */
    @Override
    public void execute(String args) throws IllegalArgument{
        if (!args.isBlank()) throw new IllegalArgument();
        List<String> hisory = commandManager.getCommandHistory();
        for (String command:hisory.subList(Math.max(hisory.size() - 6,0),hisory.size())){
            console.println(PaintConsole.paint(command, PaintConsole.CYAN));
        }
    }
}
