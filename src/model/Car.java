package model;

public class Car {
    private String brand;
    private int year;
    private double volume;
    private String gearboxType;
    private double baseInsurance;

    public Car(String brand, int year, double volume, String gearboxType, double baseInsurance){
        this.brand = brand;
        this.year = year;
        this.volume = volume;
        this.gearboxType = gearboxType;
        this.baseInsurance = baseInsurance;
    }

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

    public double getBaseInsurance() {
        return baseInsurance;
    }

    public void setBaseInsurance(double baseInsurance) {
        this.baseInsurance = baseInsurance;
    }

    public String getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(String gearboxType) {
        this.gearboxType = gearboxType;
    }
    public void stat() { System.out.println("Автомобиль в рабочем состоянии."); }
    public void stop() { System.out.println("Автомобиль остановлен."); }
    public void in_conditioner() { System.out.println("Кондиционер включен."); }
    public void out_conditioner() { System.out.println("Кондиционер выключен."); }

    public double calculateInsurance() {
        return baseInsurance;
    }
    @Override
    public String toString() {
        return "Car [brand=" + brand + ", year=" + year + ", volume=" + volume +
                ", gearboxType=" + gearboxType + ", baseInsurance=" + baseInsurance + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Car)) return false;
        Car other = (Car) obj;
        return brand.equals(other.brand) && year == other.year &&
                Double.compare(volume, other.volume) == 0 &&
                gearboxType.equals(other.gearboxType) &&
                Double.compare(baseInsurance, other.baseInsurance) == 0;
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
        return result;
    }




}
