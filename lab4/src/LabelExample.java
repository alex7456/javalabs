import javax.swing.*;

public class LabelExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Пример JLabel");
        JLabel label = new JLabel("Я метка 1"); // измененный текст метки
        frame.setSize(300, 200);
        frame.setLocation(500, 200);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
