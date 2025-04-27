package restaurant;

public class Dish {
    private String name;
    private String type; // Вегетарианское, Мясное, Рыбное и т.д.
    private double price;
    private int preparationTime; // в минутах

    public Dish(String name, String type, double price, int preparationTime) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.preparationTime = preparationTime;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %.2f руб, %d мин", name, type, price, preparationTime);
    }
}
