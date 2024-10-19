import java.util.Scanner;

class QuadraticEquationSolver {
    
    // Method to solve the quadratic equation
    public static void solveEquation(double coefficientA, double coefficientB, double coefficientC) {
        // Check if 'a' is zero
        if (coefficientA == 0) {
            System.out.println("This is not a quadratic equation (a cannot be zero).");
            return;
        }
        
        // Calculate the discriminant
        double discriminant = coefficientB * coefficientB - 4 * coefficientA * coefficientC;
        
        if (discriminant > 0) {
            // Two real and distinct roots
            double root1 = (-coefficientB + Math.sqrt(discriminant)) / (2 * coefficientA);
            double root2 = (-coefficientB - Math.sqrt(discriminant)) / (2 * coefficientA);
            System.out.println("The roots are real and distinct.");
            System.out.println("Root 1 = " + root1);
            System.out.println("Root 2 = " + root2);
        } else if (discriminant == 0) {
            // One real root (equal roots)
            double root = -coefficientB / (2 * coefficientA);
            System.out.println("The equation has one real root.");
            System.out.println("Root = " + root);
        } else {
            // Complex roots
            System.out.println("The roots are complex.");
            double realPart = -coefficientB / (2 * coefficientA);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * coefficientA);
            System.out.println("Root 1 = " + realPart + " + " + imaginaryPart + "i");
            System.out.println("Root 2 = " + realPart + " - " + imaginaryPart + "i");
        }
    }

    // Main method to get input from the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // User input for coefficients
        System.out.println("Enter the value of coefficient a:");
        double a = scanner.nextDouble();
        
        System.out.println("Enter the value of coefficient b:");
        double b = scanner.nextDouble();
        
        System.out.println("Enter the value of coefficient c:");
        double c = scanner.nextDouble();
        
        // Call the method to solve the quadratic equation
        solveEquation(a, b, c);
    }
}
