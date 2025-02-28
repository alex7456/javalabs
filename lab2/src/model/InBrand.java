package model;

public class InBrand extends Car {
    private int ConfigurationType;


    public InBrand(String brand, int year, double volume, String gearboxType, double baseInsurance, int ConfigurationType) {
super(brand,year,volume,gearboxType,baseInsurance);
this.ConfigurationType=ConfigurationType;
    }

    public int getConfigurationType() {
        return ConfigurationType;
    }

    public void setConfigurationType(int configurationType) {
        ConfigurationType = configurationType;
    }
    @Override
    public double calculateInsurance() {
        return getBaseInsurance() + 0.05 * getYear() * getVolume() * ConfigurationType;
    }
    @Override
    public String toString() {
        return super.toString() + ", InBrand [ConfigurationType=" + ConfigurationType +
                ", insurance=" + calculateInsurance() + "]";
    }
}
