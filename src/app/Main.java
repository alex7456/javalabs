package app;
import model.Car;
import model.InBrand;
import model.HomeBrand;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Создание объектов различных типов
        Car car1 = new InBrand("BMW", 2020, 3.0, "Automatic", 1000, 2);
        Car car2 = new InBrand("Audi", 2019, 2.5, "Manual", 900, 3);
        Car car3 = new HomeBrand("Lada", 2018, 1.6, "Manual", 500, 10.0);
        Car car4 = new HomeBrand("UAZ", 2021, 2.0, "Automatic", 700, 15.0);
        Car car5 = new InBrand("Mercedes", 2022, 3.5, "Automatic", 1200, 1);
        Car car6 = new HomeBrand("GAZ", 2017, 1.8, "Manual", 450, 8.0);
        Car car7 = new InBrand("Volkswagen", 2016, 2.0, "Manual", 800, 2);
        Car car8 = new HomeBrand("Renault", 2015, 1.4, "Automatic", 550, 5.0);
        Car car9 = new InBrand("Peugeot", 2020, 1.6, "Manual", 600, 3);
        Car car10 = new HomeBrand("KAMAZ", 2014, 4.0, "Manual", 1000, 20.0);
        // Для проверки уникальности создаём дубликат
        Car carDuplicate = new InBrand("BMW", 2020, 3.0, "Automatic", 1000, 2);

        Car[] cars = { car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, carDuplicate };

        // Добавляем в список только уникальные объекты (проверка через equals)
        ArrayList<Car> uniqueCars = new ArrayList<>();
        for (Car car : cars) {
            if (!uniqueCars.contains(car)) {
                uniqueCars.add(car);
            }
        }

        // Вывод информации об объектах и их страховых сборах
        System.out.println("Уникальные автомобили и их страховые сборы:");
        for (Car car : uniqueCars) {
            System.out.println(car.toString());
        }
    }
}