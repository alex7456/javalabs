package view;

import controller.ParkingController;
import model.ParkingSpot;

import javax.swing.*;
import java.awt.*;

public class ParkingUI extends JFrame {
    private final JPanel parkingPanel = new JPanel();
    private final JPanel waitingPanel = new JPanel();

    public ParkingUI(ParkingController controller) {
        setTitle("Автостоянка");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        parkingPanel.setLayout(new GridLayout(1, 5, 10, 10));
        parkingPanel.setBorder(BorderFactory.createTitledBorder("Парковочные места"));
        parkingPanel.setBackground(new Color(220, 220, 220));

        for (ParkingSpot spot : controller.getParkingSpots()) {
            parkingPanel.add(spot);
        }

        waitingPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        waitingPanel.setBorder(BorderFactory.createTitledBorder("Ожидающие машины"));
        waitingPanel.setBackground(new Color(240, 240, 240));

        controller.setPanels(parkingPanel, waitingPanel);

        JButton addCarButton = new JButton("Добавить машину");
        addCarButton.addActionListener(e -> controller.addNewCar(this));

        add(addCarButton, BorderLayout.NORTH);
        add(parkingPanel, BorderLayout.CENTER);
        add(waitingPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
