package org.example.commandLine;
/**
 * Интерфейс способов вывода
 */
public interface Printable {
    void println(String a);
    void print(String a);
    void printError(String a);
}