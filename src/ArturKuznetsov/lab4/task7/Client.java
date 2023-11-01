package ArturKuznetsov.lab4.task7;

import ArturKuznetsov.lab4.task7.enums.Gender;
import ArturKuznetsov.lab4.task7.exceptions.InvalidCustomerData;
import ArturKuznetsov.lab4.task7.exceptions.InvalidPhoneNumberException;

import java.util.Objects;

public class Client {
    private final String phoneNumber;
    private final String lastName;
    private final String firstName;
    private final String patronymic;
    private final Gender gender;

    public Client(String phoneNumber, String lastName, String firstName, String patronymic, Gender gender) throws InvalidPhoneNumberException, InvalidCustomerData {
        this.phoneNumber = phoneTrim(phoneNumber);
        if (this.phoneNumber.length() != 11) {
            throw new InvalidPhoneNumberException("Номер телефона должен содержать 11 цифр.");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new InvalidCustomerData("Фамилия не может быть пустой или null.");
        }
        if (firstName == null || firstName.isEmpty()) {
            throw new InvalidCustomerData("Имя не может быть пустым или null.");
        }
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = (patronymic != null) ? patronymic : "";
        this.gender = gender;
    }

    public String getFullName() {
        if (Objects.equals(patronymic, "")){
            return String.format("%s %s", lastName, firstName);
        }
        return String.format("%s %s %s", lastName, firstName, patronymic);
    }

    private String phoneTrim(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("[- _()+]", "");

        if (phoneNumber.startsWith("89")) {
            phoneNumber = "79" + phoneNumber.substring(2);
        }

        return phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender.getClientGender();
    }
}
