package org.example.models.form;

import org.example.commandLine.*;
import org.example.managers.ExecuteSpace;
import org.example.models.Coordinates;

/**
 * Форма пользовательского ввода для координат
 */
public class CoordinatesInput extends Form<Coordinates> {

    private final Printable consol;
    private final UserInput scaner;

    public CoordinatesInput(Printable consol){ // С чтением из файла надо будет переделать немного
        this.consol =(Console.isFileMode())
                ? new BlankConsole()
                : consol;
        this.scaner = (Console.isFileMode())
                ? new ExecuteSpace()
                : new ConsoleInput();
    }

    private int userInputX(){
        consol.println(ConsoleColor.toColor("Введите значения координат пути:",ConsoleColor.CYAN));
        while (true){
            consol.println(ConsoleColor.toColor("Введите координату Х: ", ConsoleColor.GREEN));
            String userInputt = scaner.nextLine().trim();
            try {
                return Integer.parseInt(userInputt);
            }catch (NumberFormatException exception){
                consol.printError("Неверный тип переменной, переменная должна быть типа int");
            }
        }
    }
    private Float userInputY(){
        while (true){
            consol.println(ConsoleColor.toColor("Введите координату Y: ", ConsoleColor.GREEN));
            String userInputt = scaner.nextLine().trim();
            try {
                return Float.parseFloat(userInputt);
            }catch (NumberFormatException exception){
                consol.printError("Неверный тип переменной, переменная должна быть типа Float");
            }
        }
    }

    @Override
    public Coordinates create(){
        return new Coordinates(userInputX(),userInputY());
    }
}
