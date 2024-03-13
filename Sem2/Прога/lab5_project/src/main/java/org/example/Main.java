import Collection.Forms.CoordinatesForm;
import Collection.Forms.HumanBeingForm;
import CommandSpace.Commands.*;
import CommandSpace.Console;
import Exceptions.ExitProgram;
import Managers.CollectionManager;
import Managers.CommandManager;
import Managers.FileManager;
import Managers.RuntimeManager;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        CollectionManager collectionManager = new CollectionManager();
        CommandManager commandManager = new CommandManager();
//        try {
//            String pathToFile = args[0];
//        } catch (IndexOutOfBoundsException e) {
//            console.printError("Передайте путь в аргументе!");
//            return;
//        }
        FileManager fileManager = new FileManager(console, collectionManager, "/Users/macbookpro/Yandex.Disk.localized/Итмо/Прога/Лаб5прога/lab5demo/src/Objects.xml");
        try {
            if (fileManager.findFile()) {
                fileManager.createObjects();
            }
        } catch (ExitProgram e) {
            console.println("До свидания!");
            return;
        }

        console.println("Добро пожаловать!" + "\n" + "Введите help для получения списка доступных команд");

        commandManager.addCommandToHashMap(List.of(
                new Help(console, commandManager),
                new Info(console, collectionManager),
                new Show(console, collectionManager),
                new AddElement(console, collectionManager),
                new Update(console, collectionManager),
                new RemoveById(console, collectionManager),
                new Clear(console, collectionManager),
                new Save(console, fileManager),
                new Execute(console, commandManager),
                new Exit(),
                new RemoveLast(console, collectionManager),
                new AddIfMax(console, collectionManager),
                new History(console, commandManager),
                new SumOfImpactSpeed(console, collectionManager),
                new FilterGreaterThanImpactSpeed(console, collectionManager),
                new PrintUniqueMood(console, collectionManager)
        ));
        new RuntimeManager(console, commandManager).runInteractive();
    }
}