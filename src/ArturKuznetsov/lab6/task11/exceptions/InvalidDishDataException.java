package ArturKuznetsov.lab6.task11.exceptions;

public class InvalidDishDataException extends RuntimeException {
    private final String nameData;

    public InvalidDishDataException(String nameData) {
        super(String.format("Невероное значение оценки %s. Значение не может быть пустым или null",
                nameData));
        this.nameData = nameData;
    }

    public String getNameData() {
        return nameData;
    }
}
