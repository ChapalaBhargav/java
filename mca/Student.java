package mca;

public class Student {
    // Declare variables
    private String name;
    private int rollNumber;
    private int[] marks;
    private int totalMarks;
    private double percentage;

    // Parameterized constructor
    public Student(String name, int rollNumber, int[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
        calculateTotalAndPercentage();
    }

    // Method to calculate total marks and percentage
    private void calculateTotalAndPercentage() {
        totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        percentage = (totalMarks / (double)(marks.length * 100)) * 100;
    }

    // Method to display student details
    public void display() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.print("Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Percentage: " + percentage + "%");
    }
}

