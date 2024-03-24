package org.example.commandline;

import org.example.managers.ScanerManager;

import java.util.Scanner;

public class ConsoleInput implements UserInput{
    private final static Scanner userScaner = ScanerManager.getUserScaner();

    @Override
    public String nextLine(){
        return userScaner.nextLine();
    }
}
