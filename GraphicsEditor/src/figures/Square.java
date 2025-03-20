package figures;
import java.awt.*;

public class Square implements IDrawFigure {
    private int x, y, size;

    public Square(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3)); // Толщина 3 пикселя
        g.setColor(Color.GREEN);
        g.drawRect(x, y, size, size);
    }
}
