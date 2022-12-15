package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RPN extends JFrame {
    RPNPanel rpn_panel = null;

    public RPN() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("RPN Calculator");

        Container cp = getContentPane();
        rpn_panel = new RPNPanel();
        cp.add(rpn_panel);

        addWindowFocusListener(new WindowAdapter() {
            public void WindowGainedFocus(WindowEvent e) {
                rpn_panel.requestFocusInWindow();
            }
        });

        pack();
        setVisible(true);
    }




    static public void main(String[] args) {
        RPN app = new RPN();
    }
}