package CommandSpace.Commands;

import Exceptions.ExitProgram;
import Exceptions.InvalidArguments;

/**
 * Класс команды завершения работы приложения
 */
public class Exit extends Command {
    public Exit() {
        super("exit", "завершить программу (без сохранения в файл)");
    }

    public void execute(String args) throws ExitProgram {
        throw new ExitProgram();
    }
}
