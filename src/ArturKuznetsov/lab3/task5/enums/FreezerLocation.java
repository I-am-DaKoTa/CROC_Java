package ArturKuznetsov.lab3.task5.enums;

public enum FreezerLocation {
    TOP("Сверху"),
    BOTTOM("Снизу"),
    SIDE("Сбоку"),
    NONE("Отсутствует");

    private final String freezerLocationName;

    FreezerLocation(String freezerLocationName) {
        this.freezerLocationName = freezerLocationName;
    }

    public String getFreezerLocationName() {
        return freezerLocationName;
    }
}
