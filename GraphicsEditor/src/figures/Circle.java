package figures;
import java.awt.*;

public class Circle implements IDrawFigure {
    private int x, y, radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3)); // Толщина 3 пикселя
        g.setColor(Color.BLUE);
        g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }
}
