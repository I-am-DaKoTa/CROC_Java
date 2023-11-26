## Задание 13 | Аукцион
### Условие:
Вы работаете над приложением для проведения аукциона. Начать разработку решили с самого важного - класса лота аукциона. В ходе анализа предметной области вы пришли к выводу, что каждый лот должен иметь 3 параметра: текущую стоимость, имя пользователя, предложившего ее, и время окончания торгов по этому лоту.

Также класс должен предоставлять методы
- метод “ставки”, который обновляет текущую стоимость лота и сохраняет предложившего ее пользователя, если торги по лоту еще ведутся по времени и предложенная цена выше текущей.
- метод получения размера текущей ставки
- метод получения имени пользователя победителя.

Делать ставки на лот одновременно могут сразу несколько пользователей.

Реализуйте класс по описанию так, чтобы одновременное участие в ставках большого количества пользователей не приводило к ошибкам в проведении аукциона (то есть, потокобезопасно).

Входные данные для старта аукциона лежат в двух файлах. Первый файл (lot.txt) содержит информацию о лоте: название  и цену. Пример содержимого файла:

```
“Поцелуй”, Густав Климт
100000
```

Второй файл (participants.txt) содержит имена участников аукциона, каждое в новой строке. Пример содержимого файла:

```
Евгения Штайнер
Карл Витгенштейн
Серена Ледерер
Адель Блох-Бауэр
Отто Примавези
Евгении Примавези
Виктор Цукеркандль
Антон Лёв
Густав Учицки
Аранка Мунк
Адель Блох-Бауэр
Август Ледерер
```

Для демонстрации напишите main метод, где запустите ваше приложение с 10 (как минимум) участниками, каждый из которых сделает до 100 попыток перебить текущую ставку, и выиграть лот.
Подсказки:
Не забывайте про принцип единственной ответственности. Проектируя класс, продумайте, за что он должен отвечать, какие задачи выполнять.


### Решение

```java
package ArturKuznetsov.lab7.task13;

import ArturKuznetsov.lab7.task13.auction.AuctionFileReader;
import ArturKuznetsov.lab7.task13.auction.AuctionLot;
import ArturKuznetsov.lab7.task13.auction.AuctionParticipant;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String lotFilePath = "src/ArturKuznetsov/lab7/task13/textFiles/lot.txt";
        ArrayList<AuctionLot> lots = AuctionFileReader.readLotFile(lotFilePath);
        System.out.println("Лоты аукциона:");
        for (AuctionLot lot : lots) {
            System.out.println("Лот: " + lot.getName() + ", Цена: " + lot.getStartedPrice());
        }

        String participantsFilePath = "src/ArturKuznetsov/lab7/task13/textFiles/participants.txt";
        ArrayList<String> participantsName = AuctionFileReader.readParticipantFile(participantsFilePath);
        System.out.println("\nУчастники аукциона:");
        ArrayList<AuctionParticipant> participants = new ArrayList<>();
        for (String participantName : participantsName) {
            participants.add(new AuctionParticipant(lots.get(0), participantName));
            System.out.println(participantName);
        }

        System.out.println("\n=====================================================================================\n");

        ArrayList<Thread> threads = new ArrayList<>();
        for (AuctionParticipant participant : participants) {
            Thread thread = new Thread(participant);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        String winnerName = lots.get(0).getWinnerName();
        System.out.println(winnerName);
    }
}
```