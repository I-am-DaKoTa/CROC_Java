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
    public boolean containsPoint(int x, int y) {
        return Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2) <= Math.pow(radius, 2);
    }

    @Override
    public void move(int dx, int dy) {
        centerX += dx;
        centerY += dy;
    }

    @Override
    public String toString() {
        return String.format("Circle (%d, %d), %d: ", getCenterX(), getCenterY(), getRadius());
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
