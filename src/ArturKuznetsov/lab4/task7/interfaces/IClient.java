package ArturKuznetsov.lab4.task7.interfaces;

import ArturKuznetsov.lab4.task7.enums.Gender;
import ArturKuznetsov.lab4.task7.exceptions.InvalidPhoneNumberException;

/**
 * Клиент, который совершает заказ в магазине "Кошки и картошки".
 *
 * @author Artur Kuznetsov
 */
public interface IClient {
    /**
     * Конструктор принимает слудеющие данные клиента:
     * номер телефона, фамилию, имя, отчёство, пол.
     *
     * @throws InvalidPhoneNumberException
     *          Если номер телефона не содержит ровно 11 цифр.
     * @throws InvalidCustomerData
     *          Если имя или фамилия пусты или null.
     */

    /**
     * Возвращает ФИО клиента.
     *
     * @return ФИО составленное из фамилии, имени и отчества (если есть).
     */
    String getFullName();

    /**
     * Возвращает номер телефона клиента.
     * <p/>
     * Формат вывода номера телефона: 11 цифр без каких-либо символов.
     *
     * @return номер телефона клиента.
     */
    String getPhoneNumber();

    /**
     * Возвращает пол клиента.
     * <p/>
     * В реализации задания есть 2 пола: Gender.MALE и Gender.FEMALE.
     * @see Gender
     *
     * @return пол клиента.
     */
    Gender getGender();
}
