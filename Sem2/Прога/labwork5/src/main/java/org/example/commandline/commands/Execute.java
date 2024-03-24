package org.example.commandline.commands;

import org.example.commandline.Console;
import org.example.commandline.PaintConsole;
import org.example.managers.CommandManager;
import org.example.managers.ExecuteSpace;
import org.example.exeptions.CommandRuntimeError;
import org.example.exeptions.ExitErr;
import org.example.exeptions.IllegalArgument;
import org.example.exeptions.NoSuchCommand;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * Команда 'execute_script'
 * Считатывает и исполняет скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
 */
public class Execute extends Command{
    private final Console console;
    private final CommandManager commandManager;

    public Execute(Console console, CommandManager commandManager){
        super("execute_script",": cчитатывает и исполняет скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        this.console = console;
        this.commandManager = commandManager;
    }

    /**
     * Исполнить команду
     * @param args аргументы команды
     * @throws IllegalArgument неверные аргументы команды
     * @throws CommandRuntimeError команда вызвала ошибку при исполнении
     * @throws ExitErr требуется выход из программы
     */
    @Override
    public void execute(String args) throws CommandRuntimeError, IllegalArgument, ExitErr {
        if (args == null || args.isEmpty()){
            console.printError("Путь не введен");
            return;
        }
        else {
            console.println(PaintConsole.paint("Путь получен успешно", PaintConsole.CYAN));
        }
        Console.setFileMode(true);
        try {
            ExecuteSpace.pushFile(args);
            for (String line = ExecuteSpace.readLine(); line != null; line = ExecuteSpace.readLine()){
                try {
                    String[] cmd = (line + " ").split(" ",2);
                    cmd[1] = cmd[1].trim();
                    commandManager.addHistory(cmd[0]);
                    if (cmd[0].isBlank()) {
                        return;
                    }
                    if (cmd[0].equals("execute_script")){
                        if (ExecuteSpace.fileRecursion(cmd[1])){
                            console.printError("Ошибка! Рекурсия пути " + new File(cmd[1]).getAbsolutePath());
                            continue;
                        }
                        ExecuteSpace.pushFile(cmd[1]);
                    }
                    console.println(PaintConsole.paint("Выполнение команды " + cmd[0], PaintConsole.YELLOW));
                    commandManager.execute(cmd[0],cmd[1]);
                    if (cmd[0].equals("execute_script")){
                        ExecuteSpace.popFile();
                    }
                }
                catch (NoSuchCommand noSuchCommand){
                    console.printError("Команды не существует");
                }
                catch (NoSuchElementException noSuchElementException){
                    console.printError("Пользовательский ввод не обнаружен");
                }
                catch (IllegalArgument illegalArgument){
                    console.printError("Введены неверные аргументы команды");
                } catch (CommandRuntimeError commandRuntimeError){
                    console.printError("Возникла ошибка при исполнении команды");
                }
            }
            ExecuteSpace.popFile();
        } catch (NoSuchCommand noSuchCommand){
            console.printError("Команды не существует");
        } catch (FileNotFoundException fileNotFoundException){
            console.printError("Файл не найден");
        } catch (IOException ioException){
            console.printError("Ошибка ввода/вывода");
        }
        Console.setFileMode(false);
    }
}
