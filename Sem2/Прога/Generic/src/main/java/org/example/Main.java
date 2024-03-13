package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileWriter fr = null;
        int k = 5;
        Scanner scanner = new Scanner(System.in);
        while (k != 0){
            try {
                String path = scanner.nextLine();
                File file = new File(path);
                String str = scanner.nextLine();
                fr =  new FileWriter(file,true);
                fr.write(str);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            k --;
        }
    }
}