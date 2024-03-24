package org.example.managers;


import org.example.commandline.Console;
import org.example.commandline.Printable;
import org.example.exeptions.*;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс обработки пользовательского ввода
 */
public class UserInputManager{
    private final Printable console;
    private final CommandManager commandManager;

    public UserInputManager(Console console, CommandManager commandManager) {
        this.console = console;
        this.commandManager = commandManager;
    }
    /**
     * Метод для выполнения команды из {@link CommandManager}
     * @param userCommand массив из 2 элементов, первый - название команды, второй - аргументы
     * @throws NoSuchCommand несуществующая команда
     * @throws ExitErr команда привела к окончанию работы программы
     * @throws IllegalArgument команда содержит неверные аргументы
     * @throws CommandRuntimeError команда выдала ошибку во время выполнения
     */
    public void launch(String[] userCommand) throws NoSuchCommand, ExitErr, IllegalArgument, CommandRuntimeError {
        if (userCommand[0].equals("")) return;
        commandManager.execute(userCommand[0],userCommand[1]);

//        if (userCommand.length > 1) {
//            commandManager.execute(userCommand[0], userCommand[1]);
//        } else {
//            commandManager.execute(userCommand[0], null); // Передаем null, если аргумент отсутствует
//        }
    }

    /**
     * Интерактивный мод для работы в пользователем
     */
    public void interactiveMode() {
        Scanner userScanner = ScanerManager.getUserScaner();
        while (true) {
            try {
                if (!userScanner.hasNext()) throw new ExitErr();
                String userCommand = userScanner.nextLine().trim() + " ";
                String[] cmd = userCommand.split(" ", 2);
                if (cmd.length > 1) {
                    cmd[1] = cmd[1].trim(); // Убираем пробелы вокруг аргумента
                }
                this.launch(cmd);
                commandManager.addHistory(userCommand);
            } catch (NoSuchElementException exception) {
                console.printError("Пользовательский ввод не обнаружен!");
            } catch (NoSuchCommand noSuchCommand) {
                console.printError("Такой команды нет в списке");
            } catch (IllegalArgument e) {
                console.printError("Введены неправильные аргументы команды");
            } catch (CommandRuntimeError e) {
                console.printError("Ошибка при исполнении команды");
            } catch (ExitErr exitObliged) {
//                console.println(ConsoleColor.toColor("До свидания!", ConsoleColor.YELLOW));
                return;
            }
        }
    }
}