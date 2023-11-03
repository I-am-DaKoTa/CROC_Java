package ArturKuznetsov.lab3.task5.products;

import ArturKuznetsov.lab3.task5.enums.Colors;
import ArturKuznetsov.lab3.task5.enums.Countries;
import ArturKuznetsov.lab3.task5.enums.EnergyEfficiency;
import ArturKuznetsov.lab3.task5.enums.FreezerLocation;
import ArturKuznetsov.lab3.task5.exceptions.InvalidValueException;

public class Fridge extends Product{
    private final double fridgeVolumeLiters;
    private final double freezerVolumeLiters;
    private final FreezerLocation freezerLocation;
    private final EnergyEfficiency energyEfficiency;
    private final double widthInCentimeters;
    private final double heightInCentimeters;
    private final double depthInCentimeters;
    public Fridge(double price, String name, String description, Colors color, Countries country, int warranty, double weight, double fridgeVolumeLiters, double freezerVolumeLiters, FreezerLocation freezerLocation, EnergyEfficiency energyEfficiency, double widthInCentimeters, double heightInCentimeters, double depthInCentimeters) throws InvalidValueException {
        super(price, name, description, color, country, warranty, weight);
        if (fridgeVolumeLiters <= 0) {
            throw new InvalidValueException("Объем холодильной камеры не может быть отрицательным или равным нулю");
        }
        if (freezerVolumeLiters < 0) {
            throw new InvalidValueException("Объем морозильной камеры не может быть отрицательным");
        }
        if (widthInCentimeters <= 0) {
            throw new InvalidValueException("Ширина не может быть отрицательной или равной нулю");
        }
        if (heightInCentimeters <= 0) {
            throw new InvalidValueException("Высота не может быть отрицательной или равной нулю");
        }
        if (depthInCentimeters <= 0) {
            throw new InvalidValueException("Глубина не может быть отрицательной или равной нулю");
        }
        this.fridgeVolumeLiters = fridgeVolumeLiters;
        this.freezerVolumeLiters = freezerVolumeLiters;
        this.freezerLocation = freezerLocation;
        this.energyEfficiency = energyEfficiency;
        this.widthInCentimeters = widthInCentimeters;
        this.heightInCentimeters = heightInCentimeters;
        this.depthInCentimeters = depthInCentimeters;
    }
    @Override
    public String displayProductInfo() {
        String productInfo = super.displayProductInfo();
        productInfo += String.format("Объем холодильной камеры: %.2f литров\n", getRefrigeratorVolumeLiters());
        if (!(getFreezerLocation().equals("Отсутствует"))){
            productInfo += String.format("Объем морозильной камеры: %.2f литров\n", getFreezerVolumeLiters());
            productInfo += String.format("Местоположение морозильной камеры: %s\n", getFreezerLocation());
        }
        productInfo += String.format("Класс энергопотребления: %s\n", getEnergyEfficiency());
        productInfo += String.format("ШхВхГ: %.2fсм x %.2fсм x %.2fсм\n", getWidthInCentimeters(), getHeightInCentimeters(), getDepthInCentimeters());
        return productInfo;
    }
    protected double getRefrigeratorVolumeLiters() {
        return fridgeVolumeLiters;
    }

    protected double getFreezerVolumeLiters() {
        return freezerVolumeLiters;
    }

    protected String getFreezerLocation() {
        return freezerLocation.getFreezerLocationName();
    }

    protected String getEnergyEfficiency() {
        return energyEfficiency.getEnergyEfficiencyName();
    }

    protected double getWidthInCentimeters() {
        return widthInCentimeters;
    }

    protected double getHeightInCentimeters() {
        return heightInCentimeters;
    }

    protected double getDepthInCentimeters() {
        return depthInCentimeters;
    }
}
