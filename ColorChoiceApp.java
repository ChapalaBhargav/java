import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChoiceApp {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Color Choice App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create the choice (combo box) for color selection
        String[] colors = {"Red", "Green", "Blue", "Yellow", "Orange", "Purple"};
        JComboBox<String> colorComboBox = new JComboBox<>(colors);
        frame.add(colorComboBox, BorderLayout.NORTH);

        // Create a label to display the selected color
        JLabel colorLabel = new JLabel("Selected Color", SwingConstants.CENTER);
        colorLabel.setOpaque(true);
        colorLabel.setBackground(Color.WHITE);
        frame.add(colorLabel, BorderLayout.CENTER);

        // Create a panel for the rectangle
        JPanel rectanglePanel = new JPanel();
        rectanglePanel.setPreferredSize(new Dimension(200, 100));
        rectanglePanel.setBackground(Color.WHITE);
        frame.add(rectanglePanel, BorderLayout.SOUTH);

        // Add action listener to update the label and rectangle when a color is selected
        colorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) colorComboBox.getSelectedItem();
                Color color = switch (selectedColor) {
                    case "Red" -> Color.RED;
                    case "Green" -> Color.GREEN;
                    case "Blue" -> Color.BLUE;
                    case "Yellow" -> Color.YELLOW;
                    case "Orange" -> Color.ORANGE;
                    case "Purple" -> Color.MAGENTA;
                    default -> Color.WHITE;
                };
                
                colorLabel.setText("Selected Color: " + selectedColor);
                colorLabel.setBackground(color);
                rectanglePanel.setBackground(color);
            }
        });

        // Show the frame
        frame.setVisible(true);
    }
}
