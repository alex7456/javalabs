package controller;

import model.Car;
import model.ParkingSpot;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingController {
    private static final int MAX_WAIT_TIME = 3000;
    private final AtomicInteger carCounter = new AtomicInteger(1);
    private final List<ParkingSpot> parkingSpots = new ArrayList<>();
    private JPanel parkingPanel;
    private JPanel waitingPanel;

    public ParkingController() {
        for (int i = 0; i < 5; i++) {
            parkingSpots.add(new ParkingSpot(i + 1));
        }
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setPanels(JPanel parkingPanel, JPanel waitingPanel) {
        this.parkingPanel = parkingPanel;
        this.waitingPanel = waitingPanel;
    }

    public void addNewCar(JFrame parentFrame) {
        int carNumber = carCounter.getAndIncrement();
        new Thread(() -> {
            Car car = new Car(carNumber);
            SwingUtilities.invokeLater(() -> {
                waitingPanel.add(car);
                waitingPanel.revalidate();
                waitingPanel.repaint();
            });

            long startTime = System.currentTimeMillis();
            boolean parked = false;

            while (!parked && (System.currentTimeMillis() - startTime) < MAX_WAIT_TIME) {
                synchronized (parkingSpots) {
                    for (ParkingSpot spot : parkingSpots) {
                        if (spot.isAvailable()) {
                            spot.parkCar(car);
                            parked = true;
                            SwingUtilities.invokeLater(() -> {
                                waitingPanel.remove(car);
                                waitingPanel.revalidate();
                                waitingPanel.repaint();
                                parkingPanel.revalidate();
                                parkingPanel.repaint();
                            });

                            new Thread(() -> {
                                try {
                                    Thread.sleep((long) (Math.random() * 10000 + 3000));
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                                synchronized (parkingSpots) {
                                    spot.release();
                                    SwingUtilities.invokeLater(() -> {
                                        parkingPanel.revalidate();
                                        parkingPanel.repaint();
                                    });
                                    parkingSpots.notifyAll();
                                }
                            }).start();

                            break;
                        }
                    }
                }

                if (!parked) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }

            if (!parked) {
                SwingUtilities.invokeLater(() -> {
                    waitingPanel.remove(car);
                    waitingPanel.revalidate();
                    waitingPanel.repaint();
                    JOptionPane.showMessageDialog(parentFrame,
                            "Машина #" + carNumber + " не дождалась и уехала",
                            "Информация", JOptionPane.INFORMATION_MESSAGE);
                });
            }
        }).start();
    }
}
