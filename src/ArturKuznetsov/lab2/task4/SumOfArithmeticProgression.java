package ArturKuznetsov.lab2.task4;

import java.util.Scanner;
import static java.lang.Math.abs;

public class SumOfArithmeticProgression {
    public static void main(String[] args) throws InvalidNumberInputException {
        int initialElement = 0;
        int progressionDifference = 0;
        int numberOfTerms = 0;

        if (!(args.length == 3)) {
            throw new InvalidNumberInputException("The amount of numbers should be three");
        }

        for (int i = 0; i < args.length; i ++) {
            if (!args[i].matches("-?\\d+")) {
                throw new InvalidNumberInputException("Invalid value: " + args[i] + ". " +
                        "The input data should be digits");
            }
            int number = Integer.parseInt(args[i]);

            if (!(abs(number) <= 10000)) {
                throw new InvalidNumberInputException("Invalid value: " + args[i] + ". " +
                        "The input value should be from -10000 to 10000");
            }

            switch (i) {
                case 0 -> initialElement = number;
                case 1 -> progressionDifference = number;
                case 2 -> numberOfTerms = number;
            }
        }

        long sumOfProgression = 0;
        for (long i = 0; i < abs(numberOfTerms); i++) {
            sumOfProgression += initialElement + i * progressionDifference;
        }

        System.out.printf("Sum: %d\n", sumOfProgression);
    }
}
