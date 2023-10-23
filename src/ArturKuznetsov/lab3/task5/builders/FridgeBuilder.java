package ArturKuznetsov.lab3.task5.builders;

import ArturKuznetsov.lab3.task5.enums.Colors;
import ArturKuznetsov.lab3.task5.enums.Countries;
import ArturKuznetsov.lab3.task5.enums.EnergyEfficiency;
import ArturKuznetsov.lab3.task5.enums.FreezerLocation;
import ArturKuznetsov.lab3.task5.exceptions.InvalidValueException;
import ArturKuznetsov.lab3.task5.products.Fridge;

public class FridgeBuilder implements IFridgeBuilder{
    private double price;
    private String name;
    private String description;
    private Colors color;
    private Countries country;
    private int warranty;
    private double weight;
    private double fridgeVolumeLiters;
    private double freezerVolumeLiters;
    private FreezerLocation freezerLocation;
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
    public void setFridgeVolumeLiters(double fridgeVolumeLiters) {
        this.fridgeVolumeLiters = fridgeVolumeLiters;
    }

    @Override
    public void setFreezerVolumeLiters(double freezerVolumeLiters) {
        this.freezerVolumeLiters = freezerVolumeLiters;
    }

    @Override
    public void setFreezerLocation(FreezerLocation freezerLocation) {
        this.freezerLocation = freezerLocation;
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


    public Fridge build() throws InvalidValueException {
        return new Fridge(price, name, description, color, country, warranty, weight, fridgeVolumeLiters, freezerVolumeLiters, freezerLocation, energyEfficiency, widthInCentimeters, heightInCentimeters, depthInCentimeters);
    }
}
