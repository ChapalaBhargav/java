import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextDisplayApp {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Text Display App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(null); // Absolute layout

        // Create the text field
        JTextField textField = new JTextField();
        textField.setBounds(10, 10, 260, 30);

        // Create the button
        JButton button = new JButton("Display Text");
        button.setBounds(10, 50, 150, 30);

        // Create the label
        JLabel label = new JLabel("");
        label.setBounds(10, 90, 260, 30);

        // Add action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the text from the text field
                String text = textField.getText();
                // Set the text of the label
                label.setText(text);
            }
        });

        // Add components to the frame
        frame.add(textField);
        frame.add(button);
        frame.add(label);

        // Set the frame visibility
        frame.setVisible(true);
    }
}
