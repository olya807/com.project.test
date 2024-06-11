import javax.swing.*;
import java.awt.event.*;

public class SimpleTextEditor extends JFrame {
    private final JTextArea textArea;

    public SimpleTextEditor() {
        // Создаем текстовую область
        textArea = new JTextArea();
        getContentPane().add(new JScrollPane(textArea));

        // Создаем строку меню
        JMenuBar menuBar = new JMenuBar();

        // Добавляем меню "Файл"
        JMenu menu = new JMenu("Файл");
        menuBar.add(menu);

        // Добавляем пункты меню
        JMenuItem menuItemNew = new JMenuItem("Новый");
        menuItemNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        }
        );
        menu.add(menuItemNew);

        JMenuItem menuItemOpen = new JMenuItem("Открыть");
        // Здесь можно добавить обработчик для открытия файла
        menu.add(menuItemOpen);

        JMenuItem menuItemSave = new JMenuItem("Сохранить");
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
        }
        );
    }
}