package ArturKuznetsov.lab3.task5.builders;

public interface IRobotVacuumCleanerBuilder extends IVacuumCleanerBuilder{

    void setAccelerometer (boolean accelerometer);
    void setBuiltInClock (boolean builtInClock);
    void setGyroscope (boolean gyroscope);
    void setTofSensor (boolean tofSensor);
    void setHeightChangeSensor (boolean heightChangeSensor);
    void setDisplay (boolean display);
    void setDustbinIndicator (boolean dustbinIndicator);
    void setLidar (boolean lidar);
    void setSoftBumper (boolean softBumper);
}
