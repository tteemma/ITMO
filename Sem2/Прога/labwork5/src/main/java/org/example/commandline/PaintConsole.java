package org.example.commandline;

public enum PaintConsole {
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    RESET("\u001B[0m"),
    PINK("\u001b[38;5;199m");

    private final String title;

    PaintConsole(String title){
        this.title = title;
    }
    /**
     * Метод раскрашивания текста
     * @param s строка которую нужно покрасить
     * @param color значение цвета
     * @return цветная строка для вывода в консоль
     */
    public static String paint(String s, PaintConsole color){
        return color + s + PaintConsole.RESET;
    }

    public String getTitle(){
        return title;
    }
    @Override
    public String toString() {
        return title;
    }
}
