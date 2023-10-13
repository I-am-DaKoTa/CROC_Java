package ArturKuznetsov.lab2.task3;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {

        PrimeChecker prime = new PrimeChecker();

        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        long number = in.nextLong();
        in.close();

        if (prime.IsPrime(number) && prime.IsPrime(number-2)) {
            System.out.printf("Число %d - простое и является числом-близнецом для числа %d\n", number, number-2);

        } else if (prime.IsPrime(number) && prime.IsPrime(number+2)) {
            System.out.printf("Число %d - простое и является числом-близнецом для числа %d\n", number, number+2);

        } else if (prime.IsPrime(number)) {
            System.out.printf("Число %d - простое\n", number);

        } else {
            System.out.printf("Число %d - составное\n", number);

        }
    }

}
