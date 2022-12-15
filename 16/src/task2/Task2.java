package task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task2 extends JFrame {
    JTextArea jta = new JTextArea("Пример текста");
    JMenu menuFile = new JMenu("Цвет");
    JMenu menuEdit = new JMenu("Шрифт");
    JMenuBar m1 = new JMenuBar();
    JMenuItem blue = new JMenuItem("Синий");
    JMenuItem red = new JMenuItem("Красный");
    JMenuItem black = new JMenuItem("Черный");
    JMenuItem tnr = new JMenuItem("Times New Roman");
    JMenuItem sans = new JMenuItem("MS Sans Serif");
    JMenuItem courier = new JMenuItem("Courier New");
    Task2(){
        super("Второе задание");
        setLayout(new FlowLayout());
        setSize(300, 150);
        jta.setEditable(false);
        add(jta);
        black.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.setForeground(Color.BLACK);
            }
        });
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.setForeground(Color.RED);
            }
        });
        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.setForeground(Color.BLUE);
            }
        });
        tnr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.setFont(new Font("Times New Roman", Font.BOLD, 14));
            }
        });
        sans.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.setFont(new Font("MS Sans Serif", Font.BOLD, 14));
            }
        });
        courier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.setFont(new Font("Courier New", Font.BOLD, 14));
            }
        });
        menuFile.add(black);
        menuFile.add(blue);
        menuFile.add(red);
        menuEdit.add(sans);
        menuEdit.add(tnr);
        menuEdit.add(courier);
        m1.add(menuFile);
        m1.add(menuEdit);
        setJMenuBar(m1);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Task2();
    }
}
