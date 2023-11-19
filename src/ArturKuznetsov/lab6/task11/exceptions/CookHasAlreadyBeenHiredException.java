package ArturKuznetsov.lab6.task11.exceptions;

public class CookHasAlreadyBeenHiredException extends RuntimeException {
    private final String cook;

    public CookHasAlreadyBeenHiredException(String cook) {
        super(String.format("%s уже нанят", cook));
        this.cook = cook;
    }

    public String getNameData() {
        return cook;
    }
}
