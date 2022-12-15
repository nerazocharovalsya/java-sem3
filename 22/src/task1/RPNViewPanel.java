package task1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Stack;

public class RPNViewPanel extends JPanel {

    final int PANEL_SIZE = 5;
    JPanel row_value_panel;
    Stack stack;
    DecimalFormat format = null;

    public RPNViewPanel() {
        BorderLayout layout = new BorderLayout();
        layout.setHgap(2);
        setLayout(layout);
        add(createRowLabelPanel(), BorderLayout.WEST);
        add(createRowValuePanel(), BorderLayout.CENTER);

        format = new DecimalFormat("0.######");

        setBorder(new EmptyBorder(4, 4, 2, 4));
    }

    private JPanel createRowLabelPanel() {
        final String ROW_LABELS[] = {
                "5", "4", "3", "2", "1"
        };

        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(PANEL_SIZE, 0);
        layout.setVgap(2);
        panel.setLayout(layout);

        for (int i = 0; i < PANEL_SIZE; i++) {
            JLabel label = new JLabel(ROW_LABELS[i]);
            label.setHorizontalAlignment(JLabel.CENTER);
            panel.add(label);
        }
        return panel;
    }

    private JPanel createRowValuePanel()
    {
        row_value_panel = new JPanel();
        GridLayout layout = new GridLayout(PANEL_SIZE, 0);
        layout.setVgap(2);
        row_value_panel.setLayout(layout);

        for (int i = 0; i < PANEL_SIZE; i++) {
            JTextField field = new JTextField();
            field.setEditable(false);
            field.setHorizontalAlignment(JTextField.RIGHT);
            if (i == (PANEL_SIZE - 1)) {
                Font bold_font = field.getFont().deriveFont(Font.BOLD);
                field.setFont(bold_font);
            }
            row_value_panel.add(field);
        }
        return row_value_panel;
    }
    public void updateView(RPNCalc calc) {
        final int s = calc.getStackHeight();
        for (int i = 0; (i < PANEL_SIZE); i++) {
            JTextField val_field = (JTextField) row_value_panel.getComponent(PANEL_SIZE - 1 - i);
            if (i < s) {
                val_field.setText(calc.getStackEntry(s - 1 - i));
            } else {
                val_field.setText(null);
            }
        }
        repaint();
    }
}
