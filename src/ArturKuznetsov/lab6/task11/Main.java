package ArturKuznetsov.lab6.task11;

import ArturKuznetsov.lab6.task11.enums.DishCategory;

import java.time.DayOfWeek;
import java.util.Set;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Список блюд
        Dish shchi = new Dish("Щи",
                Set.of("Свинина", "Капуста", "Картофель", "Морковь", "Лук", "Томатная паста", "Вода", "Соль", "Перец"),
                DishCategory.FIRST_COURSE, 67, 71);
        Dish borsch = new Dish("Борщ",
                Set.of("Говядина", "Капуста", "Картофель", "Морковь", "Лук", "Томатная паста", "Свёкла", "Вода", "Соль", "Перец"),
                DishCategory.FIRST_COURSE, 83, 79);
        Dish beefStroganoff = new Dish("Бефстроганов",
                Set.of("Говядина", "Грибы", "Корнишоны", "Сливки", "Сметана", "Чабрец", "Соль", "Перец"),
                DishCategory.MAIN_COURSE, 14, 100);
        Dish chickenKiev = new Dish("Котлеты по-киевски",
                Set.of("Куриное филе", "Масло сливочное", "Мука", "Сухари панировочные", "Яйца", "Чеснок", "Укроп свежий", "Масло растительное", "Соль", "Перец"),
                DishCategory.MAIN_COURSE, 50, 50);
        Dish standardSalad = new Dish("Салат",
                Set.of("Помидоры", "Огурцы", "Сметана", "Соль"),
                DishCategory.SALAD, 75, 71);
        Dish raspberryJam = new Dish("Малиновое варенье",
                Set.of("Малина", "Сахар"),
                DishCategory.DESSERT, 36, 66);
        Dish pancakes = new Dish("Блины",
                Set.of("Молоко", "Яйца", "Мука", "Масло сливочное", "Сахар", "Соль"),
                DishCategory.DESSERT, 95, 93);
        Dish kvass = new Dish("Квас",
                Set.of("Хлеб", "Вода", "Сахар", "Дрожжи"),
                DishCategory.DRINK, 89, 79);
        Dish pelmeni = new Dish("Пельмени",
                Set.of("Фарш домашний", "Лук", "Соль", "Перец", "Мука", "Вода"),
                DishCategory.MAIN_COURSE, 60, 80);
        Dish golubtsy = new Dish("Голубцы",
                Set.of("Капуста", "Фарш говяжий", "Рис", "Лук", "Морковь", "Соль", "Перец", "Томатный соус"),
                DishCategory.MAIN_COURSE, 90, 75);
        Dish syrniki = new Dish("Сырники",
                Set.of("Творог", "Яйца", "Сахар", "Мука", "Сметана", "Соль"),
                DishCategory.DESSERT, 45, 85);
        Dish ukha = new Dish("Уха",
                Set.of("Рыба", "Картофель", "Лук", "Морковь", "Лавровый лист", "Укроп", "Соль", "Перец", "Вода"),
                DishCategory.FIRST_COURSE, 55, 90);
        Dish olivieSalad = new Dish("Салат Оливье",
                Set.of("Картофель", "Морковь", "Горошек консервированный", "Огурцы маринованные", "Яйца", "Колбаса вареная", "Майонез", "Соль", "Перец"),
                DishCategory.SALAD, 70, 78);
        Dish medovik = new Dish("Медовик",
                Set.of("Мед", "Мука", "Сахар", "Сметана", "Яйца", "Масло сливочное", "Сода", "Ваниль"),
                DishCategory.DESSERT, 92, 88);
        Dish okroshka = new Dish("Окрошка",
                Set.of("Квас", "Картофель", "Огурцы", "Колбаса вареная", "Редис", "Яйца", "Зелень", "Сметана", "Соль", "Перец"),
                DishCategory.FIRST_COURSE, 40, 82);
        Dish shashlik = new Dish("Шашлык из свинины",
                Set.of("Свинина", "Лук", "Масло растительное", "Уксус", "Соль", "Перец", "Лавровый лист"),
                DishCategory.MAIN_COURSE, 70, 85);
        Dish sirnayaZapekanka = new Dish("Сырная запеканка",
                Set.of("Творог", "Яйца", "Манная крупа", "Сахар", "Сметана", "Ваниль", "Масло сливочное"),
                DishCategory.DESSERT, 55, 90);


        // Список поваров
        Cook paulBocuse = new Cook("Поль Бокюз", Set.of(DayOfWeek.SUNDAY, DayOfWeek.WEDNESDAY, DayOfWeek.SATURDAY));
        Cook gorgonRamsay = new Cook("Гордон Рамзи", Set.of(DayOfWeek.MONDAY, DayOfWeek.THURSDAY));
        Cook jamieOliver = new Cook("Джейми Оливер", Set.of(DayOfWeek.SUNDAY, DayOfWeek.TUESDAY, DayOfWeek.FRIDAY));
        Cook konstantinIvlev = new Cook("Константин Ивлев", Set.of(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.SATURDAY));

        // Менеджер
        CookManager manager = new CookManager();

        // Нанимаем поваров
        manager.hireCookWithDishes(paulBocuse, Set.of(shchi, borsch, standardSalad, pelmeni, medovik, golubtsy, ukha));
        manager.hireCookWithDishes(gorgonRamsay, Set.of(beefStroganoff, chickenKiev, raspberryJam, pelmeni, okroshka, syrniki, ukha));
        manager.hireCookWithDishes(jamieOliver, Set.of(pancakes, borsch, raspberryJam, pelmeni, shashlik, golubtsy, olivieSalad));
        manager.hireCookWithDishes(konstantinIvlev, Set.of(kvass, chickenKiev, standardSalad, pelmeni,sirnayaZapekanka, syrniki, olivieSalad));

        // Выбираем только тех поваров, который работают во вторник
        var workingCooksMonday = manager.getWorkingCooks(DayOfWeek.MONDAY);
        Menu menu = new Menu();

        System.out.println("Меню из 5 блюд");
        var menu1 = menu.getMenu(workingCooksMonday, Set.of(""), 5);
        System.out.println(menu1);
        System.out.println("============================================================");

        System.out.println("Меню из 4 блюд, но закончился картофель");
        var menu2 = menu.getMenu(workingCooksMonday, Set.of("Картофель"), 4);
        System.out.println(menu2);
        System.out.println("============================================================");

        System.out.println("Меню из 3 блюд, которые начинаются на \"С\"");
        Predicate<Dish> dishRequirements1 = dish -> dish.getDishName().startsWith("С");
        var menuWithRequirements1 = menu.getMenuWithRequirements(workingCooksMonday, Set.of(""), 3, dishRequirements1);
        System.out.println(menuWithRequirements1);
        System.out.println("============================================================");

        System.out.println("Меню из 2 блюд, в которых есть Картофель");
        Predicate<Dish> dishRequirements2 = dish -> dish.getDishIngredients().contains("Картофель");
        var menuWithRequirements2 = menu.getMenuWithRequirements(workingCooksMonday, Set.of(""), 2, dishRequirements2);
        System.out.println(menuWithRequirements2);
        System.out.println("============================================================");

        System.out.println("Меню из 1 горячего блюда");
        Predicate<Dish> dishRequirements3 = dish -> dish.getDishCategory().equals(DishCategory.MAIN_COURSE);
        var menuWithRequirements3 = menu.getMenuWithRequirements(workingCooksMonday, Set.of(""), 1, dishRequirements3);
        System.out.println(menuWithRequirements3);
        System.out.println("============================================================");

        // Добавляем новые блюда поварам
        Dish medovukha = new Dish("Медовуха",
                Set.of("Мед", "Вода", "Дрожжи", "Лимон", "Пряности"),
                DishCategory.DRINK, 14, 87);
        Dish sbiten = new Dish("Сбитень",
                Set.of("Мед", "Пряности", "Вода"),
                DishCategory.DRINK, 50, 80);
        Dish ryazhenka = new Dish("Ряженка",
                Set.of("Молоко", "Молочный грибок"),
                DishCategory.DRINK, 73, 90);
        Dish mors = new Dish("Клюквенный морс",
                Set.of("Клювка", "Сахар", "Вода"),
                DishCategory.DRINK, 99, 75);
        manager.addDishesToCooks(Set.of(medovukha, sbiten, ryazhenka, mors), Set.of(paulBocuse, gorgonRamsay, jamieOliver, konstantinIvlev));
        var workingCooksFriday = manager.getWorkingCooks(DayOfWeek.FRIDAY);

        System.out.println("Меню из 3 напитков");
        Predicate<Dish> dishRequirements4 = dish -> dish.getDishCategory().equals(DishCategory.DRINK);
        var menuWithRequirements4 = menu.getMenuWithRequirements(workingCooksFriday, Set.of(""), 3, dishRequirements4);
        System.out.println(menuWithRequirements4);
        System.out.println("============================================================");
    }
}
