package ArturKuznetsov.lab3.task5.builders;

import ArturKuznetsov.lab3.task5.enums.*;
import ArturKuznetsov.lab3.task5.exceptions.InvalidValueException;
import ArturKuznetsov.lab3.task5.products.WashingMachine;

public class WashingMachineBuilder implements IWashingMachineBuilder{
    private double price;
    private String name;
    private String description;
    private Colors color;
    private Countries country;
    private int warranty;
    private double weight;
    private LoadType loadType;
    private double maxLoadKilograms;
    private boolean hasDryer;
    private int maxSpinSpeedRPM;
    private EnergyEfficiency energyEfficiency;
    private double widthInCentimeters;
    private double heightInCentimeters;
    private double depthInCentimeters;
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
    public void setLoadType(LoadType loadType) {
        this.loadType = loadType;
    }

    @Override
    public void setMaxLoadKilograms(double maxLoadKilograms) {
        this.maxLoadKilograms = maxLoadKilograms;
    }

    @Override
    public void setHasDryer(boolean hasDryer) {
        this.hasDryer = hasDryer;
    }

    @Override
    public void setMaxSpinSpeedRPM(int maxSpinSpeedRPM) {
        this.maxSpinSpeedRPM = maxSpinSpeedRPM;
    }

    @Override
    public void setEnergyEfficiency(EnergyEfficiency energyEfficiency) {
        this.energyEfficiency = energyEfficiency;
    }

    @Override
    public void setWidthInCentimeters(double widthInCentimeters) {
        this.widthInCentimeters = widthInCentimeters;
    }

    @Override
    public void setHeightInCentimeters(double heightInCentimeters) {
        this.heightInCentimeters = heightInCentimeters;
    }

    @Override
    public void setDepthInCentimeters(double depthInCentimeters) {
        this.depthInCentimeters = depthInCentimeters;
    }

    public WashingMachine build() throws InvalidValueException {
        return new WashingMachine(price, name, description, color, country, warranty, weight, loadType, maxLoadKilograms, hasDryer, maxSpinSpeedRPM, energyEfficiency, widthInCentimeters, heightInCentimeters, depthInCentimeters);
    }
}
