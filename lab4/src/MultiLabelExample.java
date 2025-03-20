import javax.swing.*;
import java.awt.*;

public class MultiLabelExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Много меток");
        frame.setLayout(new FlowLayout()); // Менеджер компоновки
        JLabel label1 = new JLabel("Метка 1");
        JLabel label2 = new JLabel("Метка 2");
        JLabel label3 = new JLabel("Метка 3");
        JLabel label4 = new JLabel("Метка 4");

        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);

        frame.setSize(400, 200);
        frame.setLocation(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
