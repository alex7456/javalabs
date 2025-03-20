package ui;

import figures.IDrawFigure;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel {
    private List<IDrawFigure> figures = new ArrayList<>();

    public void addFigure(IDrawFigure figure) {
        figures.add(figure); // Добавляем новую фигуру в список
        repaint(); // Перерисовываем весь холст
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (IDrawFigure figure : figures) {
            figure.draw(g); // Рисуем все фигуры, которые были добавлены
        }
    }
}
