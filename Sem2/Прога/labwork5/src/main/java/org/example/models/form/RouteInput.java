package org.example.models.form;

import org.example.commandLine.*;
import org.example.managers.ExecuteSpace;
import org.example.models.Coordinates;
import org.example.models.LocationFrom;
import org.example.models.LocationTo;
import org.example.models.Route;

/**
 * Форма пользовательского ввода для класса Route
 */
public class RouteInput extends Form<Route> {
    private final Printable consol;
    private final UserInput scaner;

    public RouteInput(Printable consol){
        this.consol =(Console.isFileMode())
                ? new BlankConsole()
                : consol;
        this.scaner = (Console.isFileMode())
                ? new ExecuteSpace()
                : new ConsoleInput();
    }

    private String  userInputName(){
        while (true){
            consol.println(ConsoleColor.toColor("Введите название маршрута",ConsoleColor.GREEN));
            String name = scaner.nextLine().trim();
            if (name.isEmpty()) {
                consol.printError("Эта строка не может быть пустой");
            }
            else {
                return name;
            }
        }
    }
    private Long userInputDistance(){
        while (true){
            consol.println(ConsoleColor.toColor("Введите значение дистанции между ними", ConsoleColor.CYAN));
            String userInputt = scaner.nextLine().trim();
            try {
                if (Long.parseLong(userInputt) > 1){
                    return Long.parseLong(userInputt);
                }
                else {
                    consol.printError("Значение поля долно быть больше 1");
                }
            } catch (NumberFormatException exception){
                consol.printError("Значение этого поля должно быть типа Long");
            }
        }
    }
    private Coordinates userInputCoordinat(){
        return new CoordinatesInput(consol).create();
    }
    private LocationFrom userInputLocationFrom(){
        return new LocationFromInput(consol).create();
    }
    private LocationTo userInputLocationTo(){
        return new LocationToInput(consol).create();
    }

    /**
     * Сконструировать новый элемент класса {@link Route}
     * @return объект класса {@link Route}
     */
    @Override
    public Route create(){
        return new Route(userInputName(),
                userInputCoordinat(),
                userInputLocationFrom(),
                userInputLocationTo(),
                userInputDistance()
        );
    }
}
