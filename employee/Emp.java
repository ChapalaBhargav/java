package employee;

public class Emp {
    // Declare variables
    private String name;
    private int empId;
    private String category;
    private double basicPay;
    private double hra;
    private double da;
    private double allowance;
    private double pf;
    private double grossPay;
    private double incomeTax;
    private double netPay;

    // Constructor to initialize employee details
    public Emp(String name, int empId, String category, double basicPay, double hra, double da, double allowance) {
        this.name = name;
        this.empId = empId;
        this.category = category;
        this.basicPay = basicPay;
        this.hra = hra;
        this.da = da;
        this.allowance = allowance;
        calculatePay();
    }

    // Method to calculate pay details
    private void calculatePay() {
        grossPay = basicPay + hra + da + allowance;
        pf = 0.12 * basicPay; // Assume PF is 12% of basic pay
        incomeTax = 0.1 * (grossPay - pf); // Assume income tax is 10% of (gross pay - PF)
        netPay = grossPay - pf - incomeTax;
    }

    // Method to display employee information
    public void displayInfo() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + empId);
        System.out.println("Category: " + category);
        System.out.println("Basic Pay: " + basicPay);
        System.out.println("HRA: " + hra);
        System.out.println("DA: " + da);
        System.out.println("Allowance: " + allowance);
        System.out.println("Gross Pay: " + grossPay);
        System.out.println("PF: " + pf);
        System.out.println("Income Tax: " + incomeTax);
        System.out.println("Net Pay: " + netPay);
    }
}
