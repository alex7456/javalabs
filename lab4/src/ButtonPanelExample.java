import javax.swing.*;
import java.awt.*;

public class ButtonPanelExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout Example");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        for (int i = 1; i <= 9; i++) {
            panel.add(new JButton("Кнопка " + i));
        }

        frame.add(panel);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
