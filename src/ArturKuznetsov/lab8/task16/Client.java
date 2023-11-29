package ArturKuznetsov.lab8.task16;

public class Client {
    private final Integer id;
    private String name;
    private String surname;
    private String phoneNumber;

    public Client(Integer id, String surname, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return String.format("Клиент: %s %s\nId клиента: %d\nНомер телефона: %s", name, surname, id, phoneNumber);
    }
}
