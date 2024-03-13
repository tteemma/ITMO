import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите 7-битное сообщение: ");
        String message = scanner.nextLine();

        // Проверяем, что сообщение состоит из 7 битов
        if (message.length() != 7) {
            System.out.println("Ошибка: сообщение должно состоять из 7 битов.");
        }

        // Разделим число на отдельные цифры
        for (int i = 0; i < message.length(); i ++){
            int j = Character.digit(message.charAt(i),10);
            System.out.print(j + " ");
        }
    }
}