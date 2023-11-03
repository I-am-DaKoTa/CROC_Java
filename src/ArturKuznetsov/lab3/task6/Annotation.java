package ArturKuznetsov.lab3.task6;

import ArturKuznetsov.lab3.task6.figures.Figure;

public class Annotation {
    private final Figure figure;
    private final String signature;

    public Annotation(Figure figure, String signature) {
        this.figure = figure;
        this.signature = signature;
    }

    @Override
    public String toString() {
        return figure.toString() + getSignature();
    }

    public Figure getFigure() {
        return figure;
    }

    public String getSignature() {
        return signature;
    }
}
