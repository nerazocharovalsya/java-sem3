package task3;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PractUI extends JFrame {
    IDocument currentDocument;
    ICreateDocument fabricDocument;

    public PractUI(){
        super("Компания");
        setSize(540,360);

        fabricDocument = new CreateTextDocument();
        currentDocument = fabricDocument.CreateNew("Папка 1", "Документ 1", 90);

        JTextArea textArea = new JTextArea();

        add(textArea);

        JMenuBar menuBarMain = new JMenuBar();
        menuBarMain.setBackground(Color.WHITE);

        JMenu menuFile = new JMenu("Файл");

        JMenuItem itemNew = new JMenuItem("Новый");
        JMenuItem itemOpen = new JMenuItem("Открыть");
        JMenuItem itemSave = new JMenuItem("Сохранить");
        JMenuItem itemExit = new JMenuItem("Закрыть");

        menuFile.add(itemNew);
        menuFile.add(itemOpen);
        menuFile.add(itemSave);
        menuFile.add(itemExit);

        menuBarMain.add(menuFile);
        setJMenuBar(menuBarMain);

        itemNew.addActionListener(e -> {
            textArea.setText("");
            String stDocumentName = JOptionPane.showInputDialog("Введите название документа");
            if (stDocumentName == null) return;
            String stDocumentFolder = JOptionPane.showInputDialog("Введите название папки");
            if (stDocumentFolder == null) return;

            currentDocument = fabricDocument.CreateNew(stDocumentFolder, stDocumentName, new Random().nextInt(1,100));
        });

        itemOpen.addActionListener(e ->{
            String documentName = JOptionPane.showInputDialog("Введите название документа");
            if(documentName == null) return;

            currentDocument = fabricDocument.CreateOpen(documentName);
            textArea.setText(currentDocument.getContent());
        });

        itemSave.addActionListener( e -> {
            JOptionPane.showMessageDialog(getContentPane(), "Документ сохранен");
            currentDocument.setContent(textArea.getText().toString());
        });

        itemExit.addActionListener(e->{
            this.dispose();
        });


        setVisible(true);

    }

    public static void main(String[] args) {
        new PractUI();
    }
}
