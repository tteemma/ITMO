package org.example.models.form;

import org.example.commandline.*;
import org.example.managers.ExecuteSpace;
import org.example.models.LocationFrom;

/**
 * Форма пользовательского ввода для локации
 */
public class LocationFromInput extends UserInputForm<LocationFrom> { //Доработать при работе с ФАЙЛОМ
    private final UserInput scaner;
    private final Printable consol;

    public LocationFromInput(Printable consol){
        this.consol =(Console.isFileMode())
                ? new ExecuteConsole()
                : consol;
        this.scaner = (Console.isFileMode())
                ? new ExecuteSpace()
                : new ConsoleInput();
    }

    private double userInputX(){
        while (true){
            consol.println(PaintConsole.paint("Введите параметры локации откуда вы хотите пойти", PaintConsole.CYAN));
            consol.println(PaintConsole.paint("Введите координату Х", PaintConsole.GREEN));
            String userInputt =  scaner.nextLine().trim();
            try {
                return Double.parseDouble(userInputt);
            } catch (NumberFormatException exception){
                consol.printError("Неверный тип переменной, переменная должна быть типа double");
            }
        }
    }
    private double userInputY(){
        while (true){
            consol.println(PaintConsole.paint("Введите координату Y", PaintConsole.GREEN));
            String userInputt = scaner.nextLine().trim();
            try {
                return Double.parseDouble(userInputt);
            } catch (NumberFormatException exception){
                consol.printError("Неверный тип переменной, переменная должна быть типа double");
            }
        }
    }
    private String userInputName() {
        while (true) {
            consol.println(PaintConsole.paint("Введите название локации", PaintConsole.GREEN));
            String userInputt = scaner.nextLine().trim();
            if (userInputt.isEmpty()) {
                consol.printError("Название не может быть пустым, попробуйте заново");
            } else {
                return userInputt;
            }
        }
    }
    /**
     * Сконструировать новый элемент класса {@link LocationFrom}
     */

    @Override
    public LocationFrom create(){
        return new LocationFrom(userInputX(),userInputY(),userInputName());
    }
}
