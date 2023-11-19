package ArturKuznetsov.lab6.task12;

import java.util.function.Function;
import java.util.function.Predicate;

public class TernaryOperator {
    public static <T, R> R run(Predicate<T> predicate, Function<T, R> trueFunction, Function<T, R> falseFunction, T value) {
        return predicate.test(value) ? trueFunction.apply(value) : falseFunction.apply(value);
    }

}