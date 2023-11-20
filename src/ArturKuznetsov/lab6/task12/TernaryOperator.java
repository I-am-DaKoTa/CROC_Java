package ArturKuznetsov.lab6.task12;

import java.util.function.Function;
import java.util.function.Predicate;

public class TernaryOperator {
    public static <T, R> Function<T, R> run(Predicate<T> predicate, Function<T, R> trueFunction, Function<T, R> falseFunction) {
        return value -> predicate.test(value) ? trueFunction.apply(value) : falseFunction.apply(value);
    }

}