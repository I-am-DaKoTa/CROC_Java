package ArturKuznetsov.lab3.task6;

import ArturKuznetsov.lab3.task6.exceptions.AnnotationNotFoundException;
import ArturKuznetsov.lab3.task6.exceptions.IncorrectCoordinatesException;
import ArturKuznetsov.lab3.task6.exceptions.InvalidValueException;
import ArturKuznetsov.lab3.task6.figures.Circle;
import ArturKuznetsov.lab3.task6.figures.Rectangle;

public class Main {
    public static void main(String[] args) throws InvalidValueException, IncorrectCoordinatesException, AnnotationNotFoundException {
        Circle circle = new Circle(100, 100, 10);
        Rectangle rectangle = new Rectangle(100, 100, 150, 200);


        Annotation annotation1 = new Annotation(circle, "Tree");
        Annotation annotation2 = new Annotation(rectangle, "Car");

        System.out.println("Фигруры и аннотации к ним:");
        System.out.println(annotation1);
        System.out.println(annotation2);
        System.out.println();

        AnnotatedImage image = new AnnotatedImage("example", annotation1, annotation2);

        int x = 100, y = 100;
        int dx = 50, dy = 50;

        Annotation foundByPointBeforeMoving = image.findByPoint(x, y);
        System.out.printf("Аннотация по координатам точки (%d, %d):\n", x, y);
        System.out.println(foundByPointBeforeMoving);
        System.out.println();

        System.out.printf("Расположение фигур до перемещения на (%d, %d):\n", dx, dy);
        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println();

        circle.move(dx, dy);
        rectangle.move(dx, dy);

        System.out.printf("Расположение фигур после перемещения на (%d, %d):\n", dx, dy);
        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println();

        System.out.printf("Аннотация по координатам точки (%d, %d):\n", x, y);
        Annotation foundByPointAfterMoving = image.findByPoint(x, y);
        System.out.println(foundByPointAfterMoving);
        System.out.println();

        String labelToFind = "Car";
        Annotation foundByLabel = image.findByLabel(labelToFind);

        System.out.printf("Аннотация по шаблону подписи %s:\n", labelToFind);
        System.out.println(foundByLabel);
        System.out.println();
    }
}
