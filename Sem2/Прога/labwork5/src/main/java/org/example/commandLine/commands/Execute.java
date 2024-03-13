package org.example.commandLine.commands;

import org.example.commandLine.Console;
import org.example.commandLine.ConsoleColor;
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
//    private final Console console;
//    private final CommandManager commandManager;
//
//    public Execute(Console console, CommandManager commandManager) {
//        super("execute_script", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме");
//        this.console = console;
//        this.commandManager = commandManager;
//    }
//
//    @Override
//    public void execute(String args) throws IllegalArgument, ExitErr {
//        if (args == null || args.isEmpty()) {
//            console.printError("Отсутствует путь к исполняемому файлу");
//            return;
//        } else {
//            console.println(ConsoleColor.toColor("Путь получен успешно",ConsoleColor.CYAN));
//        }
//        Console.setFileMode(true);
//        try {
//            ExecuteSpace.pushFile(args.trim());
//            for (String line = ExecuteSpace.readLine(); line != null; line = ExecuteSpace.readLine()) {
//                try {
//                    String[] command = (line.trim() + " ").split(" ", 2);
//                    command[1] = command[1].trim();
//                    commandManager.addHistory(command[0]);
//                    if (command[0].isBlank()) return;
//                    if (command[0].equals("execute_script")) {
//                        if (ExecuteSpace.fileRecursion(command[1])) {
//                            console.printError("Обнаружена рекурсия" + new File(command[1]).getAbsolutePath());
//                            continue;
//                        }
//                    }
//                    console.println(ConsoleColor.toColor("Выполнение команды " + command[0], ConsoleColor.GREEN));
//                    commandManager.execute(command[0], command[1]);
//                    if (command[0].equals("execute_script")) {
//                        ExecuteSpace.popFile();
//                    }
//                } catch (NoSuchCommand e) {
//                    console.printError("Такой команды нет в списке");
//                } catch (NoSuchElementException e) {
//                    console.printError("Пользовательский ввод не обнаружен");
//                } catch (IllegalArgument e) {
//                    console.printError("Введены неверные аргументы команды");
//                } catch (CommandRuntimeError e) {
//                    console.printError("Ошибка при исполнении команды");
//                }
//            }
//            ExecuteSpace.popFile();
//        } catch (NoSuchCommand e) {
//            console.printError("Такой команды нет в списке");
//        } catch (FileNotFoundException e) {
//            console.printError("Исполняемый файл не найден");
//        } catch (IOException e) {
//            console.printError("Ошибка ввода/вывода");
//        } catch (NoSuchElementException e) {
//            console.println(ConsoleColor.toColor("Конец выполняемого скрипта", ConsoleColor.YELLOW));
//        }
//        Console.setFileMode(false);
//    }
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
            console.println(ConsoleColor.toColor("Путь получен успешно",ConsoleColor.CYAN));
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
                    console.println(ConsoleColor.toColor("Выполнение команды " + cmd[0], ConsoleColor.YELLOW));
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
