package ArturKuznetsov.lab3.task5.products;

import ArturKuznetsov.lab3.task5.enums.CleaningType;
import ArturKuznetsov.lab3.task5.enums.Colors;
import ArturKuznetsov.lab3.task5.enums.Countries;
import ArturKuznetsov.lab3.task5.exceptions.InvalidValueException;

import java.util.ArrayList;
import java.util.List;

public class RobotVacuumCleaner extends VacuumCleaner{
    private final boolean accelerometer;
    private final boolean builtInClock;
    private final boolean gyroscope;
    private final boolean tofSensor;
    private final boolean heightChangeSensor;
    private final boolean display;
    private final boolean dustbinIndicator;
    private final boolean lidar;
    private final boolean softBumper;
    
    public RobotVacuumCleaner(double price, String name, String description, Colors color, Countries country, int warranty, double weight, CleaningType cleaningType, double dustBagCapacity, double suctionPower, boolean accelerometer, boolean builtInClock, boolean gyroscope, boolean tofSensor, boolean heightChangeSensor, boolean display, boolean dustbinIndicator, boolean lidar, boolean softBumper) throws InvalidValueException {
        super(price, name, description, color, country, warranty, weight, cleaningType, dustBagCapacity, suctionPower);
        this.accelerometer = accelerometer;
        this.builtInClock = builtInClock;
        this.gyroscope = gyroscope;
        this.tofSensor = tofSensor;
        this.heightChangeSensor = heightChangeSensor;
        this.display = display;
        this.dustbinIndicator = dustbinIndicator;
        this.lidar = lidar;
        this.softBumper = softBumper;
    }

    @Override
    public String displayProductInfo() {
        String productInfo = super.displayProductInfo();

        List<String> designFeaturesList = new ArrayList<>();
        if (isAccelerometer()) {
            designFeaturesList.add("Акселерометр");
        }
        if (isBuiltInClock()) {
            designFeaturesList.add("Встроенные часы");
        }
        if (isGyroscope()) {
            designFeaturesList.add("Гироскоп");
        }
        if (isTofSensor()) {
            designFeaturesList.add("Датчик TOF");
        }
        if (isHeightChangeSensor()) {
            designFeaturesList.add("Датчик перепада высоты");
        }
        if (isDisplay()) {
            designFeaturesList.add("Дисплей");
        }
        if (isDustbinIndicator()) {
            designFeaturesList.add("Индикатор заполнения пылесборника");
        }
        if (isLidar()) {
            designFeaturesList.add("Лидар");
        }
        if (isSoftBumper()) {
            designFeaturesList.add("Мягкий бампер");
        }

        String designFeatures = String.join(", ", designFeaturesList);

        productInfo += String.format("Тип уборки: %s\n", getCleaningType());
        productInfo += String.format("Объем пылесборника: %.2f л\n", getDustBagCapacity());
        productInfo += String.format("Мощность всасывания: %.2f Вт\n", getSuctionPower());
        productInfo += String.format("Особенности конструкции: %s\n", designFeatures);
        return productInfo;
    }

    protected boolean isAccelerometer() {
        return accelerometer;
    }

    protected boolean isBuiltInClock() {
        return builtInClock;
    }

    protected boolean isGyroscope() {
        return gyroscope;
    }

    protected boolean isTofSensor() {
        return tofSensor;
    }

    protected boolean isHeightChangeSensor() {
        return heightChangeSensor;
    }

    protected boolean isDisplay() {
        return display;
    }

    protected boolean isDustbinIndicator() {
        return dustbinIndicator;
    }

    protected boolean isLidar() {
        return lidar;
    }

    protected boolean isSoftBumper() {
        return softBumper;
    }
}
