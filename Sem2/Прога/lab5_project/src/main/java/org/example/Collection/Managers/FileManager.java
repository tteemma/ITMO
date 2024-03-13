package Managers;

import Collection.HumanBeing;
import CommandSpace.Console;
import CommandSpace.Printable;
import Exceptions.ExitProgram;
import Exceptions.InvalidForm;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.*;

/**
 * Менеджер работы с файлом
 */
public class FileManager {
    private String text;
    private final String pathToFile;
    private final Printable console;
    private final CollectionManager collectionManager;
    private final XStream xStream = new XStream();

    public FileManager(Console console, CollectionManager collectionManager, String pathToFile) {
        this.console = console;
        this.collectionManager = collectionManager;
        this.pathToFile = pathToFile;

        xStream.alias("HumanBeing", HumanBeing.class);
        xStream.alias("Array", CollectionManager.class);
        xStream.addPermission(AnyTypePermission.ANY);
        xStream.addImplicitCollection(CollectionManager.class, "collection");
    }

    /**
     * Метод, проверяющий доступность файла
     */
    public boolean findFile() throws ExitProgram {
        File file = new File(pathToFile);
        BufferedReader bufferedReader;
        FileReader fileReader;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                stringBuilder.append(bufferedReader.readLine());
            }
            fileReader.close();
            bufferedReader.close();
            if (stringBuilder.isEmpty()) {
                console.printError("Передан пустой файл");
                text = "</Array>";
                return false;
            }
            text = stringBuilder.toString();
        } catch (FileNotFoundException e) {
            console.printError("Файл не найден");
            throw new ExitProgram();
        } catch (IOException e) {
            console.printError("Ошибка ввода/вывода " + e);
            throw new ExitProgram();
        }
        return true;
    }

    /**
     * Метод, считывающий коллекцию из файла
     */
    public void createObjects() throws ExitProgram {
        try {
            XStream xStreamCreate = new XStream();
            xStreamCreate.alias("HumanBeing", HumanBeing.class);
            xStreamCreate.alias("Array", CollectionManager.class);
            xStreamCreate.addPermission(AnyTypePermission.ANY);
            xStreamCreate.addImplicitCollection(CollectionManager.class, "collection");

            CollectionManager collectionManagerCreating = (CollectionManager) xStreamCreate.fromXML(text);
            this.collectionManager.setLastSaveTime(collectionManagerCreating.getLastSaveTimeInDate());
            this.collectionManager.setLastInitTime(collectionManagerCreating.getInitTimeInDate());

            if (collectionManagerCreating.getCollection() == null) {
                console.printError("Коллекция в файле пуста");
                return;
            }
            for (HumanBeing humanBeing : collectionManagerCreating.getCollection()) {
                if (collectionManager.checkExistById(humanBeing.getId())) {
                    console.printError("Найдены повторяющиеся id в файле");
                    throw new ExitProgram();
                }
                this.collectionManager.addElement(humanBeing);
            }
            this.collectionManager.setLastSaveTime(collectionManagerCreating.getLastSaveTimeInDate());
        } catch (InvalidForm | StreamException e) {
            console.printError("Объекты из файла невалидны");
        } catch (com.thoughtworks.xstream.converters.ConversionException e) {
            console.printError("Нарушена структура xml файла с данными");
        }
        HumanBeing.updateIdPoint(collectionManager.getCollection());
    }

    /**
     * Метод, записывающий коллекцию в файл
     */
    public void saveObjects() {
        String filePath = pathToFile;
        if (filePath == null || filePath.isEmpty()) {
            console.printError("Пустой путь недопустим");
            return;
        } else {
            console.println("Путь к файлу успешно получен");
        }
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(filePath));
            printWriter.write(xStream.toXML(collectionManager));
            printWriter.close();
        } catch (FileNotFoundException e) {
            console.printError("Файл не найден");
        } catch (IOException e) {
            console.printError("Ошибка ввода/вывода");
        }
    }
}
