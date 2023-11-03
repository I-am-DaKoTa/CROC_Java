package ArturKuznetsov.lab3.task5.products;

import ArturKuznetsov.lab3.task5.enums.CleaningType;
import ArturKuznetsov.lab3.task5.enums.Colors;
import ArturKuznetsov.lab3.task5.enums.Countries;
import ArturKuznetsov.lab3.task5.exceptions.InvalidValueException;

public class VacuumCleaner extends Product{
    private final CleaningType cleaningType;
    private final double dustBagCapacity;
    private final double suctionPower;

    public VacuumCleaner(double price, String name, String description, Colors color, Countries country, int warranty, double weight, CleaningType cleaningType, double dustBagCapacity, double suctionPower) throws InvalidValueException {
        super(price, name, description, color, country, warranty, weight);
        if (dustBagCapacity <= 0) {
            throw new InvalidValueException("Объем пылесборника не может быть отрицательным или равным нулю");
        }
        if (suctionPower <= 0) {
            throw new InvalidValueException("Мощность всасывания не может быть отрицательной или равной нулю");
        }
        this.cleaningType = cleaningType;
        this.dustBagCapacity = dustBagCapacity;
        this.suctionPower = suctionPower;
    }

    @Override
    public String displayProductInfo() {
        String productInfo = super.displayProductInfo();

        productInfo += String.format("Тип уборки: %s\n", getCleaningType());
        productInfo += String.format("Объем пылесборника: %.2f л\n", getDustBagCapacity());
        productInfo += String.format("Мощность всасывания: %.2f Вт\n", getSuctionPower());

        return productInfo;
    }

    protected String getCleaningType() {
        return cleaningType.getCleaningTypeName();
    }

    protected double getDustBagCapacity() {
        return dustBagCapacity;
    }

    protected double getSuctionPower() {
        return suctionPower;
    }
}
