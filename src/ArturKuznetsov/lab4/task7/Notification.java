package ArturKuznetsov.lab4.task7;

import ArturKuznetsov.lab3.task5.products.Product;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Notification {
    Order order;
    Client client;

    public Notification(Order order, Client client) {
        this.order = order;
        this.client = client;
    }

    private String getGreeting() {
        String ending = "ый";
        if (Objects.equals(client.getGender(), "Женщина")){
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
        orderListInfo.append(String.format("Сумма к оплате: %.2f₽\n", totalPrice));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        orderListInfo.append(String.format("Срок хранения заказа %s.\n",order.getCollectedDateTime().plusWeeks(2).format(formatter)));
        return orderListInfo.toString();
    }
    @Override
    public String toString() {
        String notification = getGreeting();
        notification += getOrderListInfo();
        notification += "С наилучшими пожеланиями, магазин \"Кошки и картошки\"";
        return notification;
    }
}
