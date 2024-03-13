package org.example;

import org.example.commandLine.Console;
import org.example.commandLine.ConsoleColor;
import org.example.managers.*;
import org.example.commandLine.commands.*;
import org.example.exeptions.ExitErr;
import sun.misc.Signal;
import sun.misc.SignalHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        CommandManager commandManager = new CommandManager();
        CollectionManager collectionManager = new CollectionManager();
        try {
            String pathToFile = args[0];
            console.println(ConsoleColor.toColor("Здравствуйте", ConsoleColor.PINK));
            console.println(ConsoleColor.toColor("Введите команду " + new Help(console, commandManager).getName() + " чтобы узнать информацию о доступных командах:", ConsoleColor.PINK));
        } catch (IndexOutOfBoundsException boundsException) {
            console.printError("Передайте путь в аргумете.......");
            return;
        }
        String s = args[0];
//        String s = "C:\\Users\\User\\Desktop\\Учеба\\Sem2\\Прога\\labwork5\\src\\main\\my_file.xml";
        FileManager fileManager = new FileManager(console, collectionManager, s);
        try {
            if (fileManager.isFindFile()) {
                fileManager.createObjects();
            }
        } catch (ExitErr e) {
            return;
        }
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                console.println(ConsoleColor.toColor("До свидания!",ConsoleColor.YELLOW));
            }
        });
        KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
        commandManager.addCommand(List.of(
                new AddElem(console, collectionManager),
                new Exit(),
                new Show(console, collectionManager),
                new UpdateId(console, collectionManager),
                new RemoveById(console, collectionManager),
                new Clear(console, collectionManager),
                new Help(console, commandManager),
                new History(console, commandManager),
                new Info(console, collectionManager),
                new RemoveGreater(console, collectionManager),
                new AddIfMin(console, collectionManager),
                new PrintDescending(console, collectionManager),
                new PrintFieldDescendingDistance(console, collectionManager),
                new GroupCountingByDistance(console, collectionManager),
                new Save(console, fileManager),
                new Execute(console, commandManager)
        ));
        UserInputManager userInputManager = new UserInputManager(console, commandManager);
        userInputManager.interactiveMode();
    }
}