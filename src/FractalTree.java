import javax.swing.*;
import java.awt.*;

public class FractalTree extends JPanel {
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    public FractalTree() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
    }

    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        if (depth == 0) return;
        int x2 = x1 + (int) (Math.cos(angle) * depth * 10.0);
        int y2 = y1 + (int) (Math.sin(angle) * depth * 10.0);
        g.drawLine(x1, y1, x2, y2);
        double ANGLE_STEP = Math.PI / 6;
        drawTree(g, x2, y2, angle - ANGLE_STEP, depth - 1);
        drawTree(g, x2, y2, angle + ANGLE_STEP, depth - 1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.green);
        drawTree(g, WIDTH / 2, HEIGHT, -Math.PI / 2, 10);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Фрактальное Дерево");
            frame.setContentPane(new FractalTree());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}