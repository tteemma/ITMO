package org.example.commandLine;

import org.example.managers.ScanerManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class ConsoleInput implements UserInput{
    private final static Scanner userScaner = ScanerManager.getUserScaner();

    @Override
    public String nextLine(){
        return userScaner.nextLine();
    }
}
