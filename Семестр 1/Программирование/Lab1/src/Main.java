import java.util.Arrays;
import java.math.MathContext;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args)
    {
        int [] evenNumber = new int[11];
        for (int i = 0; i < evenNumber.length; ++i) { evenNumber[i] = (i + 1) * 2; }
        ///System.out.println(Arrays.toString(evenNumber) + "\n");

        double [] randomCount = new double[14];
        for (int i = 0; i < randomCount.length; ++i){
            randomCount[i] = Math.random() * 31 - 15;
        }
        /*Т.к Math.random() - функция, которая лежит в интервале [0;1), то, чтобы получить числа в
            нужном диапозоне [-15;15] домножил на 31 и вычел 15*/
       // System.out.print(Arrays.toString(randomCount) + "\n");
        double resultArr[][] = new double[11][];
        double arr[][] = {{423,432},{243,432,432},{423,43}};
        for (int i = 0; i < evenNumber.length; ++i){
            double[][] doubles = new double[11][];
            for (int j = 0; j < randomCount.length; ++j) {
                if (evenNumber[i] == 4) {
                    resultArr[i][j] = Math.tan(Math.pow((1 / 4 - Math.pow(Math.E, 2) / (Math.log(Math.abs(randomCount[j])))), 2));
                } else if (evenNumber[i] == 2 | evenNumber[i] == 6 | evenNumber[i] == 8 | evenNumber[i] == 12 | evenNumber[i] == 20) {
                    resultArr[i][j] = Math.sin(Math.pow(Math.tan(randomCount[j]), Math.cbrt(randomCount[j])));
                } else {
                    resultArr[i][j] = Math.tan(Math.pow((Math.asin(1 / Math.pow(Math.E, Math.abs(randomCount[j])))) / (1 - Math.atan(0.1 * (randomCount[j] / 3) * Math.E + 1)), Math.cbrt(Math.atan((randomCount[j] / 3) * Math.E + 1))));
                }
            }
        }
        for (int i = 0; i < evenNumber.length; ++i){
            for (int j = 0; j < randomCount.length; ++j){
                System.out.printf("% 9.5f " + " ", resultArr[i][j]);
            }
            System.out.println();
        }
        int array[][] = new int[5][];
        for (int i = 0; i < array.length; i++){
            array[i] = new int[i + 1];
        }

    }

}
