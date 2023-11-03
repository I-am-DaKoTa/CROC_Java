package ArturKuznetsov.lab3.task6;

import ArturKuznetsov.lab3.task6.exceptions.AnnotationNotFoundException;

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

    public Annotation findByPoint(int x, int y) {
        try {
            for (Annotation annotation : annotations) {
                if (annotation.getFigure().containsPoint(x, y)) {
                    return annotation;
                }
            }
            throw new AnnotationNotFoundException("Аннотация не была найдена");
        } catch (AnnotationNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public Annotation findByLabel(String label) {
        try {
            for (Annotation annotation : annotations) {
                if (annotation.getSignature().contains(label)) {
                    return annotation;
                }
            }
            throw new AnnotationNotFoundException("Аннотация не была найдена");
        }
        catch (AnnotationNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }


}