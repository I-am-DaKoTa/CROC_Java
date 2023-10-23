package ArturKuznetsov.lab3.task5.builders;

import ArturKuznetsov.lab3.task5.enums.Colors;
import ArturKuznetsov.lab3.task5.enums.Countries;

public interface IBuilder {
    void setPrice(double price);
    void setName(String name);
    void setDescription(String description);
    void setColor(Colors color);
    void setCountry(Countries country);
    void setWarranty(int warranty);
    void setWeight(double weight);
}
