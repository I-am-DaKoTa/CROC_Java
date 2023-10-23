package ArturKuznetsov.lab3.task5.builders;

import ArturKuznetsov.lab3.task5.enums.CleaningType;
import ArturKuznetsov.lab3.task5.enums.Colors;
import ArturKuznetsov.lab3.task5.enums.Countries;
import ArturKuznetsov.lab3.task5.exceptions.InvalidValueException;
import ArturKuznetsov.lab3.task5.products.VacuumCleaner;

public class VacuumCleanerBuilder implements IVacuumCleanerBuilder{
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
    public void setColor(Colors colors) {
        this.color = colors;
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

    public VacuumCleaner build() throws InvalidValueException {
        return new VacuumCleaner(price, name, description, color, country, warranty, weight, cleaningType, dustBagCapacity, suctionPower);
    }
}
