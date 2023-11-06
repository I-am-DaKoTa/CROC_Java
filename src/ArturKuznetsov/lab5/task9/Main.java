package ArturKuznetsov.lab5.task9;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        BlackListFilter blackListFilter = new BlackListFilter();

        List<String> comments = new ArrayList<>();
        comments.add("Улица. Фонарь. Аптека.");
        comments.add(null);
        comments.add("Как же достал этот спам и реклама.");
        comments.add("В русском языке есть дилемма: поставить тире или поставить двоеточие");
        comments.add("Кто-то сказал выходной?\nПоскорее бы выходной :(");
        comments.add("Длинное и \"осмысленное\"...\n\n\n\n\n\n...сообщение");

        Set<String> blackList = Set.of("спам", "реклама", "выходной");

        System.out.println("Исходные комментарии:");
        for (String comment : comments) {
            System.out.println(comment);
        }

        blackListFilter.filterComments(comments, blackList);

        System.out.println("Комментарии после фильтрации:");
        for (String comment : comments) {
            System.out.println(comment);
        }
    }
}
