package ArturKuznetsov.lab3.task5.products;

import ArturKuznetsov.lab3.task5.enums.Colors;
import ArturKuznetsov.lab3.task5.enums.Countries;
import ArturKuznetsov.lab3.task5.enums.EnergyEfficiency;
import ArturKuznetsov.lab3.task5.enums.LoadType;
import ArturKuznetsov.lab3.task5.exceptions.InvalidValueException;

public class WashingMachine extends Product {
    private final LoadType loadType;
    private final double maxLoadKilograms;
    private final boolean hasDryer;
    private final int maxSpinSpeedRPM;
    private final EnergyEfficiency energyEfficiency;
    private final double widthInCentimeters;
    private final double heightInCentimeters;
    private final double depthInCentimeters;
    public WashingMachine(double price, String name, String description, Colors color, Countries country, int warranty, double weight, LoadType loadType, double maxLoadKilograms, boolean hasDryer, int maxSpinSpeedRPM, EnergyEfficiency energyEfficiency, double widthInCentimeters, double heightInCentimeters, double depthInCentimeters) throws InvalidValueException {
        super(price, name, description, color, country, warranty, weight);
        if (maxLoadKilograms <= 0) {
            throw new InvalidValueException("Максимальная загрузка белья не может быть отрицательной или равной нулю");
        }
        if (maxSpinSpeedRPM <= 0) {
            throw new InvalidValueException("Максимальная скорость вращения не может быть отрицательной или равной нулю");
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
        this.loadType = loadType;
        this.maxLoadKilograms = maxLoadKilograms;
        this.hasDryer = hasDryer;
        this.maxSpinSpeedRPM = maxSpinSpeedRPM;
        this.energyEfficiency = energyEfficiency;
        this.widthInCentimeters = widthInCentimeters;
        this.heightInCentimeters = heightInCentimeters;
        this.depthInCentimeters = depthInCentimeters;
    }

    @Override
    public String displayProductInfo() {
        String productInfo = super.displayProductInfo();
        /*
        productInfo += String.format("Тип загрузки: %s\n", getLoadType());
        productInfo += String.format("Максимальная загрузка белья : %.2f кг\n", getMaxLoadKilograms());
        if (isHasDryer()){productInfo += "Особенности конструкции: Есть сушильная машина\n";}
        productInfo += String.format("Максимальная скорость вращения: %d об/мин\n", getMaxSpinSpeedRPM());
        productInfo += String.format("Класс энергопотребления: %s\n", getEnergyEfficiency());
        productInfo += String.format("ШхВхГ: %.2fсм x %.2fсм x %.2fсм\n", getWidthInCentimeters(), getHeightInCentimeters(), getDepthInCentimeters());
         */
        return productInfo;
    }

    public String getLoadType() {
        return loadType.getLoadTypeName();
    }

    public double getMaxLoadKilograms() {
        return maxLoadKilograms;
    }

    public boolean isHasDryer() {
        return hasDryer;
    }

    public int getMaxSpinSpeedRPM() {
        return maxSpinSpeedRPM;
    }

    public String getEnergyEfficiency() {
        return energyEfficiency.getEnergyEfficiencyName();
    }

    public double getWidthInCentimeters() {
        return widthInCentimeters;
    }

    public double getHeightInCentimeters() {
        return heightInCentimeters;
    }

    public double getDepthInCentimeters() {
        return depthInCentimeters;
    }
}
