package model;

import javax.swing.*;
import java.awt.*;

public class ParkingSpot extends JPanel {
    private final int spotNumber;
    private Car parkedCar;

    public ParkingSpot(int number) {
        this.spotNumber = number;
        setPreferredSize(new Dimension(120, 180));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.WHITE);
        add(new JLabel("Место #" + number + " (свободно)", SwingConstants.CENTER));
    }

    public boolean isAvailable() {
        return parkedCar == null;
    }

    public void parkCar(Car car) {
        this.parkedCar = car;
        removeAll();
        add(new JLabel("Место #" + spotNumber));
        add(car);
        setBackground(new Color(200, 255, 200));
        revalidate();
        repaint();
    }

    public void release() {
        this.parkedCar = null;
        removeAll();
        add(new JLabel("Место #" + spotNumber + " (свободно)"));
        setBackground(Color.WHITE);
        revalidate();
        repaint();
    }
}
