package app;

import model.CarActions;
import model.InBrand;
import model.HomeBrand;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Создаем объекты разных типов, реализующих интерфейс CarActions
        CarActions car1 = new InBrand("BMW", 2020, 3.0, "Automatic", 1000, 2);
        CarActions car2 = new InBrand("Audi", 2019, 2.5, "Manual", 900, 3);
        CarActions car3 = new HomeBrand("Lada", 2018, 1.6, "Manual", 500, 10.0);
        CarActions car4 = new HomeBrand("UAZ", 2021, 2.0, "Automatic", 700, 15.0);
        CarActions car5 = new InBrand("Mercedes", 2022, 3.5, "Automatic", 1200, 1);
        CarActions car6 = new HomeBrand("GAZ", 2017, 1.8, "Manual", 450, 8.0);
        CarActions car7 = new InBrand("Volkswagen", 2016, 2.0, "Manual", 800, 2);
        CarActions car8 = new HomeBrand("Renault", 2015, 1.4, "Automatic", 550, 5.0);
        CarActions car9 = new InBrand("Peugeot", 2020, 1.6, "Manual", 600, 3);
        CarActions car10 = new HomeBrand("KAMAZ", 2014, 4.0, "Manual", 1000, 20.0);
        // Создаем дубликат для проверки уникальности
        CarActions duplicateCar = new InBrand("BMW", 2020, 3.0, "Automatic", 1000, 2);

        CarActions[] cars = { car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, duplicateCar };

        // Добавляем в список только уникальные объекты (проверка через equals)
        ArrayList<CarActions> uniqueCars = new ArrayList<>();
        for (CarActions car : cars) {
            if (!uniqueCars.contains(car)) {
                uniqueCars.add(car);
            }
        }

        // Вывод информации об объектах и их страховых сборах
        System.out.println("Уникальные автомобили и их страховые сборы:");
        for (CarActions car : uniqueCars) {
            System.out.println(car.toString());
        }
    }
}
