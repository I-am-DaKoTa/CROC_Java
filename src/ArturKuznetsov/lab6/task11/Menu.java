package ArturKuznetsov.lab6.task11;

import ArturKuznetsov.lab6.task11.exceptions.InvalidDataForMenuException;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Menu {

    public List<Dish> getMenu(Map<Cook, Set<Dish>> mapOfWorkingCooksAndDishes, Set<String> missingIngredients, int amountOfDishes) {
        initialCheck(mapOfWorkingCooksAndDishes, missingIngredients, amountOfDishes);

        Set<Dish> uniqueDishes = getUniqueDishes(mapOfWorkingCooksAndDishes, missingIngredients);

        List<Dish> sortedDishes = getSortedDishes(uniqueDishes);

        // Оставляем только необходимое количество блюд
        if (sortedDishes.size() > amountOfDishes) {
            sortedDishes = sortedDishes.subList(0, amountOfDishes);
        }

        return sortedDishes;
    }

    public List<Dish> getMenuWithRequirements(Map<Cook, Set<Dish>> mapOfWorkingCooksAndDishes, Set<String> missingIngredients, int amountOfDishes, Predicate<Dish> dishRequirements){
        initialCheck(mapOfWorkingCooksAndDishes, missingIngredients, amountOfDishes);
        if (dishRequirements == null) {
            throw new InvalidDataForMenuException("Требования короля не могут быть null");
        }

        Set<Dish> uniqueDishes = getUniqueDishes(mapOfWorkingCooksAndDishes, missingIngredients);

        List<Dish> sortedDishes = getSortedDishes(uniqueDishes);

        // Применяем требования короля к списку блюд
        List<Dish> filteredMenu = sortedDishes.stream()
                .filter(dishRequirements)
                .toList();

        // Оставляем только необходимое количество блюд
        if (filteredMenu.size() > amountOfDishes) {
            filteredMenu = filteredMenu.subList(0, amountOfDishes);
        }

        return filteredMenu;
    }

    private void initialCheck(Map<Cook, Set<Dish>> mapOfWorkingCooksAndDishes, Set<String> missingIngredients, int amountOfDishes) {
        if (amountOfDishes <= 0) {
            throw new InvalidDataForMenuException("Количество блюд должно быть больше 0");
        }
        if (missingIngredients == null) {
            throw new InvalidDataForMenuException("Отсутствующие ингредиенты не могут быть null");
        }
        if (mapOfWorkingCooksAndDishes.isEmpty()) {
            throw new InvalidDataForMenuException("Нет поваров, которые работают в день пира");
        }
    }

    private Set<Dish> getUniqueDishes(Map<Cook, Set<Dish>> mapOfWorkingCooksAndDishes, Set<String> missingIngredients) {
        // Собираем уникальные блюда от всех поваров
        Set<Dish> uniqueDishes = new HashSet<>();
        for (Set<Dish> dishes : mapOfWorkingCooksAndDishes.values()) {
            uniqueDishes.addAll(dishes);
        }

        // Приводим отсутствующие ингредиенты в нижний регистр, чтобы при удалении не было зависимости от регистра
        Set<String> lowerCaseMissingIngredients = missingIngredients.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        // Убираем из списка уникальных блюд те блюда, в которых есть отсутствующие ингредиенты
        uniqueDishes.removeIf(dish -> dish.getDishIngredients().stream()
                .map(String::toLowerCase)
                .anyMatch(lowerCaseMissingIngredients::contains));

        if (uniqueDishes.isEmpty()) {
            throw new InvalidDataForMenuException("Нет блюд, в которых нет отсутствующих ингредиентов");
        }
        return uniqueDishes;
    }

    private List<Dish> getSortedDishes(Set<Dish> uniqueDishes) {
        // Создаём список блюд отсортированных по оценкам
        List<Dish> sortedDishes = new ArrayList<>(uniqueDishes);
        sortedDishes.sort((dish1, dish2) -> {
            if (dish1.getKingRating() != dish2.getKingRating()) {
                return Integer.compare(dish2.getKingRating(), dish1.getKingRating());
            } else {
                return Integer.compare(dish2.getCourtiersRating(), dish1.getCourtiersRating());
            }
        });
        return sortedDishes;
    }
}