package ArturKuznetsov.lab4.task7;

import ArturKuznetsov.lab3.task5.builders.FridgeBuilder;
import ArturKuznetsov.lab3.task5.builders.RobotVacuumCleanerBuilder;
import ArturKuznetsov.lab3.task5.builders.WashingMachineBuilder;
import ArturKuznetsov.lab3.task5.director.Director;
import ArturKuznetsov.lab3.task5.exceptions.InvalidValueException;
import ArturKuznetsov.lab3.task5.products.Product;
import ArturKuznetsov.lab4.task7.enums.Gender;
import ArturKuznetsov.lab4.task7.exceptions.InvalidCustomerData;
import ArturKuznetsov.lab4.task7.exceptions.InvalidOrderSize;
import ArturKuznetsov.lab4.task7.exceptions.InvalidPhoneNumberException;
import ArturKuznetsov.lab4.task7.exceptions.OrderStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InvalidValueException, InvalidPhoneNumberException, InvalidCustomerData, InvalidOrderSize, OrderStatusException {
        Director director = new Director();

        var fridgeBuilder = new FridgeBuilder();
        var robotVacuumCleanerBuilder = new RobotVacuumCleanerBuilder();
        var washingMachineBuilder = new WashingMachineBuilder();

        director.constructHyundaiFridge(fridgeBuilder);
        director.constructRedmondRobotVacuumCleaner(robotVacuumCleanerBuilder);
        director.constructSamsungWashingMachine(washingMachineBuilder);

        var fridge = fridgeBuilder.build();
        var robotVacuumCleaner = robotVacuumCleanerBuilder.build();
        var washingMachine = washingMachineBuilder.build();

        ArrayList<Product> orderList = new ArrayList<>();
        orderList.add(fridge);
        orderList.add(robotVacuumCleaner);
        orderList.add(washingMachine);

        LocalDateTime createdDateTime = LocalDateTime.now();

        Client client = new Client("+7 (912) 421-74-49","Иванов", "Иван",null, Gender.MALE);
        Order order = new Order(createdDateTime, orderList, client);

        System.out.println(order.getId());

        System.out.println(order.getStatus());
        System.out.println(order.canGetOrder());

        order.collectOrder();
        System.out.println(order.getStatus());
        System.out.println(order.canGetOrder());
        System.out.println(order.getOrderNotification());

        order.closeOrder();
        System.out.println(order.getStatus());
    }
}
