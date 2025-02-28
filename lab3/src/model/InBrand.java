package model;

public class InBrand implements CarActions {
    // Общие поля
    private String brand;
    private int year;
    private double volume;
    private String gearboxType;
    private double baseInsurance;

    // Дополнительное поле для Иномарки – тип комплектации
    private int configurationType;

    public InBrand(String brand, int year, double volume, String gearboxType, double baseInsurance, int configurationType) {
        this.brand = brand;
        this.year = year;
        this.volume = volume;
        this.gearboxType = gearboxType;
        this.baseInsurance = baseInsurance;
        this.configurationType = configurationType;
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
    public int getConfigurationType() {
        return configurationType;
    }
    public void setConfigurationType(int configurationType) {
        this.configurationType = configurationType;
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
        // Формула для Иномарки: baseInsurance + 0.05 * year * volume * configurationType
        return baseInsurance + 0.05 * year * volume * configurationType;
    }

    @Override
    public String toString() {
        return "InBrand [brand=" + brand + ", year=" + year + ", volume=" + volume +
                ", gearboxType=" + gearboxType + ", baseInsurance=" + baseInsurance +
                ", configurationType=" + configurationType +
                ", insurance=" + calculateInsurance() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof InBrand))
            return false;
        InBrand other = (InBrand) obj;
        return brand.equals(other.brand) &&
                year == other.year &&
                Double.compare(volume, other.volume) == 0 &&
                gearboxType.equals(other.gearboxType) &&
                Double.compare(baseInsurance, other.baseInsurance) == 0 &&
                configurationType == other.configurationType;
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
        result = 31 * result + configurationType;
        return result;
    }
}
