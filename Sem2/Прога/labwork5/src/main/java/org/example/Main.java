package org.example;

import org.example.commandline.Console;
import org.example.commandline.PaintConsole;
import org.example.managers.*;
import org.example.commandline.commands.*;
import org.example.exeptions.ExitErr;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        CommandManager commandManager = new CommandManager();
        CollectionManager collectionManager = new CollectionManager();
        try {
            String pathToFile = args[0];
            console.println(PaintConsole.paint("Здравствуйте", PaintConsole.PINK));
            console.println(PaintConsole.paint("Введите команду " + new Help(console, commandManager).getName() + " чтобы узнать информацию о доступных командах:", PaintConsole.PINK));
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
                console.println(PaintConsole.paint("До свидания!", PaintConsole.YELLOW));
            }
        });
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

//        Signal.handle(new Signal("TSTP"), new SignalHandler() {
//            @Override
//            public void handle(Signal signal) {
//                System.out.println("Вы нажали Control-Z");
//            }
//        });
//KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());