package figures;
import java.awt.*;

public class Oval implements IDrawFigure {
    private int x, y, width, height;

    public Oval(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3)); // Толщина 3 пикселя
        g.setColor(Color.RED);
        g.drawOval(x, y, width, height);
    }
}
