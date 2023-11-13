package ArturKuznetsov.lab4.task7;

import ArturKuznetsov.lab3.task5.products.Product;
import ArturKuznetsov.lab4.task7.enums.OrderStatus;
import ArturKuznetsov.lab4.task7.exceptions.InvalidOrderSize;
import ArturKuznetsov.lab4.task7.exceptions.OrderStatusException;
import ArturKuznetsov.lab4.task7.interfaces.IOrder;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order implements IOrder {
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

    public void collectOrder() throws OrderStatusException {
        if (status != OrderStatus.CREATED) {
            throw new OrderStatusException("Нельзя собрать заказ с текущим статусом: " + getStatus());
        }
        status = OrderStatus.COLLECTED;
        collectedDateTime = LocalDateTime.now();
    }

    private void expireOrder() {
        status = OrderStatus.EXPIRED;
    }

    public void closeOrder() throws OrderStatusException {
        if (status != OrderStatus.COLLECTED) {
            throw new OrderStatusException("Нельзя закрыть заказ с текущим статусом: " + getStatus());
        }
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

    public boolean canGetOrder() throws OrderStatusException {
        if (status == OrderStatus.CREATED) {
            return false;
        } else if (checkOrderStatusExpired()) {
            throw new OrderStatusException("Невозможно получить заказ с текущим статусом: " + getStatus());
        }
        return true;
    }

    public Notification getOrderNotification() throws OrderStatusException {
        if (!status.equals(OrderStatus.COLLECTED)) {
            throw new OrderStatusException("Нельзя получить уведомление, так как статус заказа " + getStatus());
        }
        return new Notification(this);
    }

    public final Client getClient(){
        return client;
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
        return new ArrayList<>(orderList);
    }

    public String getStatus() {
        return status.getOrderStatus();
    }
}
