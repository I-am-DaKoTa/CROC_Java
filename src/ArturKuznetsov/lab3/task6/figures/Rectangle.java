package ArturKuznetsov.lab3.task6.figures;

import ArturKuznetsov.lab3.task6.exceptions.IncorrectCoordinatesException;

public class Rectangle extends Figure {
    private int bottomLeftX;
    private int bottomLeftY;
    private int topRightX;
    private int topRightY;

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
    public void move(int dx, int dy) {
        bottomLeftX += dx;
        bottomLeftY += dy;
        topRightX += dx;
        topRightY += dy;
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
