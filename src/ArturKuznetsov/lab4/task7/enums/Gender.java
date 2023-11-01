package ArturKuznetsov.lab4.task7.enums;

public enum Gender {
    MALE("Мужчина"),
    FEMALE("Женщина");

    private final String clientGender;

    Gender(String clientGender) {
        this.clientGender = clientGender;
    }

    public String getClientGender() {
        return clientGender;
    }
}
