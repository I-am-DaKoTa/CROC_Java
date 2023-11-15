package ArturKuznetsov.lab6.task10;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> comments = new ArrayList<>();
        comments.add("Улица. Фонарь. Аптека.");
        comments.add("Как же достал этот спам и реклама.");
        comments.add("В русском языке есть дилемма: поставить тире или поставить двоеточие");
        comments.add("Кто-то сказал выходной?\nПоскорее бы выходной :(");
        comments.add("Длинное и \"осмысленное\"...\n\n\n\n\n\n...сообщение");

        Set<String> blackList = Set.of("спам", "реклама", "выходной");

        Predicate<String> predicate = new BlackListFilter().createPredicate(blackList);

        Collection<String> filteredComments = new BlackListFilter().filterComments(comments, predicate);

        System.out.println("Filtered Comments:");
        for (String comment : filteredComments) {
            System.out.println(comment);
        }
    }
}
