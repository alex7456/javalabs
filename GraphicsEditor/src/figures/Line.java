package figures;
import java.awt.*;

public class Line implements IDrawFigure {
    private int x1, y1, x2, y2;

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3)); // Толщина 3 пикселя
        g.setColor(Color.BLACK);
        g.drawLine(x1, y1, x2, y2);
    }
}
