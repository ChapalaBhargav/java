import employee.Emp; // Import the Emp class from the employee package

public class Emppay {
    public static void main(String[] args) {
        // Create an Emp object with example data
        Emp e = new Emp("Ahem", 101, "Full-Time\\\\", 50000, 10000, 5000, 2000);
        
        // Display the employee's payroll information
        e.displayInfo();
    }
}
