package ArturKuznetsov.lab6.task12;

import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> isMaxPossible = value -> {
            String digits = String.valueOf(value);
            char[] arr = digits.toCharArray();
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    return false;
                }
            }
            return true;
        };

        Function<Integer, Integer> alreadyMaxNumber = value -> value;

        Function<Integer, Integer> makeMaxNumber = value -> {
            String digits = String.valueOf(value);
            char[] arr = digits.toCharArray();
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] < arr[j]) {
                        char temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            return Integer.parseInt(new String(arr));
        };

        int testValue = 56932175;
        var result = TernaryOperator.run(isMaxPossible, alreadyMaxNumber, makeMaxNumber, testValue);
        System.out.println(result);
    }
}