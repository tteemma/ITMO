package Managers;

import CommandSpace.Console;
import CommandSpace.Printable;
import Exceptions.CommandRuntimeError;
import Exceptions.ExitProgram;
import Exceptions.InvalidArguments;
import Exceptions.NoSuchCommand;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс менеджера работы приложения
 */
public class RuntimeManager {
    private final Printable console;
    private final CommandManager commandManager;

    public RuntimeManager(Console console, CommandManager commandManager) {
        this.console = console;
        this.commandManager = commandManager;
    }

    /**
     * Метод, запускающий интерактивный режим работы приложения
     */
    public void runInteractive() {
        Scanner userScanner = ScannerManager.getUserScanner();
        while (true) {
            try {
                if (!userScanner.hasNext()) throw new ExitProgram();
                String userCommand = userScanner.nextLine().trim() + " ";
                this.launch(userCommand.split(" ", 2));
                commandManager.addToHistory(userCommand);
            } catch (NoSuchElementException e) {
                console.printError("Пошел нахуй");
            } catch (InvalidArguments e) {
                console.printError("Введены неверные аргументы для команды");
            } catch (NoSuchCommand e) {
                console.printError("Такой команды нет в списке (введите help для получения списка доступных команд)");
            } catch (CommandRuntimeError e) {
                console.printError("Ошибка при исполнении команды");
            } catch (ExitProgram e) {
                console.println("До свидания!");
                return;
            }
        }
    }

    /**
     * Метод, исполняющий введенную команду
     * @param receivedCommand
     */
    public void launch(String[] receivedCommand) throws ExitProgram, InvalidArguments, NoSuchCommand, CommandRuntimeError {
        if (receivedCommand[0].isEmpty()) return;
        commandManager.execute(receivedCommand[0], receivedCommand[1]);
    }
}
