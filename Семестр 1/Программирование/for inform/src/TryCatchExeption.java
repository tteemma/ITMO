import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryCatchExeption {
    public static void main(String[] args) {
        try {
            ReadFile();
        } catch (FileNotFoundException e) {
            System.out.println(31);
        }
    }
    public static void ReadFile() throws FileNotFoundException{
        File file = new File("Текс3товый документ.txt");
        Scanner scanner = new Scanner(file);
    }
}