import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryCatchExeption {
    public static void main(String[] args) {
        try {
            ReadFile();
        } catch (FileNotFoundException e) {
            e.equals(e);
        }
    }
    public static void ReadFile() throws FileNotFoundException{
        File file = new File("Текс3товый документ.txt");
        Scanner scanner = new Scanner(file);
    }
}