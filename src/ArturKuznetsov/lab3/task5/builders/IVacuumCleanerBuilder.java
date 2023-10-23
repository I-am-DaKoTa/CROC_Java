package ArturKuznetsov.lab3.task5.builders;

import ArturKuznetsov.lab3.task5.enums.CleaningType;

public interface IVacuumCleanerBuilder extends IBuilder{
    void setCleaningType(CleaningType cleaningType);
    void setDustBagCapacity(double dustBagCapacity);
    void setSuctionPower(double suctionPower);
}
