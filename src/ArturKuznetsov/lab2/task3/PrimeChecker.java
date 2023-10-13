package ArturKuznetsov.lab2.task3;

import static java.lang.Math.sqrt;

public class PrimeChecker {
    public boolean IsPrime(long num) {
        if (num > 1) {
            for (long i = 2; i <= sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
