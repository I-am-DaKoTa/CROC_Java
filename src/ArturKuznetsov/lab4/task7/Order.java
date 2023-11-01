package ArturKuznetsov.lab4.task7;

import ArturKuznetsov.lab3.task5.products.Product;
import ArturKuznetsov.lab4.task7.enums.OrderStatus;
import ArturKuznetsov.lab4.task7.exceptions.InvalidOrderSize;
import ArturKuznetsov.lab4.task7.exceptions.OrderStatusExpection;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    private final String id;
    private final LocalDateTime createdDateTime;
    private LocalDateTime collectedDateTime;
    private LocalDateTime closedDateTime;
    private final ArrayList<Product> orderList;
    private final Client client;
    private OrderStatus status;

    public Order(LocalDateTime createdDateTime, ArrayList<Product> orderList, Client client) throws InvalidOrderSize {
        if (orderList.size() >= 75 || orderList.isEmpty()) {
            throw new InvalidOrderSize("Заказ не может содержать больше 75 товаров или быть пустым.");
        }
        this.createdDateTime = createdDateTime;
        this.orderList = orderList;
        this.client = client;
        id = createId();
        status = OrderStatus.CREATED;
    }

    private String createId() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        return createdDateTime.format(formatter) + client.getPhoneNumber().substring(7);
    }

    public void collectOrder() {
        status = OrderStatus.COLLECTED;
        collectedDateTime = LocalDateTime.now();
        var notification = new Notification(this, client);
        System.out.println(notification);
    }

    public void expireOrder() {
        status = OrderStatus.EXPIRED;
    }

    public void closeOrder() {
        status = OrderStatus.CLOSED;
        closedDateTime = LocalDateTime.now();
    }

    private boolean checkOrderStatusExpired() {
        Duration duration = Duration.between(LocalDateTime.now(), collectedDateTime.plusWeeks(2));
        boolean isStatusExpired = duration.isNegative() || duration.isZero();
        if (isStatusExpired) {
            expireOrder();
        }
        return isStatusExpired;
    }

    public boolean canGetOrder() throws OrderStatusExpection {
        if (status == OrderStatus.CREATED) {
            return false;
        } else if (status == OrderStatus.COLLECTED) {
            if (checkOrderStatusExpired()){
                throw new OrderStatusExpection(String.format("Статус заказа: %s", getStatus()));
            }
            return true;
        }
        throw new OrderStatusExpection(String.format("Статус заказа: %s", getStatus()));
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public LocalDateTime getCollectedDateTime() {
        return collectedDateTime;
    }

    public LocalDateTime getClosedDateTime() {
        return closedDateTime;
    }

    public ArrayList<Product> getOrderList() {
        return orderList;
    }

    public String getStatus() {
        return status.getOrderStatus();
    }
}
