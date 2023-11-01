package ArturKuznetsov.lab4.task7.enums;

public enum OrderStatus {
    CREATED("Создан"),
    COLLECTED("Собран"),
    EXPIRED("Истёк"),
    CLOSED("Закрыт");
    private final String orderStatus;

    OrderStatus(String clientGender) {
        this.orderStatus = clientGender;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
}
