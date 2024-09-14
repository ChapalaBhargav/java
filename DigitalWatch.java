import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;


public class DigitalWatch extends JFrame {

    JLabel timeLabel;

    SimpleDateFormat timeFormat;

    String time;

    // Constructor to initialize the frame and label

    public DigitalWatch() {

        setTitle("Digital Watch");

        setSize(400, 200);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        

        // Setting the time format

        timeFormat = new SimpleDateFormat("hh:mm:ss a");


        timeLabel = new JLabel();

        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));

        timeLabel.setForeground(Color.BLACK);

        timeLabel.setBackground(Color.WHITE);

        timeLabel.setOpaque(true);


        add(timeLabel);

        setVisible(true);


        // Update the time continuously

        updateTime();

    }


    // Function to update the time every second

    public void updateTime() {

        while (true) {

            time = timeFormat.format(Calendar.getInstance().getTime());

            timeLabel.setText(time);


            try {

                Thread.sleep(1000); // Wait for 1 second

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }


    public static void main(String[] args) {

        new DigitalWatch();

    }

}

