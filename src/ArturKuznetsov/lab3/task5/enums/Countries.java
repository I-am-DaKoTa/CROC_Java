package ArturKuznetsov.lab3.task5.enums;

public enum Countries {
    USA("США"),
    UNITED_KINGDOM("Великобритания"),
    CANADA("Канада"),
    AUSTRALIA("Австралия"),
    GERMANY("Германия"),
    FRANCE("Франция"),
    ITALY("Италия"),
    SPAIN("Испания"),
    JAPAN("Япония"),
    CHINA("Китай"),
    INDIA("Индия"),
    BRAZIL("Бразилия"),
    RUSSIA("Россия"),
    SOUTH_KOREA("Южная Корея"),
    MEXICO("Мексика"),
    NETHERLANDS("Нидерланды"),
    SWITZERLAND("Швейцария"),
    SWEDEN("Швеция"),
    NORWAY("Норвегия"),
    DENMARK("Дания");

    private final String countryName;

    Countries(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }
}