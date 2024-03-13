package org.example.commandLine;

import org.example.exeptions.CommandRuntimeError;
import org.example.exeptions.ExitErr;
import org.example.exeptions.IllegalArgument;

/**
 * Интерфейс для исполняемых команд
 */
public interface Executable {
    void execute(String args) throws CommandRuntimeError, IllegalArgument, ExitErr;
}
