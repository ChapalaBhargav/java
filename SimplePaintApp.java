import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class SimplePaintApp extends JPanel {
    private List<Point> points = new ArrayList<>();
    private Color brushColor = Color.BLACK;

    public SimplePaintApp() {
        // Set up mouse listeners for drawing
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Start a new line
                points.add(new Point(e.getX(), e.getY()));
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Add a point for the current drag
                points.add(new Point(e.getX(), e.getY()));
                repaint(); // Request a redraw
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(brushColor);

        // Draw all points stored
        for (int i = 1; i < points.size(); i++) {
            Point p1 = points.get(i - 1);
            Point p2 = points.get(i);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Paint Application");
        SimplePaintApp paintApp = new SimplePaintApp();
        frame.add(paintApp);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
