import javax.swing.*;
import java.awt.*;

public class GridLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridLayout Example");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3, 5, 5)); // 3 строки, 3 столбца, промежутки 5 пикселей

        for (int i = 1; i <= 9; i++) {
            panel.add(new JButton("Кнопка " + i));
        }

        frame.add(panel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
