import javax.swing.*;
import java.awt.event.*;

public class SimpleTextEditor extends JFrame {
    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItemNew, menuItemOpen, menuItemSave;

    public SimpleTextEditor() {
        // Создаем текстовую область
        textArea = new JTextArea();
        getContentPane().add(new JScrollPane(textArea));

        // Создаем строку меню
        menuBar = new JMenuBar();

        // Добавляем меню "Файл"
        menu = new JMenu("Файл");
        menuBar.add(menu);

        // Добавляем пункты меню
        menuItemNew = new JMenuItem("Новый");
        menuItemNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        menu.add(menuItemNew);

        menuItemOpen = new JMenuItem("Открыть");
        // Здесь можно добавить обработчик для открытия файла
        menu.add(menuItemOpen);

        menuItemSave = new JMenuItem("Сохранить");
        // Здесь можно добавить обработчик для сохранения файла
        menu.add(menuItemSave);

        // Устанавливаем меню для окна
        setJMenuBar(menuBar);

        // Настройки окна
        setTitle("Простой текстовый редактор");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimpleTextEditor().setVisible(true);
            }
        });
    }
}