package ArturKuznetsov.lab3.task5;

import ArturKuznetsov.lab3.task5.builders.FridgeBuilder;
import ArturKuznetsov.lab3.task5.builders.RobotVacuumCleanerBuilder;
import ArturKuznetsov.lab3.task5.builders.WashingMachineBuilder;
import ArturKuznetsov.lab3.task5.director.Director;
import ArturKuznetsov.lab3.task5.exceptions.InvalidValueException;
import ArturKuznetsov.lab3.task5.exceptions.NotImportedProductException;

public class Main {
    public static void main(String[] args) throws NotImportedProductException, InvalidValueException {
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

        var catalog = new Catalog();
        catalog.addProduct(fridge);
        catalog.addProduct(robotVacuumCleaner);
        catalog.addProduct(washingMachine);

        catalog.showAllCatalog();

        System.out.println("================================================\n");

        catalog.showFirstImportedThenLocal();

        System.out.println("================================================\n");

        System.out.println(fridge.getImportProductDetails());
        System.out.println(robotVacuumCleaner.getImportProductDetails());
        System.out.println(washingMachine.getImportProductDetails());

    }
}
