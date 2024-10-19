import java.awt.*;
import javax.swing.*;

public class ShapeDrawer extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw and fill a rectangle
        g.setColor(Color.RED);
        g.fillRect(50, 50, 200, 100);

        // Draw and fill an oval
        g.setColor(Color.GREEN);
        g.fillOval(300, 50, 200, 100);

        // Draw and fill a rounded rectangle
        g.setColor(Color.BLUE);
        g.fillRoundRect(550, 50, 200, 100, 30, 30);

        // Draw and fill a polygon (triangle)
        g.setColor(Color.ORANGE);
        int[] xPoints = {50, 150, 250};
        int[] yPoints = {200, 100, 200};
        g.fillPolygon(xPoints, yPoints, 3);

        // Draw and fill an arc
        g.setColor(Color.MAGENTA);
        g.fillArc(300, 200, 200, 100, 0, 180);  // Draw an arc from 0 to 180 degrees
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Shape Drawer");
        ShapeDrawer panel = new ShapeDrawer();
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
