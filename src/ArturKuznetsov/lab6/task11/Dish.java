package ArturKuznetsov.lab6.task11;

import ArturKuznetsov.lab6.task11.enums.DishCategory;
import ArturKuznetsov.lab6.task11.exceptions.InvalidDishDataException;
import ArturKuznetsov.lab6.task11.exceptions.InvalidDishRatingException;

import java.util.Set;

public class Dish {
    private final String dishName;
    private final Set<String> dishIngredients;
    private final DishCategory dishCategory;
    private int kingRating;
    private int courtiersRating;


    public Dish(String dishName, Set<String> dishIngredients, DishCategory dishCategory, int kingRating, int courtiersRating) {
        if (dishName == null || dishName.isEmpty()) {
            throw new InvalidDishDataException("dishName");
        }
        if (dishIngredients == null || dishIngredients.isEmpty()) {
            throw new InvalidDishDataException("dishIngredients");
        }
        if (kingRating < 0 || kingRating > 100) {
            throw new InvalidDishRatingException("короля", kingRating, 0, 100);
        }
        if (courtiersRating < 0 || courtiersRating > 100) {
            throw new InvalidDishRatingException("придворных", kingRating, 0, 100);
        }
        this.dishName = dishName;
        this.dishIngredients = dishIngredients;
        this.dishCategory = dishCategory;
        this.kingRating = kingRating;
        this.courtiersRating = courtiersRating;
    }

    public String getDishName() {
        return dishName;
    }

    public Set<String> getDishIngredients() {
        return dishIngredients;
    }

    public DishCategory getDishCategory() {
        return dishCategory;
    }

    public int getKingRating() {
        return kingRating;
    }

    public void setKingRating(int kingRating) {
        if (kingRating < 0 || kingRating > 100) {
            throw new InvalidDishRatingException("короля", kingRating, 0, 100);
        }
        this.kingRating = kingRating;
    }

    public int getCourtiersRating() {
        return courtiersRating;
    }

    public void setCourtiersRating(int courtiersRating) {
        if (courtiersRating < 0 || courtiersRating > 100) {
            throw new InvalidDishRatingException("придворных", kingRating, 0, 100);
        }
        this.courtiersRating = courtiersRating;
    }

    @Override
    public String toString(){
        return String.format("\nБлюдо: %s | Категория: %s\nИнгридиенты: %s\nОценка короля: %d | Оценка придворных: %d",
                getDishName(), getDishCategory(), getDishIngredients(), getKingRating(), getCourtiersRating());
    }
}
