package restaurant;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RestaurantMenu {
    private final List<Dish> menu;

    public RestaurantMenu() {
        this.menu = new ArrayList<>();
    }

    public void addDish(Dish dish) {
        menu.add(dish);
    }

    public Optional<Dish> findDishByName(String name) {
        return menu.stream()
                .filter(dish -> dish.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public List<Dish> filterDishes(Predicate<Dish> predicate) {
        return menu.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public Map<String, List<Dish>> groupAndSortDishes() {
        return menu.stream()
                .collect(Collectors.groupingBy(
                        Dish::getType,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> {
                                    list.sort(
                                            Comparator.comparingDouble(Dish::getPrice)
                                                    .thenComparingInt(Dish::getPreparationTime)
                                    );
                                    return list;
                                }
                        )
                ));
    }
}
