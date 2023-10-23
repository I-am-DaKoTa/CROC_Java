package ArturKuznetsov.lab3.task5.enums;

public enum CleaningType {
    DRY("Сухая уборка"),
    WET("Влажная уборка"),
    DRY_AND_WET("Сухая и влажная уборка");

    private final String cleaningTypeName;

    CleaningType(String colorName) {
        this.cleaningTypeName = colorName;
    }

    public String getCleaningTypeName() {
        return cleaningTypeName;
    }
}
