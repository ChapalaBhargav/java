
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class StopWatch extends JFrame implements ActionListener, Runnable {
    private JLabel disp;
    private JButton startBtn;
    private JButton resetBtn;
    private boolean stop = false;
    private boolean running = false;
    private Thread stopwatchThread;
    private int seconds = 0; // Total time in seconds
    private int minutes = 0;
    private int hours = 0;
    private int centiseconds = 0;

    public StopWatch() {
        disp = new JLabel();
        startBtn = new JButton("Start");
        resetBtn = new JButton("Reset");

        disp.setFont(new Font("Helvetica", Font.PLAIN, 40));
        disp.setBackground(Color.cyan);
        disp.setOpaque(true); // Ensure background color is visible
        disp.setForeground(Color.red);
        disp.setHorizontalAlignment(JLabel.CENTER); // Center the text

        // Set smaller size for buttons
        Dimension buttonSize = new Dimension(80, 30); // Width, Height
        startBtn.setPreferredSize(buttonSize);
        resetBtn.setPreferredSize(buttonSize);
        startBtn.setFont(new Font("Helvetica", Font.PLAIN, 12)); // Smaller font for buttons
        resetBtn.setFont(new Font("Helvetica", Font.PLAIN, 12)); // Smaller font for buttons

        // Main container with BorderLayout
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        // Create a panel for the buttons with GridLayout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 10, 10)); // 2 rows, 1 column, gaps of 10 pixels
        buttonPanel.add(startBtn);
        buttonPanel.add(resetBtn);

        // Add components to the container
        c.add(disp, BorderLayout.NORTH); // Timer at the top
        c.add(buttonPanel, BorderLayout.CENTER); // Buttons in the center

        startBtn.addActionListener(this);
        resetBtn.addActionListener(this);

        setTitle("StopWatch");
        setSize(300, 200); // Adjusted size to fit the display and buttons
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on the screen
    }

    @Override
    public void run() {
        while (true) {
            if (stop) {
                running = false;
                startBtn.setText("Start");
                stop = false;
                return;
            }

            try {
                Thread.sleep(10);
                centiseconds++;
                if (centiseconds == 100) {
                    centiseconds = 0;
                    seconds++;
                    if (seconds == 60) {
                        seconds = 0;
                        minutes++;
                        if (minutes == 60) {
                            minutes = 0;
                            hours++;
                        }
                    }
                }
                NumberFormat nf = new DecimalFormat("00");
                disp.setText(nf.format(hours) + ":" + nf.format(minutes) + ":" + nf.format(seconds) + ":" + nf.format(centiseconds));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == startBtn) {
            if (running) {
                stop = true;
            } else {
                if (stopwatchThread != null && stopwatchThread.isAlive()) {
                    stop = true;
                }
                stopwatchThread = new Thread(this);
                stop = false;
                running = true;
                stopwatchThread.start();
                startBtn.setText("Stop");
            }
        } else if (ae.getSource() == resetBtn) {
            stop = true;
            try {
                if (stopwatchThread != null && stopwatchThread.isAlive()) {
                    stopwatchThread.join(); // Wait for the thread to finish
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // Reset stopwatch values
            hours = 0;
            minutes = 0;
            seconds = 0;
            centiseconds = 0;
            NumberFormat nf = new DecimalFormat("00");
            disp.setText(nf.format(hours) + ":" + nf.format(minutes) + ":" + nf.format(seconds) + ":" + nf.format(centiseconds));
            startBtn.setText("Start");
            running = false;
            stop = false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                StopWatch s = new StopWatch();
                s.setVisible(true);
            }
        });
    }
}
