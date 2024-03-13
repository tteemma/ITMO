package org.example.managers;

import org.example.models.Route;
import org.example.exeptions.*;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

/**
 * Класс организующий работу с коллекцией
 */
public class CollectionManager {

    private final TreeSet<Route> collection = new TreeSet<Route>();

    /**
     * Дата создания коллекции
     */
    private LocalDateTime lastInitTime;
    private final LocalDateTime initTime;
    /**
     * Дата последнего сохранения коллекции
     */
    private LocalDateTime lastSaveTime;
    public CollectionManager(){
        this.initTime = LocalDateTime.now();
        this.lastInitTime = null;
    }
    public static String formatTime(LocalDateTime localDateTime) {
        if (localDateTime == null) return null;
//        if (localDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
//                .equals(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")))) {
//            return localDateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
//        }
        return localDateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }
    public TreeSet<Route> getCollection(){
        return collection;
    }
    public String reversCollections(TreeSet<Route> revers){
        return String.valueOf(revers.descendingSet());
    }

    // Вспомогательные методы для будущий команд

    public void clear(){
        this.collection.clear();
        lastInitTime = LocalDateTime.now();
    }
    /**
     * @param id ID элемента.
     * @return Элемент по его ID или null, если не найдено.
     */
    public Route getById(int id){
        for (Route elem: collection){
            if (elem.getId() == id){
                return elem;
            }
        }
        return null;
    }
    /**
     * @param id ID элемента.
     * @return Проверяет, существует ли элемент с таким ID.
     */
    public boolean checkExist(int id){
        return collection.stream().anyMatch((x) -> x.getId() == id);
    }
    public Route getLast(){
        return collection.last();
    }
    public void removeElement(Route el){
        this.lastSaveTime = LocalDateTime.now();
        collection.remove(el);
    }
    public void removeElements(Collection<Route> els){
        this.lastSaveTime = LocalDateTime.now();
        this.collection.removeAll(els);
    }
    public void addElement(Route el) throws InvalidForm{
        this.lastInitTime = LocalDateTime.now();
        collection.add(el);
    }
    public void addElements(Collection<Route> els) throws InvalidForm{
        lastInitTime = LocalDateTime.now();
        if (els == null){
            return;
        }
        collection.addAll(els);
    }
    /**
     * Изменить элемент коллекции с таким id
     * @param id id объекта
     * @param newElement новый элемент
     * @throws InvalidForm Нет элемента с таким id
     */
    public void editById(int id, Route newElement) throws InvalidForm {
        Route pastElem = this.getById(id);
        this.removeElement(pastElem);
        newElement.setId(id);
        this.addElement(newElement);
        Route.updateId(this.getCollection());
        this.lastSaveTime =LocalDateTime.now();
    }
    public String getLastInitTime(){
        return formatTime(lastInitTime);
    }
    public String getLastSaveTime(){
        return formatTime(lastSaveTime);
    }
    public LocalDateTime getInitTimeInDate(){
        return initTime;
    }
    public LocalDateTime getLastSaveTimeInDate() {
        return lastSaveTime;
    }
    public void setLastSaveTime(LocalDateTime lastSaveTime){
        this.lastSaveTime = lastSaveTime;
    }
    public void setLastInitTime(LocalDateTime lastInitTime){
        this.lastInitTime = lastInitTime;
    }

    public String getCollectionType(){
        return collection.getClass().getName();
    }
    public int getCollectionSize(){
        return collection.size();
    }
    @Override
    public String toString() {
        if (collection.isEmpty()) return "Колекция пустая";

        var last = getLast();

        StringBuilder info = new StringBuilder();
        for (Route route: collection){
            info.append(route);
            if (route != last) return "\n\n";
        }
        return info.toString();
    }
}
