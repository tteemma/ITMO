package org.example.managers;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.security.AnyTypePermission;
import org.example.commandLine.Console;
import org.example.commandLine.ConsoleColor;
import org.example.commandLine.Printable;
import org.example.models.Route;
import org.example.exeptions.ExitErr;
import org.example.exeptions.InvalidForm;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileManager {
    private String text;
    private final String pathToFile;
    private final Printable console;
    private final CollectionManager collectionManager;
    private final XStream xStream = new XStream();

    /**
     * В конструкторе задаются алиасы для библиотеки {@link XStream} которая используется для работы с xml
     *
     * @param console           Пользовательский ввод-вывод
     * @param collectionManager Работа с коллекцией
     * @param fileToPath        путь до файла
     */
    public FileManager(Console console, CollectionManager collectionManager, String fileToPath) {
        this.console = console;
        this.collectionManager = collectionManager;
        this.pathToFile = fileToPath;

        xStream.alias("Route", Route.class);
        xStream.alias("Array", CollectionManager.class);
        xStream.addPermission(AnyTypePermission.ANY);
        xStream.addImplicitCollection(CollectionManager.class, "collection");
    }

    /**
     * Метод проверяющий валидность файла
     *
     * @throws ExitErr если путь - null или отсутствует программа заканчивает выполнение
     */
    public boolean isFindFile() throws ExitErr {
        File file = new File(pathToFile);
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            fileInputStream = new FileInputStream(file);
            bufferedInputStream = new  BufferedInputStream(fileInputStream);
            while (bufferedInputStream.available() > 0) {
                stringBuilder.append((char) bufferedInputStream.read());
            }
            fileInputStream.close();
            bufferedInputStream.close();
            if (stringBuilder.isEmpty()) {
                console.printError("Передан пустой файл");
                this.text = "</Array>";
                return false;
            }
            this.text = stringBuilder.toString();
        } catch (FileNotFoundException e) {
            console.printError("Файл не найден");
            throw new ExitErr();
        } catch (IOException e) {
            console.printError("Ошибка ввода/вывода");
            throw new ExitErr();
        }
        return true;
    }

    /**
     * Метод для считывания коллекции в формате XML(из файла) и перевода в TreeSet коллекцию
     *
     * @throws ExitErr Если объекты в файле невалидны выходим из программы
     */
    public void createObjects() throws ExitErr {
        try {
            XStream xStreamCreator = new XStream();
            xStreamCreator.alias("Route", Route.class);
            xStreamCreator.alias("Array", CollectionManager.class);
            xStreamCreator.addPermission(AnyTypePermission.ANY);
            xStreamCreator.addImplicitCollection(CollectionManager.class, "collection");

            CollectionManager collectionWithObjects = (CollectionManager) xStreamCreator.fromXML(text);
            this.collectionManager.setLastSaveTime(collectionWithObjects.getLastSaveTimeInDate());
            this.collectionManager.setLastInitTime(collectionWithObjects.getInitTimeInDate());

            if (collectionWithObjects.getCollection() == null) {
                console.printError("Файл содержет пустую коллекцию");
                return;
            }
            for (Route route : collectionWithObjects.getCollection()) {
                if (collectionManager.checkExist(route.getId())) {
                    console.printError("В файле имеются повторяющиеся id");
                    throw new ExitErr();
                }
                this.collectionManager.addElement(route);
            }
            this.collectionManager.setLastSaveTime(collectionWithObjects.getLastSaveTimeInDate());
        } catch (InvalidForm | StreamException exception) {
            console.printError("Объекты из файла не валидны");
        } catch (ConversionException e) {
            console.printError("Неверная структура XML файла.");
        }
        Route.updateId(collectionManager.getCollection());
    }

    /**
     * Метод для сохранения коллекции в файл
     */
    public void saveObjects() {
        String file_path = pathToFile;
        if (file_path == null || file_path.isEmpty()){
            console.printError("Вы ничего не ввели");
            return;
        } else console.println(ConsoleColor.toColor("Путь к файлу успешно получен",ConsoleColor.CYAN));
        try {
            BufferedOutputStream bis = new BufferedOutputStream(new FileOutputStream(file_path));
            bis.write(xStream.toXML(collectionManager).getBytes(StandardCharsets.UTF_8));
            bis.close();
        } catch (FileNotFoundException e) {
            console.printError("Файл не найден");
        } catch (IOException ioException) {
            console.printError("Ошибка ввода/вывода");
        }
    }
}