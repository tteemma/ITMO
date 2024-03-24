package org.example.models.form;

import org.example.commandline.*;
import org.example.managers.ExecuteSpace;
import org.example.models.Coordinates;

/**
 * Форма пользовательского ввода для координат
 */
public class CoordinatesInput extends UserInputForm<Coordinates> {

    private final Printable consol;
    private final UserInput scaner;

    public CoordinatesInput(Printable consol){ // С чтением из файла надо будет переделать немного
        this.consol =(Console.isFileMode())
                ? new ExecuteConsole()
                : consol;
        this.scaner = (Console.isFileMode())
                ? new ExecuteSpace()
                : new ConsoleInput();
    }

    private int userInputX(){
        consol.println(PaintConsole.paint("Введите значения координат пути:", PaintConsole.CYAN));
        while (true){
            consol.println(PaintConsole.paint("Введите координату Х: ", PaintConsole.GREEN));
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
            consol.println(PaintConsole.paint("Введите координату Y: ", PaintConsole.GREEN));
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
