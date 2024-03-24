package org.example.models.form;

import org.example.commandline.*;
import org.example.managers.ExecuteSpace;
import org.example.models.LocationTo;

/**
 * Форма пользовательского ввода для локации
 */
public class LocationToInput extends UserInputForm<LocationTo> {

    private final Printable consol;
    private final UserInput scaner;

    public LocationToInput(Printable consol){
        this.consol =(Console.isFileMode())
                ? new ExecuteConsole()
                : consol;
        this.scaner = (Console.isFileMode())
                ? new ExecuteSpace()
                : new ConsoleInput();
    }
    private int userInputX(){
        consol.println(PaintConsole.paint("Введите параметры локации куда вы хотите прийти", PaintConsole.CYAN));
        while (true){
            consol.println(PaintConsole.paint("Введите координату Х", PaintConsole.GREEN));
            String userInputt = scaner.nextLine().trim();
            try {
                return Integer.parseInt(userInputt);
            } catch (NumberFormatException exception){
                consol.printError("Неверный тип переменной, переменная должна быть типа int");
            }
        }
    }
    private Long userInputY(){
        while (true){
            consol.println(PaintConsole.paint("Введите координату Y", PaintConsole.GREEN));
            String userInputt = scaner.nextLine().trim();
            try {
                return Long.parseLong(userInputt);
            } catch (NumberFormatException exception){
                consol.printError("Неверный тип переменной, переменная должна быть типа Long");
            }
        }
    }

    private String userInputName(){
        while (true){
            consol.println(PaintConsole.paint("Введите название локации", PaintConsole.GREEN));
            String userInputt = scaner.nextLine().trim();
            if (userInputt.isEmpty()){
                consol.printError("Название не может быть пустым, попробуйте еще раз!");
            }
            else {
                return userInputt;
            }
        }
    }


    /**
     * Сконструировать новый элемент класса {@link LocationTo}
     * @return объект класса {@link org.example.models.LocationTo}
     */
    @Override
    public LocationTo create() {
        return new LocationTo(userInputX(),userInputY(),userInputName());
    }
}
