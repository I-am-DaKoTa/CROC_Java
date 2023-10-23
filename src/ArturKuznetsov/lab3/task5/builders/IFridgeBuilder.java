package ArturKuznetsov.lab3.task5.builders;

import ArturKuznetsov.lab3.task5.enums.EnergyEfficiency;
import ArturKuznetsov.lab3.task5.enums.FreezerLocation;

public interface IFridgeBuilder extends IBuilder{
    void setFridgeVolumeLiters(double fridgeVolumeLiters);
    void setFreezerVolumeLiters(double freezerVolumeLiters);
    void setFreezerLocation(FreezerLocation freezerLocation);
    void setEnergyEfficiency(EnergyEfficiency energyEfficiency);
    void setWidthInCentimeters(double widthInCentimeters);
    void setHeightInCentimeters(double heightInCentimeters);
    void setDepthInCentimeters(double depthInCentimeters);
}
