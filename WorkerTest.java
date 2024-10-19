import java.util.Scanner;

// Base class Worker
abstract class Worker {
    protected String name;
    protected double salaryRate;

    // Constructor
    public Worker(String name, double salaryRate) {
        this.name = name;
        this.salaryRate = salaryRate;
    }

    // Abstract method to be implemented by subclasses
    public abstract double pay(int hours);

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for salaryRate
    public double getSalaryRate() {
        return salaryRate;
    }
}

// Class DailyWorker inherits from Worker
class DailyWorker extends Worker {
    // Constructor
    public DailyWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    // Implementing the pay method for DailyWorker
    @Override
    public double pay(int hours) {
        // Daily worker gets paid per day worked
        // Assume a fixed 8 hours per day
        return (hours / 8) * salaryRate;
    }
}

// Class SalariedWorker inherits from Worker
class SalariedWorker extends Worker {
    // Constructor
    public SalariedWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    // Implementing the pay method for SalariedWorker
    @Override
    public double pay(int hours) {
        // Salaried worker gets paid for a fixed 40 hours per week
        return 40 * salaryRate;
    }
}

// Test program
public class WorkerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for DailyWorker
        System.out.print("Enter name for DailyWorker: ");
        String dailyWorkerName = scanner.nextLine();
        System.out.print("Enter daily rate for " + dailyWorkerName + ": ");
        double dailyRate = scanner.nextDouble();
        System.out.print("Enter number of hours worked by " + dailyWorkerName + ": ");
        int dailyHoursWorked = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        DailyWorker dailyWorker = new DailyWorker(dailyWorkerName, dailyRate);
        double dailyWorkerPay = dailyWorker.pay(dailyHoursWorked);
        System.out.println(dailyWorker.getName() + " earned: Rs" + dailyWorkerPay);

        // Input for SalariedWorker
        System.out.print("Enter name for SalariedWorker: ");
        String salariedWorkerName = scanner.nextLine();
        System.out.print("Enter hourly rate for " + salariedWorkerName + ": ");
        double hourlyRate = scanner.nextDouble();
        System.out.print("Enter number of hours worked by " + salariedWorkerName + ": ");
        int salariedHoursWorked = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        SalariedWorker salariedWorker = new SalariedWorker(salariedWorkerName, hourlyRate);
        double salariedWorkerPay = salariedWorker.pay(salariedHoursWorked);
        System.out.println(salariedWorker.getName() + " earned: Rs" + salariedWorkerPay);

        // Close the scanner
        scanner.close();
    }
}

