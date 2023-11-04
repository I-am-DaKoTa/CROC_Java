package ArturKuznetsov.lab3.task5.products;

import ArturKuznetsov.lab3.task5.enums.Colors;
import ArturKuznetsov.lab3.task5.enums.Countries;
import ArturKuznetsov.lab3.task5.exceptions.InvalidValueException;
import ArturKuznetsov.lab3.task5.exceptions.NotImportedProductException;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public abstract class Product {
    private final double price;
    private final String name;
    private final String description;
    private final Colors color;
    private final Countries country;
    private final int warranty;
    private final double weight;

    public Product(double price, String name, String description, Colors color, Countries country, int warranty, double weight) throws InvalidValueException {
        if (price <= 0) {
            throw new InvalidValueException("Цена не может быть отрицательной или равна нулю");
        }
        if (warranty <= 0) {
            throw new InvalidValueException("Срок гарантии не может быть отрицательным или равным нулю");
        }
        if (weight <= 0) {
            throw new InvalidValueException("Вес не может быть отрицательным или равным нулю");
        }
        this.price = price;
        this.name = name;
        this.description = description;
        this.color = color;
        this.country = country;
        this.warranty = warranty;
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color.getColorName();
    }

    public String getCountry() {
        return country.getCountryName();
    }

    public int getWarranty() {
        return warranty;
    }

    public double getWeight() {
        return weight;
    }

    public String displayProductInfo() {
        String warrantyPeriod = getWarrantyPeriod();

        Locale russian = new Locale("ru", "RU");
        NumberFormat russianFormat = NumberFormat.getCurrencyInstance(russian);

        String productInfo = "Информация о товаре\n";
        productInfo += String.format("Цена: %s\n", russianFormat.format(getPrice()));
        productInfo += String.format("Наименование: %s\n", getName());
        productInfo += String.format("Описание: %s\n", getDescription());
        productInfo += String.format("Цвет: %s\n", getColor());
        productInfo += String.format("Страна производства: %s\n", getCountry());
        productInfo += String.format("Гарантия: %d %s\n", getWarranty(), warrantyPeriod);
        productInfo += String.format("Вес: %s кг\n", getWeight());

        return productInfo;
    }

    protected String getWarrantyPeriod() {
        if (getWarranty() == 1) {
            return "год";
        } else if (1 < getWarranty() || getWarranty() < 5) {
            return "года";
        } else {
            return "лет";
        }
    }

    public void isImportedException() throws NotImportedProductException {
        if (Objects.equals(getCountry(), "Россия")) {
            throw new NotImportedProductException(String.format("%s не является импортным.\n", getName()));
        }
    }

    public String getImportProductDetails() {
        try {
            isImportedException();
        }
        catch (NotImportedProductException e) {
            return (e.getMessage());
        }

        String warrantyPeriod = getWarrantyPeriod();

        String importProductDetails = "Информация об импортном товаре \n";
        importProductDetails += String.format("Наименование: %s\n", getName());
        importProductDetails += String.format("Страна производства: %s\n", getCountry());
        importProductDetails += String.format("Гарантия: %d %s\n", getWarranty(), warrantyPeriod);

        return importProductDetails;

    }
}
