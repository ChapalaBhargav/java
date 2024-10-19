import mca.Student; // Import the Student class from the mca package

public class main1 {
    public static void main(String[] args) {
        // Sample data for student marks (assuming 5 subjects)
        int[] marks = {75, 94, 88, 92, 88}; 

        // Create a Student object with example data
        Student student = new Student("Ahem", 101, marks);
        
        // Display the student details
        student.display();
    }
}
