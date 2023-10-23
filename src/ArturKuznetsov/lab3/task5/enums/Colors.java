package ArturKuznetsov.lab3.task5.enums;

public enum Colors {
    BEIGE("Бежевый"),
    BLACK("Черный"),
    BLUE("Голубой"),
    BROWN("Коричневый"),
    BURGUNDY("Бордовый"),
    DARK_GRAY("Темно-серый"),
    GRAY("Серый"),
    GREEN("Зеленый"),
    LIGHT_BLUE("Светло-синий"),
    LIGHT_GRAY("Светло-серый"),
    LILAC("Сиреневый"),
    NAVY("Синий"),
    ORANGE("Оранжевый"),
    PINK("Розовый"),
    PURPLE("Фиолетовый"),
    RED("Красный"),
    SALMON("Лососевый"),
    TERRACOTTA("Терракотовый"),
    WHITE("Белый"),
    YELLOW("Желтый");

    private final String colorName;

    Colors(String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }
}
