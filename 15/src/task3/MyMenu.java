package task3;

import javax.swing.*;

class MyMenu
{
    JMenu menu, smenu;
    JMenuItem e1, e2, e3, e4, e5, e6;

    MyMenu()
    {
        // Create the frame
        JFrame frame = new JFrame("Menu Example");
        // Create the menu bar
        JMenuBar menubar = new JMenuBar();
        // Create menu
        menu = new JMenu("Menu");
        // Create the sub menu
        smenu = new JMenu("Sub menu");
        // Create menu and submenu items
        e1 = new JMenuItem("Item 1");
        e2 = new JMenuItem("Item 2");
        e3 = new JMenuItem("Item 3");
        e4 = new JMenuItem("Item 4");
        e5 = new JMenuItem("Item 5");
        e6 = new JMenuItem("Item 6");
        // Add items to menu
        menu.add(e1);
        menu.add(e2);
        menu.add(e3);
        // Add items to the submenu
        smenu.add(e4);
        smenu.add(e5);
        smenu.add(e6);
        // Add the submenu to the main menu
        menu.add(smenu);
        // Add the menu to the menu bar
        menubar.add(menu);
        // Add the menu bar to the frame
        frame.setJMenuBar(menubar);
        frame.setSize(300,300);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String args[])
    {
        new MyMenu();
    }
}