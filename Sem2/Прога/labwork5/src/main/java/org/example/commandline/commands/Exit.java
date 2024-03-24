package org.example.commandline.commands;

import org.example.exeptions.ExitErr;

/**
 * Команда 'exit'
 * завершить программу (без сохранения в файл)
 */
public class Exit extends Command{
    public Exit(){
        super("exit",": завершить программу (без сохранения в файл)");
    }
    @Override
    public void execute(String args) throws ExitErr {
        throw new ExitErr();
    }
}
