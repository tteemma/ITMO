import java.util.Random;
import java.util.stream.DoubleStream;

public class ScanEx extends Exception{
    public ScanEx(String d){
        Random random = new Random();
        DoubleStream e = random.doubles();
    }
}
