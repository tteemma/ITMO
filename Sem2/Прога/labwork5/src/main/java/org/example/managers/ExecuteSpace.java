package org.example.managers;

import org.example.commandLine.UserInput;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayDeque;

/**
 * Класс для хранения файл менеджера для команды execute
 */
public class ExecuteSpace implements UserInput {
    private static final ArrayDeque<String> paths = new ArrayDeque<>();
    private static final ArrayDeque<BufferedReader> fileReader = new ArrayDeque<>();

    public static void pushFile(String path) throws FileNotFoundException {
        paths.push(String.valueOf(Paths.get(path)));
        fileReader.push(new BufferedReader(new InputStreamReader(new FileInputStream(path))));
    }

    public static void popFile() throws IOException {
        fileReader.getFirst().close();
        fileReader.pop();
        paths.pop();
    }

    public File getFile() {
        return new File(paths.getLast());
    }

    public static String readLine() throws IOException {
        return fileReader.getFirst().readLine();
    }

    /**
     * Метод для обнаружения рекурсий в скриптах
     */
    public static boolean fileRecursion(String path) {
        return paths.contains(path);
    }

    @Override
    public String nextLine() {
        try {
            return readLine();
        } catch (IOException e) {
            return "";
        }
    }
}
