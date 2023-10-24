package ArturKuznetsov.lab3.task6;

import ArturKuznetsov.lab3.task6.figures.Circle;
import ArturKuznetsov.lab3.task6.figures.Figure;
import ArturKuznetsov.lab3.task6.figures.Rectangle;

public class Annotation {
    private final Figure figure;
    private final String signature;

    public Annotation(Figure figure, String signature) {
        this.figure = figure;
        this.signature = signature;
    }

    @Override
    public String toString() {
        if (figure instanceof Circle circle) {
            return String.format("Circle (%d, %d), %d: %s", circle.getCenterX(), circle.getCenterY(), circle.getRadius(), signature);
        } else if (figure instanceof Rectangle rectangle) {
            return String.format("Rectangle (%d, %d), (%d, %d): %s", rectangle.getBottomLeftX(), rectangle.getBottomLeftY(), rectangle.getTopRightX(), rectangle.getTopRightY(), signature);
        } else {
            return "Введена неизвестная фигура";
        }
    }

    public Figure getFigure() {
        return figure;
    }

    public String getSignature() {
        return signature;
    }
}
