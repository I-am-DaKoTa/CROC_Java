package ArturKuznetsov.lab3.task6;

import ArturKuznetsov.lab3.task6.exceptions.AnnotationNotFoundException;
import ArturKuznetsov.lab3.task6.figures.Circle;
import ArturKuznetsov.lab3.task6.figures.Figure;
import ArturKuznetsov.lab3.task6.figures.Rectangle;

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

    public Annotation findByPoint(int x, int y) throws AnnotationNotFoundException {
        for (Annotation annotation : annotations) {
            Figure figure = annotation.getFigure();
            if (figure instanceof Circle circle) {
                if (circle.getCenterX() == x && circle.getCenterY() == y) {
                    return annotation;
                }
            } else if (figure instanceof Rectangle rectangle) {
                if ((rectangle.getBottomLeftX() == x && rectangle.getBottomLeftY() == y) || (rectangle.getTopRightX() == x && rectangle.getTopRightY() == y)) {
                    return annotation;
                }
            }
        }
        throw new AnnotationNotFoundException("Аннотация не была найдена");
    }

    public Annotation findByLabel(String label) throws AnnotationNotFoundException {
        for (Annotation annotation : annotations) {
            if (annotation.getSignature().contains(label)) {
                return annotation;
            }
        }
        throw new AnnotationNotFoundException("Аннотация не была найдена");
    }


}