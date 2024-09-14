import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class AnalogClockFrame extends JFrame implements Runnable {

    private Thread clockThread = null;

    public AnalogClockFrame() {
        setTitle("Analog Clock");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.white);
        setVisible(true);
        
        // Start the clock thread
        clockThread = new Thread(this);
        clockThread.start();
    }

    @Override
    public void run() {
        while (clockThread != null) {
            repaint(); // Request a redraw
            try {
                Thread.sleep(1000); // Pause for 1 second
            } catch (InterruptedException e) {
                // Handle the exception
                Thread.currentThread().interrupt(); // Restore interrupt status
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Ensure the background is cleared

        Calendar now = Calendar.getInstance();
        int hours = now.get(Calendar.HOUR_OF_DAY);
        int minutes = now.get(Calendar.MINUTE);
        int seconds = now.get(Calendar.SECOND);

        // Convert 24-hour time to 12-hour format for display
        if (hours > 12) {
            hours -= 12;
        }

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = Math.min(centerX, centerY) - 50;

        // Draw the circle for the clock
        g.setColor(Color.black);
        g.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

        // Draw the numbers on the clock
        for (int i = 1; i <= 12; i++) {
            int x = (int) (centerX + radius * 0.8 * Math.sin(i * Math.PI / 6));
            int y = (int) (centerY - radius * 0.8 * Math.cos(i * Math.PI / 6));
            g.drawString(String.valueOf(i), x - 8, y + 5); // Adjust position to center the text
        }

        // Calculate the angles for the hands
        double secondAngle = seconds * Math.PI / 30;
        double minuteAngle = (minutes + seconds / 60.0) * Math.PI / 30;
        double hourAngle = (hours + minutes / 60.0) * Math.PI / 6;

        // Draw the hour hand
        drawHand(g, centerX, centerY, hourAngle, radius * 0.5, 8);

        // Draw the minute hand
        drawHand(g, centerX, centerY, minuteAngle, radius * 0.7, 6);

        // Draw the second hand
        g.setColor(Color.red);
        drawHand(g, centerX, centerY, secondAngle, radius * 0.9, 2);
    }

    private void drawHand(Graphics g, int x, int y, double angle, double length, int width) {
        int xEnd = (int) (x + length * Math.sin(angle));
        int yEnd = (int) (y - length * Math.cos(angle));
        g.setColor(Color.black); // Set color for hands
        g.drawLine(x, y, xEnd, yEnd); // Draw hand
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AnalogClockFrame());
    }
}
