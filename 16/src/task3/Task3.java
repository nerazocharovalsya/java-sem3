package task3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task3 extends JFrame {
    JLabel label1 = new JLabel("Service:");
    JLabel label2 = new JLabel("User name:");
    JLabel label3 = new JLabel("Password:");
    JTextField field1 = new JTextField();
    JTextField field2 = new JTextField();
    JTextField field3 = new JTextField();
    JTextField field4 = new JTextField();

    JButton button = new JButton("Sign in");

    public class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(field3.getText().equals("12345")){
                field4.setText("Вход выполнен");
            }
            else {
                field4.setText("Вход НЕ выполнен");            }
        }
    }

    Task3(){
        super("Task 3");
        setLayout(null);
        setSize(250, 210);
        ActionListener actionListener = new TestActionListener();
        button.addActionListener(actionListener);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label1.setBounds(10, 10, 100, 20);
        label2.setBounds(10, 40, 100, 20);
        label3.setBounds(10, 70, 100, 20);
        field1.setBounds(120, 10, 100, 20);
        field2.setBounds(120, 40, 100, 20);
        field3.setBounds(120, 70, 100, 20);
        button.setBounds(30,100,100,20);
        field4.setBounds(10,130,220,20);
        add(label1);
        add(label2);
        add(label3);
        add(field1);
        add(field2);
        add(field3);
        add(button);
        add(field4);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Task3();
    }
}
