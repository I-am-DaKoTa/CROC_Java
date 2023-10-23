package ArturKuznetsov.lab3.task5.enums;

public enum EnergyEfficiency {
    A_PLUS_PLUS_PLUS("A+++"),
    A_PLUS_PLUS("A++"),
    A_PLUS("A+"),
    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    F("F");

    private final String energyEfficiencyName;

    EnergyEfficiency(String energyEfficiencyName) {
        this.energyEfficiencyName = energyEfficiencyName;
    }

    public String getEnergyEfficiencyName() {
        return energyEfficiencyName;
    }
}

