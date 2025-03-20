package ui;

import figures.*;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SimpleGraphicsEditor extends JFrame {
    private DrawPanel drawPanel;
    private JButton circleButton, ovalButton, squareButton, lineButton;
    private Random random = new Random();

    public SimpleGraphicsEditor() {
        setTitle("Графический редактор");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        circleButton = new JButton("Круг");
        ovalButton = new JButton("Овал");
        squareButton = new JButton("Квадрат");
        lineButton = new JButton("Линия");

        buttonPanel.add(circleButton);
        buttonPanel.add(ovalButton);
        buttonPanel.add(squareButton);
        buttonPanel.add(lineButton);

        add(buttonPanel, BorderLayout.NORTH);

        // Добавляем новые фигуры при каждом нажатии
        circleButton.addActionListener(e ->
                drawPanel.addFigure(new Circle(random.nextInt(700), random.nextInt(500), 50))
        );

        ovalButton.addActionListener(e ->
                drawPanel.addFigure(new Oval(random.nextInt(700), random.nextInt(500), 80, 50))
        );

        squareButton.addActionListener(e ->
                drawPanel.addFigure(new Square(random.nextInt(700), random.nextInt(500), 60))
        );

        lineButton.addActionListener(e ->
                drawPanel.addFigure(new Line(random.nextInt(700), random.nextInt(500),
                        random.nextInt(700), random.nextInt(500)))
        );

        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGraphicsEditor();
    }
}
