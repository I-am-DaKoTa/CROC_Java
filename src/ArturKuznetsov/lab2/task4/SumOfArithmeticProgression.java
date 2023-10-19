package ArturKuznetsov.lab2.task4;

import java.util.Scanner;
import static java.lang.Math.abs;

public class SumOfArithmeticProgression {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите числа: ");
        int initialElement = in.nextInt();
        int progressionDifference = in.nextInt();
        int numberOfTerms = in.nextInt();
        in.close();

        long sumOfProgression = 0;
        for (long i = 0; i < abs(numberOfTerms); i++) {
            sumOfProgression += initialElement + i * progressionDifference;
        }
        System.out.printf("Сумма: %d\n", sumOfProgression);
    }
}
