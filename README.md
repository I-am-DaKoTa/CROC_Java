# Курс "Введение в язык Java и платформу разработки" от КРОК
## Задание 1 | Введение
### Условие:
Начнём с простой разминки
Реализуйте программу, которая бы выводила на экран текст ‘Hello, Java ^^’
### [Решение](src/ArturKuznetsov/lab1/task1)
## Задание 2 | FizzBuzz
### Условие:
Напишите короткую программу, которая выводит на экран числа от 1 до 100, каждое в новой строке.
Вместо каждого числа, которое делится на 3, выводите ‘Fizz’.
Вместо каждого числа, которое делится на 5, выводите ‘Buzz’.
Вместо каждого числа, которое делится и на 3, и на 5, выводите ‘FizzBuzz’.
### [Решение](src/ArturKuznetsov/lab1/task2)
## Задание 3 | Простые числа
### Условие:
Напишите программу, которая для заданного числа от 2 до 10^10 (10 000 000 000) проверит является ли это число простым. Вывести на экран “Простое” или “Составное” число.
*  проверить является ли число - числом-близнецом
### [Решение](src/ArturKuznetsov/lab2/task3)
## Задание 4 | Сумма арифметической прогрессии
### Условие:
Написать программу, которая принимает 3 аргумента, и считает сумму арифметической прогрессии.
Аргументы: начальный элемент, разность арифметической прогрессии и кол-во членов прогрессии. Каждое число от -10 000 до +10 000
Решить с помощью использования циклов, а не формулы суммы.
### [Решение](src/ArturKuznetsov/lab2/task4)
## Задание 5 | Каталог интернет-магазина
### Условие:
Поступил заказ на написание интернет магазина для бытовых приборов.
Ваша часть задачи - реализовать классы - отвечающие за ассортимент магазина.
(Такие как холодильник (мини холодильник, с морозильной камерой или без), плита (газовая, электро, индукционная), стиралка (может быть с сушилкой), робот пылесос, и насколько фантазии хватит)

Определите набор характеристик каждого товара. Такие как цена, описание товара, габариты, мощность, время автономной работы от аккумулятора, температура морозильной камеры)

Добавьте позиции с общий массив.
Для всех элементов выведите на экран их характеристики в читаемом виде.
Определите методы для установки/получения характеристик.
Для импортных товаров реализуйте методы возвращающие наличие гарантии от производителя и страну производства.
### [Решение](src/ArturKuznetsov/lab3/task5)
## Задание 6 | Аннотирование изображений
### Условие:
Предположим, вы принимаете участие в разработке небольшого приложения по аннотированию (разметке) изображений с целью последующего использования этой разметки для обучения моделей computer vision. В этом приложении пользователь может выделять области на изображении с помощью прямоугольников и окружностей и подписывать их произвольным текстом.
Вся разметка для изображения представляется массивом `Annotation[]`.

В приложении определен класс аннотированного изображения:

```
class AnnotatedImage {

   private final String imagePath;

   private final Annotation[] annotations;

   public AnnotatedImage(String imagePath, Annotation... annotations) {
       this.imagePath = imagePath;
       this.annotations = annotations;
   }

   public String getImagePath() {
       return this.imagePath;
   }

   public Annotation[] getAnnotations() {
       return this.annotations;
   }
}
```

Определите класс `Annotation` для представления данных разметки (данные: подпись и фигура) и классы `Figure`,`Rectangle`,`Circle` для задания размеченных областей.

Прямоугольники определяются координатами левого нижнего и правого верхнего углов, а окружности - координатами центра и радиусом.

Переопределите метод `toString()` класса `Annotation` так, чтобы в результат выводилась информация о полях и вложенных объектах. Формат вывода:


Окружность:

“Circle (x0, y0), r: Подпись”

Прямоугольник:

“Rectangle (x1, y1), (x2, y2): Подпись”

Например:
```
Circle (100, 100), 10: Tree
Rectangle (100, 100), (150, 200): Car
```

Так же от пользователей пришел запрос на возможность перемещать уже размеченные области. Для поддержки это функциональности вам требуется реализовать:

1. **Выбор аннотации по координатам точки (x, y);**

В массиве аннотаций требуется найти первую, фигура которой содержит точку с заданными координатами.

```
Annotation findByPoint(int x, int y) {

// ...

}
```

2. **Выбор аннотации по шаблону подписи;**

В массиве аннотаций требуется найти первую, подпись которой содержит заданную подстроку.

```
Annotation findByLabel(String label) {

// ...

}
```

Определить, содержит ли строка заданную подстроку, можно с помощью метода contains(CharSequence s) класса String.

3. **Перемещение фигуры выбранной аннотации на смещение (dx, dy);**

В рамках этого изменения вы решили доработать классы фигур таким образом, чтобы они реализовывали интерфейс

```
public interface Movable {

void move(int dx, int dy);

}
```

Разработайте классы и реализуйте соответствующие методы.
### [Решение](src/ArturKuznetsov/lab3/task6)
## Контакты

- Имя и Фамилия: Артур Кузнецов
- Telegram: [@i_am_dak0ta](https://t.me/i_am_dak0ta)
