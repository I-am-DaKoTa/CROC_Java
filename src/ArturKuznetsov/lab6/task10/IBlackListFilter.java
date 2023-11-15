package ArturKuznetsov.lab6.task10;

import ArturKuznetsov.lab5.task9.InvalidTextException;

import java.util.*;
import java.util.function.Predicate;

public interface IBlackListFilter {
    default <T> Collection<T> filterComments(Iterable<T> comments, Predicate<T> blackList) {
        if (comments == null) {
            throw new InvalidTextException("Список комментариев не может быть равным null");
        }
        if (blackList == null) {
            throw new InvalidTextException("Чёрный список не может быть равным null");
        }

        Collection<T> filteredComments = new ArrayList<>();

        for (T comment : comments) {
            if (!(comment == null) && blackList.test(comment)) {
                filteredComments.add(comment);
            }
        }

        return filteredComments;
    }
}