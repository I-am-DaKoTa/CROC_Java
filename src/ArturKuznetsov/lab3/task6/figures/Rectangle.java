package ArturKuznetsov.lab3.task6.figures;

import ArturKuznetsov.lab3.task6.exceptions.IncorrectCoordinatesException;

public class Rectangle extends Figure {
    private int bottomLeftX, bottomLeftY, topRightX, topRightY;

    public Rectangle(int bottomLeftX, int bottomLeftY, int topRightX, int topRightY) throws IncorrectCoordinatesException {
        if (bottomLeftX >= topRightX || bottomLeftY >= topRightY){
            throw new IncorrectCoordinatesException("Координаты левого нижнего угла не могут быть больше или равны координатам правого нижнего угла");
        }
        this.bottomLeftX = bottomLeftX;
        this.bottomLeftY = bottomLeftY;
        this.topRightX = topRightX;
        this.topRightY = topRightY;
    }

    @Override
    public boolean containsPoint(int x, int y) {
        return (bottomLeftX <= x) && (x <= topRightX) && (bottomLeftY <= y) && (y <= topRightY);
    }

    @Override
    public void move(int dx, int dy) {
        bottomLeftX += dx;
        bottomLeftY += dy;
        topRightX += dx;
        topRightY += dy;
    }

    @Override
    public String toString() {
        return String.format("Rectangle (%d, %d), (%d, %d): ", getBottomLeftX(), getBottomLeftY(), getTopRightX(), getTopRightY());
    }

    public int getBottomLeftX() {
        return bottomLeftX;
    }

    public int getBottomLeftY() {
        return bottomLeftY;
    }

    public int getTopRightX() {
        return topRightX;
    }


    public int getTopRightY() {
        return topRightY;
    }
}
