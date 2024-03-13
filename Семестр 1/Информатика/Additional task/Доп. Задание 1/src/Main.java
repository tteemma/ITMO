import java.util.Scanner;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);

        long cnt1;
        int tmp = 0;
        int N = 99;
        System.out.println("Введите число в -10 сс: ");

        cnt1 = scan.nextLong();
        System.out.println();

        for (int i = N - 1; i >= 0; i --){
            tmp += (cnt1 % 10) * pow((-10), N - 1 - i);
            cnt1 /= 10;
        }
        System.out.println("Число в 10 сс: " + tmp);

    }
}