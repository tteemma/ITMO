package org.example.models.form;

import org.example.commandLine.*;
import org.example.managers.ExecuteSpace;
import org.example.models.LocationFrom;

/**
 * Форма пользовательского ввода для локации
 */
public class LocationFromInput extends Form<LocationFrom> { //Доработать при работе с ФАЙЛОМ
    private final UserInput scaner;
    private final Printable consol;

    public LocationFromInput(Printable consol){
        this.consol =(Console.isFileMode())
                ? new BlankConsole()
                : consol;
        this.scaner = (Console.isFileMode())
                ? new ExecuteSpace()
                : new ConsoleInput();
    }

    private double userInputX(){
        while (true){
            consol.println(ConsoleColor.toColor("Введите параметры локации откуда вы хотите пойти",ConsoleColor.CYAN));
            consol.println(ConsoleColor.toColor("Введите координату Х", ConsoleColor.GREEN));
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
            consol.println(ConsoleColor.toColor("Введите координату Y", ConsoleColor.GREEN));
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
            consol.println(ConsoleColor.toColor("Введите название локации", ConsoleColor.GREEN));
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
     * @return объект класса {@link models.LocationFrom}
     */

    @Override
    public LocationFrom create(){
        return new LocationFrom(userInputX(),userInputY(),userInputName());
    }
}
