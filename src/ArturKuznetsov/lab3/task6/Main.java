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

        AnnotatedImage image = new AnnotatedImage("example", annotation1, annotation2);

        int x = 100;
        int y = 100;
        Annotation foundByPoint = image.findByPoint(x, y);
        System.out.println(foundByPoint);

        String labelToFind = "Car";
        Annotation foundByLabel = image.findByLabel(labelToFind);
        System.out.println(foundByLabel);
    }
}
