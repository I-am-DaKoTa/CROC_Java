package ArturKuznetsov.lab6.task11;

import ArturKuznetsov.lab6.task11.exceptions.CookHasAlreadyBeenHiredException;

import java.time.DayOfWeek;
import java.util.*;

public class CookManager {
    private final Map<Cook, Set<Dish>> mapOfCooksAndDishes = new HashMap<>();

    public void hireCook(Cook cook) {
        if (mapOfCooksAndDishes.containsKey(cook)) {
            throw new CookHasAlreadyBeenHiredException(cook.toString());
        }
        mapOfCooksAndDishes.put(cook, new HashSet<>());
    }

    public void hireCookWithDishes(Cook cook, Set<Dish> dishes) {
        if (mapOfCooksAndDishes.containsKey(cook)) {
            if (mapOfCooksAndDishes.containsKey(cook)) {
                throw new CookHasAlreadyBeenHiredException(cook.toString());
            }
        }
        mapOfCooksAndDishes.put(cook, dishes);
    }

    public void fireCook(Cook cook) {
        mapOfCooksAndDishes.remove(cook);
    }

    public void addDishesToCooks(Set<Dish> dishes, Set<Cook> cooks) {
        for (Cook cook : cooks) {
            if (mapOfCooksAndDishes.containsKey(cook)) {
                Set<Dish> existingDishes = mapOfCooksAndDishes.get(cook);
                Set<Dish> updatedDishes = new HashSet<>(existingDishes);
                updatedDishes.addAll(dishes);
                mapOfCooksAndDishes.put(cook, updatedDishes);
            } else {
                mapOfCooksAndDishes.put(cook, new HashSet<>(dishes));
            }
        }
    }

    public Map<Cook, Set<Dish>> getWorkingCooks(DayOfWeek day) {
        Map<Cook, Set<Dish>> mapOfWorkingCooksAndDishes = new HashMap<>();

        for (Map.Entry<Cook, Set<Dish>> entry : mapOfCooksAndDishes.entrySet()) {
            Cook cook = entry.getKey();
            Set<Dish> dishes = entry.getValue();
            if (cook.isWorking(day)) {
                mapOfWorkingCooksAndDishes.put(cook, dishes);
            }
        }
        return mapOfWorkingCooksAndDishes;
    }
}
