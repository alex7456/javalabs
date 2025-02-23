package model;

public class HomeBrand extends Car {
    private double color;
    public HomeBrand(String brand, int year, double volume, String gearboxType, double baseInsurance, double color) {
        super(brand,year,volume,gearboxType,baseInsurance);
        this.color=color;
    }

    public double getColor() {
        return color;
    }

    public void setColor(double color) {
        this.color = color;
    }
    @Override
    public double calculateInsurance() {
        return getBaseInsurance() + 0.03 * getYear() * getVolume();
    }
    @Override
    public String toString() {
        return super.toString() + ", HomeBrand [colorPercentage=" + color +
                ", insurance=" + calculateInsurance() + "]";
    }
}
