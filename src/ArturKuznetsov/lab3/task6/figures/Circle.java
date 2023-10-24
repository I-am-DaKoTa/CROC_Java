package ArturKuznetsov.lab3.task6.figures;

import ArturKuznetsov.lab3.task6.exceptions.InvalidValueException;

public class Circle extends Figure {
    private int centerX;
    private int centerY;
    private final int radius;

    public Circle(int centerX, int centerY, int radius) throws InvalidValueException {
        if (radius <= 0) {
            throw new InvalidValueException("Радиус не может быть отрицательным или равным нулю");
        }
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    @Override
    public void move(int dx, int dy) {
        centerX += dx;
        centerY += dy;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getRadius() {
        return radius;
    }
}
