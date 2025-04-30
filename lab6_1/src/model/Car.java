package model;

import javax.swing.*;
import java.awt.*;

public class Car extends JPanel {
    private final int number;
    private final Color color;

    public Car(int number) {
        this.number = number;
        this.color = new Color((int)(Math.random()*200+55), (int)(Math.random()*200+55), (int)(Math.random()*200+55));
        setPreferredSize(new Dimension(100, 60));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(color);
        add(new JLabel("Машина #" + number));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(10, 10, getWidth() - 20, getHeight() - 20);
        g.setColor(Color.BLACK);
        g.drawString("Машина #" + number, 20, 30);
    }
}
