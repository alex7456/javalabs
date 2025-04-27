package restaurant;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        RestaurantMenu menu = new RestaurantMenu();

        menu.addDish(new Dish("Цезарь", "Вегетарианское", 300.0, 10));
        menu.addDish(new Dish("Борщ", "Мясное", 250.0, 25));
        menu.addDish(new Dish("Стейк", "Мясное", 700.0, 30));
        menu.addDish(new Dish("Салат Греческий", "Вегетарианское", 280.0, 8));
        menu.addDish(new Dish("Запечённый лосось", "Рыбное", 650.0, 20));
        menu.addDish(new Dish("Чизкейк", "Десерт", 200.0, 5));
        menu.addDish(new Dish("Лимонад", "Напитки", 120.0, 2));

        // Поиск блюда
        System.out.println("--- Поиск блюда 'Борщ' ---");
        menu.findDishByName("Борщ")
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Блюдо не найдено")
                );

        // Фильтрация всех вегетарианских блюд
        System.out.println("\n--- Вегетарианские блюда ---");
        List<Dish> vegetarianDishes = menu.filterDishes(
                dish -> dish.getType().equalsIgnoreCase("Вегетарианское")
        );
        vegetarianDishes.forEach(System.out::println);

        // Группировка и сортировка
        System.out.println("\n--- Меню по типам и сортировке ---");
        Map<String, List<Dish>> groupedMenu = menu.groupAndSortDishes();
        for (String type : groupedMenu.keySet()) {
            System.out.println("\nТип: " + type);
            groupedMenu.get(type).forEach(System.out::println);
        }
    }
}
