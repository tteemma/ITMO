package CommandSpace;

import Exceptions.ExitProgram;
import Exceptions.InvalidArguments;

/**
 * Интерфейс для исполнения команд
 */
public interface Executable {
    void execute(String args) throws InvalidArguments, ExitProgram;
}
