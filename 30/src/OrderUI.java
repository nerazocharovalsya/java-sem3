import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OrderUI extends JFrame {

    TableOrdersManager tableOrderManager = new TableOrdersManager(32);
    InternetOrdersManager internetTableManager = new InternetOrdersManager();

    Order currentInternetOrder = new InternetOrder();
    Order currentTableOrder = new TableOrder();

    int SelectedTable = -1;


    OrderUI(){
        super("Задание №30");

        setSize(new Dimension(500,300));

        setLayout(new GridLayout(3,3));

        JTextArea currentOrderText = new JTextArea("Заказ: ");
        currentOrderText.setEditable(false);

        JTextArea allOrdersText = new JTextArea("Заказы: ");
        allOrdersText.setEditable(false);

        Map<String,Dish> dishesForOrder = new HashMap<>();
        dishesForOrder.put("Пельмешки", new Dish("Пельмешки", "со сметаной", 300));
        dishesForOrder.put("Картошечка", new Dish("Картошечка", "жареная", 400));
        dishesForOrder.put("Шашлычок", new Dish("Шашлычок", "свиной", 500));
        dishesForOrder.put("Котлетка", new Dish("Котлетка", "куриная", 300));
        dishesForOrder.put("Салатик", new Dish("Салатик", "оливьешка", 200));
        dishesForOrder.put("Супчик", new Dish("Супчик", "вкусный", 300));
        dishesForOrder.put("Макарошки", new Dish("Макарошки", "с сосиками", 400));

        Map<String, Drink> drinksForOrder = new HashMap<>();
        drinksForOrder.put("Водка", new Drink("Водка", "алкогольный напиток", 500, DrinkTypeEnum.VODKA,40));
        drinksForOrder.put("Вода", new Drink("Вода", "негазированная", 100, DrinkTypeEnum.WATER, 0));
        drinksForOrder.put("Чай", new Drink("Чай", "черный", 300, DrinkTypeEnum.TEA, 0));
        drinksForOrder.put("Вино", new Drink("Вино", "красное полусладкое", 500, DrinkTypeEnum.TEA, 20));
        drinksForOrder.put("Сок", new Drink("Сок", "апельсиновый", 200, DrinkTypeEnum.TEA, 0));
        drinksForOrder.put("Лимонад", new Drink("Лимонад", "буратино", 300, DrinkTypeEnum.TEA, 0));
        drinksForOrder.put("Морс", new Drink("Морс", "черничный", 300, DrinkTypeEnum.TEA, 0));

        JComboBox dishesOrderComboBox = new JComboBox(dishesForOrder.keySet().toArray());
        dishesOrderComboBox.setMaximumSize(new Dimension(200,200));
        dishesOrderComboBox.setBackground(Color.white);

        JComboBox drinksOrderComboBox = new JComboBox(drinksForOrder.keySet().toArray());
        drinksOrderComboBox.setMaximumSize(new Dimension(200,200));
        drinksOrderComboBox.setBackground(Color.white);

        JButton btnCreateOrder = new JButton("Добавить заказ");

        JRadioButton btnInternetOrder = new JRadioButton("Интернет заказ");
        btnInternetOrder.setSelected(true);
        JRadioButton btnTableOrder = new JRadioButton("Заказ к столику");
        btnTableOrder.setSelected(false);
        ButtonGroup chooseType = new ButtonGroup();
        chooseType.add(btnTableOrder);
        chooseType.add(btnInternetOrder);

        JComboBox tables = new JComboBox(Arrays.toString(tableOrderManager.freeTableNumbers()).split("[\\[\\]]")[1].split(", "));
        tables.setVisible(false);
        tables.setBackground(Color.white);

        add(btnInternetOrder);
        add(tables);
        add(btnTableOrder);
        add(currentOrderText);
        add(btnCreateOrder);
        add(allOrdersText);
        add(dishesOrderComboBox);
        add(new JTextField());
        add(drinksOrderComboBox);

        tables.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String option = (String) ((JComboBox) e.getSource()).getSelectedItem();
                SelectedTable = Integer.parseInt(option );
            }
        });
        btnTableOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tables.setVisible(true);
                currentInternetOrder = new InternetOrder();
                currentOrderText.setText("Заказ: ");
            }
        });

        btnInternetOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tables.setVisible(false);
                currentTableOrder = new TableOrder();
                currentOrderText.setText("Заказ: ");
            }
        });

        dishesOrderComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String option = ((JComboBox)e.getSource()).getSelectedItem().toString();
                if (btnTableOrder.isSelected())
                    currentTableOrder.add(dishesForOrder.get(option));
                else
                    currentInternetOrder.add(dishesForOrder.get(option));

                currentOrderText.append("\n" + dishesForOrder.get(option));
            }
        });

        drinksOrderComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String option = ((JComboBox)e.getSource()).getSelectedItem().toString();
                if (btnTableOrder.isSelected())
                    currentTableOrder.add(drinksForOrder.get(option));
                else
                    currentInternetOrder.add(drinksForOrder.get(option));

                currentOrderText.append("\n" + drinksForOrder.get(option));
            }
        });



        btnCreateOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                currentOrderText.setText("Заказ: ");
                if(currentTableOrder.getItems().size() == 0 && currentInternetOrder.getItems().size() == 0) return;
                if (btnTableOrder.isSelected()){
                    if(SelectedTable == -1) return;
                    tableOrderManager.add(currentTableOrder, SelectedTable);

                    String currentOrder = "\nЗаказ: ";
                    for(MenuItem item : currentTableOrder.getItems()){
                        currentOrder += item  + "\n";
                    }
                    currentOrder += "( " + SelectedTable + " )" +  "\n";
                    allOrdersText.append(currentOrder);
                    currentTableOrder = new TableOrder();
                    SelectedTable = -1;
                }
                else{
                    internetTableManager.add(currentInternetOrder, new Customer("Дима", "Будков", 19, new Address("Moscow", 999999, "Строителей", 23, 6)));
                    String currentOrder = "\nЗаказ: \n";
                    for(MenuItem item : currentInternetOrder.getItems()){
                        currentOrder += item  + "\n";
                    }
                    currentOrder += "\n";
                    allOrdersText.append(currentOrder);
                    currentInternetOrder = new InternetOrder();
                }
            }
        });
    }

    public static void main(String[] args) {
        new OrderUI().setVisible(true);
    }
}