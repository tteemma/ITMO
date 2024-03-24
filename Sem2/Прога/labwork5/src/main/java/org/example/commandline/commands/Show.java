package org.example.commandline.commands;

import org.example.commandline.PaintConsole;
import org.example.commandline.Printable;
import org.example.managers.CollectionManager;
import org.example.exeptions.IllegalArgument;

public class Show extends Command{
    private final Printable consol;
    private final CollectionManager collectionManager;
    /**
     * Команда 'show'
     *  Выводит в стандартный поток вывода все элементы коллекции в строковом представлении
     */
    public Show(Printable consol, CollectionManager collectionManager){
        super("show",": вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.consol = consol;
        this.collectionManager = collectionManager;
    }
    /**
     * Исполнить команду
     * @param args аргументы команды
     * @throws IllegalArgument ошибка говорящая пользователю, что аргументы команды неверные
     */
//    @Override
//    public void execute(String args) throws IllegalArgument {
//        if (!args.isBlank()) throw new IllegalArgument();
//        Collection<Route> collection = collectionManager.getCollection();
//        if (collection == null || collection.isEmpty()){
//            //consol.printError("Коллекция пустая");
//            consol.println(ConsoleColor.toColor("Коллекция пустая", ConsoleColor.PINK));
//            return;
//        }
//        consol.println(collection.toString());
//    }
    @Override
    public void execute(String args) throws IllegalArgument{
        if (!args.isBlank()) throw new IllegalArgument();
        var collection = collectionManager.getCollection();
        if (collection == null || collection.isEmpty()){
            consol.println(PaintConsole.paint("Коллекция пустая", PaintConsole.PINK));
        }else {
            collection.forEach(System.out::println);
        }
    }
}
