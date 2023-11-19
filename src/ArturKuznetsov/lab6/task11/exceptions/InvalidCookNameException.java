package ArturKuznetsov.lab6.task11.exceptions;

public class InvalidCookNameException extends RuntimeException {
    private final String cookName;

    public InvalidCookNameException(String cookName) {
        super(String.format("Невероное имя повара %s. Имя не может быть пустым или null",
                cookName));
        this.cookName = cookName;
    }

    public String getNameData() {
        return cookName;
    }
}
