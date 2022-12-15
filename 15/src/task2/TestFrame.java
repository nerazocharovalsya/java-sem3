package task2;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TestFrame extends JFrame {

    public TestFrame() {

        super("Тестовое окно");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] items = {
                "Австралия",
                "Китай",
                "Россия"
        };

        Container content = getContentPane();

        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        final JLabel label = new JLabel(" ");
        label.setAlignmentX(LEFT_ALIGNMENT);
        content.add(label);

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox box = (JComboBox) e.getSource();
                String item = (String) box.getSelectedItem();
                label.setText(item);
            }
        };

        JComboBox editComboBox = new JComboBox(items);
        editComboBox.setEditable(true);
        editComboBox.setAlignmentX(LEFT_ALIGNMENT);
        editComboBox.addActionListener(actionListener);
        content.add(editComboBox);

        setPreferredSize(new Dimension(240, 130));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                new TestFrame();
            }
        });
    }
}