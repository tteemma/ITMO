package org.example.models.form;

import org.example.commandLine.*;
import org.example.managers.ExecuteSpace;
import org.example.models.LocationTo;

/**
 * Форма пользовательского ввода для локации
 */
public class LocationToInput extends Form<LocationTo>{

    private final Printable consol;
    private final UserInput scaner;

    public LocationToInput(Printable consol){
        this.consol =(Console.isFileMode())
                ? new BlankConsole()
                : consol;
        this.scaner = (Console.isFileMode())
                ? new ExecuteSpace()
                : new ConsoleInput();
    }
    private int userInputX(){
        consol.println(ConsoleColor.toColor("Введите параметры локации куда вы хотите прийти",ConsoleColor.CYAN));
        while (true){
            consol.println(ConsoleColor.toColor("Введите координату Х", ConsoleColor.GREEN));
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
            consol.println(ConsoleColor.toColor("Введите координату Y",ConsoleColor.GREEN));
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
            consol.println(ConsoleColor.toColor("Введите название локации", ConsoleColor.GREEN));
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
