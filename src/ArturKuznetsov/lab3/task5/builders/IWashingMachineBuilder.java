package ArturKuznetsov.lab3.task5.builders;


import ArturKuznetsov.lab3.task5.enums.EnergyEfficiency;
import ArturKuznetsov.lab3.task5.enums.FreezerLocation;
import ArturKuznetsov.lab3.task5.enums.LoadType;

public interface IWashingMachineBuilder extends IBuilder {
    void setLoadType(LoadType loadType);
    void setMaxLoadKilograms(double maxLoadKilograms);
    void setHasDryer(boolean hasDryer);
    void setMaxSpinSpeedRPM(int maxSpinSpeedRPM);
    void setEnergyEfficiency(EnergyEfficiency energyEfficiency);
    void setWidthInCentimeters(double widthInCentimeters);
    void setHeightInCentimeters(double heightInCentimeters);
    void setDepthInCentimeters(double depthInCentimeters);
}