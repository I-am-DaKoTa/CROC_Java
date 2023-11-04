package ArturKuznetsov.lab4.task7.interfaces;

import ArturKuznetsov.lab3.task5.products.Product;
import ArturKuznetsov.lab4.task7.Notification;
import ArturKuznetsov.lab4.task7.exceptions.OrderStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Класс отвечающий за заказы.
 *
 * @author Artur Kuznetsov
 * @see ArturKuznetsov.lab4.task7.enums.OrderStatus
 */
public interface IOrder {

    /**
     * Изменяет статус заказа на "Собран" и записывает время сбора заказа.
     *
     * @throws OrderStatusException
     *          Если статус заказа не "Создан"
     */
    void collectOrder() throws OrderStatusException;

    /**
     * Изменяет статус заказа на "Закрыт" и записывает время получения заказа.
     *
     * @throws OrderStatusException
     *          Если статус заказа не "Собран"
     */
    void closeOrder() throws OrderStatusException;

    /**
     * Возвращает информацию о возможности получения заказа.
     * <p/>
     * - если заказ пока не собран, то получение недоступно, метод возвращает false,
     * - если заказ уже собран и срок его хранения пока не вышел, то заказ доступен для получения, метод возвращает true,
     * - если заказ собран, но срок хранения истёк, то метод бросает исключение.
     *
     * @return информацию о возможности получения заказа.
     * @throws OrderStatusException
     *          если статус заказа "Истёк"
     */
    boolean canGetOrder() throws OrderStatusException;

    /**
     * Возвращает формирование и отправку уведомления клиенту о его собранном заказе.
     *
     * @return номер заказа.
     * @throws OrderStatusException
     *          если статус заказа не "Собран"
     * @see Notification
     */
    Notification getOrderNotification() throws OrderStatusException;

    /**
     * Возвращает номер заказа.
     * <p/>
     * Формировать номер заказа нужно следующим образом:
     * <год - 2 последних цифры><месяц - 2 цифры><день - 2 цифры><часы - 2 цифры><минуты - 2 цифры><секунды - 2 цифры><4 последних цифры номера телефона заказчика>
     *
     * @return номер заказа.
     */
    String getId();

    /**
     * Возвращает дату/время поступления заказа.
     *
     * @return дату/время поступления заказа.
     */
    LocalDateTime getCreatedDateTime();

    /**
     * Возвращает дату/время сборки заказа.
     *
     * @return дату/время сборки заказа.
     */
    LocalDateTime getCollectedDateTime();

    /**
     * Возвращает дату/время получения заказа.
     *
     * @return дату/время получения заказа.
     */
    LocalDateTime getClosedDateTime();

    /**
     * Возвращает копию списка заказа клиента.
     *
     * @return копию списка заказа клиента.
     */
    ArrayList<Product> getOrderList();

    /**
     * Возвращает статут заказа.
     * @see ArturKuznetsov.lab4.task7.enums.OrderStatus
     *
     * @return статут заказа.
     */
    String getStatus();
}
