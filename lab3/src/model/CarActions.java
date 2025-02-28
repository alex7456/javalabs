package model;

public interface CarActions {
    // Методы для управления состоянием автомобиля
    void stat();
    void stop();
    void inConditioner();
    void outConditioner();

    // Метод расчёта страхового сбора
    double calculateInsurance();
}
