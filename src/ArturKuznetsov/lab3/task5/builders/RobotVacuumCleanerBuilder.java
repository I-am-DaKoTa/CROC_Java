package ArturKuznetsov.lab3.task5.builders;

import ArturKuznetsov.lab3.task5.enums.CleaningType;
import ArturKuznetsov.lab3.task5.enums.Colors;
import ArturKuznetsov.lab3.task5.enums.Countries;
import ArturKuznetsov.lab3.task5.exceptions.InvalidValueException;
import ArturKuznetsov.lab3.task5.products.RobotVacuumCleaner;

public class RobotVacuumCleanerBuilder implements IRobotVacuumCleanerBuilder{
    private double price;
    private String name;
    private String description;
    private Colors color;
    private Countries country;
    private int warranty;
    private double weight;
    private CleaningType cleaningType;
    private double dustBagCapacity;
    private double suctionPower;
    private boolean accelerometer;
    private boolean builtInClock;
    private boolean gyroscope;
    private boolean tofSensor;
    private boolean heightChangeSensor;
    private boolean display;
    private boolean dustbinIndicator;
    private boolean lidar;
    private boolean softBumper;


    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setColor(Colors color) {
        this.color = color;
    }

    @Override
    public void setCountry(Countries country) {
        this.country = country;
    }

    @Override
    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public void setCleaningType(CleaningType cleaningType) {
        this.cleaningType = cleaningType;
    }

    @Override
    public void setDustBagCapacity(double dustBagCapacity) {
        this.dustBagCapacity = dustBagCapacity;
    }

    @Override
    public void setSuctionPower(double suctionPower) {
        this.suctionPower = suctionPower;
    }

    @Override
    public void setAccelerometer(boolean accelerometer) {
        this.accelerometer = accelerometer;
    }

    @Override
    public void setBuiltInClock(boolean builtInClock) {
        this.builtInClock = builtInClock;
    }

    @Override
    public void setGyroscope(boolean horoscopeFeature) {
        this.gyroscope = gyroscope;
    }

    @Override
    public void setTofSensor(boolean tofSensor) {
        this.tofSensor = tofSensor;
    }

    @Override
    public void setHeightChangeSensor(boolean heightChangeSensor) {
        this.heightChangeSensor = heightChangeSensor;
    }

    @Override
    public void setDisplay(boolean display) {
        this.display = display;
    }

    @Override
    public void setDustbinIndicator(boolean dustbinIndicator) {
        this.dustbinIndicator = dustbinIndicator;
    }

    @Override
    public void setLidar(boolean lidar) {
        this.lidar = lidar;
    }

    @Override
    public void setSoftBumper(boolean softBumper) {
        this.softBumper = softBumper;
    }

    public RobotVacuumCleaner build() throws InvalidValueException {
        return new RobotVacuumCleaner(price, name, description, color, country, warranty, weight, cleaningType, dustBagCapacity, suctionPower, accelerometer, builtInClock, gyroscope, tofSensor, heightChangeSensor, display, dustbinIndicator, lidar,  softBumper);
    }
}
