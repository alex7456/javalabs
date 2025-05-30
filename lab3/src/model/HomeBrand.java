package model;

public class HomeBrand implements CarActions {
    // Общие поля
    private String brand;
    private int year;
    private double volume;
    private String gearboxType;
    private double baseInsurance;

    // Дополнительное поле для HomeBrand – процент цветовых добавок
    private double color;

    public HomeBrand(String brand, int year, double volume, String gearboxType, double baseInsurance, double color) {
        this.brand = brand;
        this.year = year;
        this.volume = volume;
        this.gearboxType = gearboxType;
        this.baseInsurance = baseInsurance;
        this.color = color;
    }

    // Геттеры и сеттеры
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public double getVolume() {
        return volume;
    }
    public void setVolume(double volume) {
        this.volume = volume;
    }
    public String getGearboxType() {
        return gearboxType;
    }
    public void setGearboxType(String gearboxType) {
        this.gearboxType = gearboxType;
    }
    public double getBaseInsurance() {
        return baseInsurance;
    }
    public void setBaseInsurance(double baseInsurance) {
        this.baseInsurance = baseInsurance;
    }
    public double getColor() {
        return color;
    }
    public void setColor(double color) {
        this.color = color;
    }

    // Реализация методов интерфейса CarActions
    @Override
    public void stat() {
        System.out.println("Автомобиль " + brand + " в рабочем состоянии.");
    }

    @Override
    public void stop() {
        System.out.println("Автомобиль " + brand + " остановлен.");
    }

    @Override
    public void inConditioner() {
        System.out.println("Кондиционер включен в " + brand);
    }

    @Override
    public void outConditioner() {
        System.out.println("Кондиционер выключен в " + brand);
    }

    @Override
    public double calculateInsurance() {
        // Формула для HomeBrand: baseInsurance + 0.03 * year * volume
        return baseInsurance + 0.03 * year * volume;
    }

    @Override
    public String toString() {
        return "HomeBrand [brand=" + brand + ", year=" + year + ", volume=" + volume +
                ", gearboxType=" + gearboxType + ", baseInsurance=" + baseInsurance +
                ", color=" + color +
                ", insurance=" + calculateInsurance() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof HomeBrand))
            return false;
        HomeBrand other = (HomeBrand) obj;
        return brand.equals(other.brand) &&
                year == other.year &&
                Double.compare(volume, other.volume) == 0 &&
                gearboxType.equals(other.gearboxType) &&
                Double.compare(baseInsurance, other.baseInsurance) == 0 &&
                Double.compare(color, other.color) == 0;
    }

    @Override
    public int hashCode() {
        int result = brand.hashCode();
        result = 31 * result + year;
        long temp = Double.doubleToLongBits(volume);
        result = 31 * result + (int)(temp ^ (temp >>> 32));
        result = 31 * result + gearboxType.hashCode();
        temp = Double.doubleToLongBits(baseInsurance);
        result = 31 * result + (int)(temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(color);
        result = 31 * result + (int)(temp ^ (temp >>> 32));
        return result;
    }
}
