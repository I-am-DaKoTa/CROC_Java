package ArturKuznetsov.lab8.task15.exceptions;

public class InvalidDataException extends RuntimeException {
    private final String line;

    public InvalidDataException(String line) {
        super(String.format("""
                        Недопустимый формат данных в строке: %s
                        Требуемый формат: Порядковый номер клиента - integer
                        Фамилия клиента - string
                        Имя клиента - string
                        Номер телефона клиента - string в формате +79995554433
                        Номер медицинской карты питомца - integer
                        Имя питомца - string
                        Возраст питомца - integer""",
                line));
        this.line = line;
    }

    public String getLine() {
        return line;
    }
}
