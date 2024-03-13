package org.example.managers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

/**
 * Класс хранящий сканер для программы
 */
public class ScanerManager {
    public static Scanner userScaner = new Scanner(System.in);
    public static Scanner getUserScaner(){
        return userScaner;
    }
}
