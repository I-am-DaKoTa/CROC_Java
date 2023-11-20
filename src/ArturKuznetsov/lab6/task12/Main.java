package ArturKuznetsov.lab6.task12;

import java.util.Arrays;
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

        Function<Integer, Integer> alreadyMaxNumber = Function.identity();

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

        int testValue1 = 56932175;
        var result1Func = TernaryOperator.run(isMaxPossible, alreadyMaxNumber, makeMaxNumber);
        int result1 = result1Func.apply(testValue1);
        System.out.println(result1); // 97655321

        Predicate<String> isSorted = str -> {
            char[] chars = str.toCharArray();
            char[] sortedChars = Arrays.copyOf(chars, chars.length);
            Arrays.sort(sortedChars);
            return Arrays.equals(chars, sortedChars);
        };

        Function<String, String> alreadySorted = Function.identity();

        Function<String, String> sortString = str -> {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return new String(chars).replaceAll("[\\s\\p{P}]", "");
        };

        String testValue2 = "hello world!";
        var result2Func = TernaryOperator.run(isSorted, alreadySorted, sortString);
        String result2 = result2Func.apply(testValue2);
        System.out.println(result2); // dehllloorw
    }
}
