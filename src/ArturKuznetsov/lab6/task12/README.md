## Задание 12 | Тернарный оператор
### Условие:
Напишите параметризованный статический метод, который бы реализовывал логику тернарного оператора на основе полученных предиката и двух функций.

В main приведите несколько примеров работы вышеуказанного метода.
### Решение
```java
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

        int testValue1 = 56932175;
        var result1 = TernaryOperator.run(isMaxPossible, alreadyMaxNumber, makeMaxNumber, testValue1);
        System.out.println(result1); // 97655321

        Predicate<String> isSorted = str -> {
            char[] chars = str.toCharArray();
            char[] sortedChars = Arrays.copyOf(chars, chars.length);
            Arrays.sort(sortedChars);
            return Arrays.equals(chars, sortedChars);
        };

        Function<String, String> alreadySorted = str -> {
            System.out.println(str);
            return str;
        };

        Function<String, String> sortString = str -> {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return new String(chars).replaceAll("[\\s\\p{P}]", "");
        };
        String testValue2 = "hello world!";
        String result2 = TernaryOperator.run(isSorted, alreadySorted, sortString, testValue2);
        System.out.println(result2); // dehllloorw
    }
}
```

