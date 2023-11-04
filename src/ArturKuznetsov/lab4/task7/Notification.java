package ArturKuznetsov.lab4.task7;

import ArturKuznetsov.lab3.task5.products.Product;
import ArturKuznetsov.lab4.task7.enums.Gender;
import ArturKuznetsov.lab4.task7.exceptions.OrderStatusException;
import ArturKuznetsov.lab4.task7.interfaces.INotification;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Notification implements INotification {
    Order order;
    Client client;

    public Notification(Order order, Client client) {
        this.order = order;
        this.client = client;
    }

    private String getGreeting() {
        String ending = "ый";
        if (client.getGender() == Gender.FEMALE){
            ending = "ая";
        }
        return String.format("Уважаем%s %s!\nРады сообщить, что Ваш заказ %s готов к выдаче.\n",ending, client.getFullName(), order.getId());
    }

    private String getOrderListInfo() {
        double totalPrice = 0;
        StringBuilder orderListInfo = new StringBuilder("Состав заказа:\n");
        for (Product product : order.getOrderList()) {
            orderListInfo.append(product.displayProductInfo()).append('\n');
            totalPrice += product.getPrice();
        }
        Locale russian = new Locale("ru", "RU");
        NumberFormat russianFormat = NumberFormat.getCurrencyInstance(russian);
        orderListInfo.append(String.format("Сумма к оплате: %s\n", russianFormat.format(totalPrice)));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        orderListInfo.append(String.format("Срок хранения заказа %s.\n",order.getCollectedDateTime().plusWeeks(2).format(formatter)));
        return orderListInfo.toString();
    }
    @Override
    public String toString() {
        String notification = "Заказ ещё не собран";
        try {
            if (order.canGetOrder()) {
                notification = getGreeting();
                notification += getOrderListInfo();
                notification += "С наилучшими пожеланиями, магазин \"Кошки и картошки\"";
            }
        } catch (OrderStatusException e) {
            return notification;
        }
        return notification;
    }
}
