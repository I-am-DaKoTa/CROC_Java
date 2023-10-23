package ArturKuznetsov.lab3.task5.enums;

public enum LoadType {
    FRONT("Фронтальная загрузка"),
    TOP("Вертикальная загрузка");

    private final String loadTypeName;

    LoadType(String freezerLocationName) {
        this.loadTypeName = freezerLocationName;
    }

    public String getLoadTypeName() {
        return loadTypeName;
    }
}
