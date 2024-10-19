import java.util.Scanner;

abstract class Course {
    private String name;
    private double fee;
    private Employee[] employeesRegistered;
    private int numEmployees;
    private boolean isOnline;
    private boolean isFullTime;

    public Course(String name, double fee, int maxEmployees, boolean isOnline, boolean isFullTime) {
        this.name = name;
        this.fee = fee;
        this.employeesRegistered = new Employee[maxEmployees];
        this.numEmployees = 0;
        this.isOnline = isOnline;
        this.isFullTime = isFullTime;
    }

    public String getName() {
        return name;
    }

    public double getFee() {
        return fee;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public void registerEmployee(Employee employee) {
        if (numEmployees < employeesRegistered.length) {
            employeesRegistered[numEmployees++] = employee;
        } else {
            System.out.println("Cannot register more employees. Course is full.");
        }
    }

    public Employee[] getEmployeesRegistered() {
        Employee[] registeredEmployees = new Employee[numEmployees];
        System.arraycopy(employeesRegistered, 0, registeredEmployees, 0, numEmployees);
        return registeredEmployees;
    }

    public String[] listEmployees() {
        String[] employeeNames = new String[numEmployees];
        for (int i = 0; i < numEmployees; i++) {
            employeeNames[i] = employeesRegistered[i].getName();
        }
        return employeeNames;
    }

    @Override
    public String toString() {
        return "Course{name='" + name + "', fee=" + fee + ", online=" + isOnline + ", fullTime=" + isFullTime + "}";
    }
}

class ConcreteCourse extends Course {
    public ConcreteCourse(String name, double fee, int maxEmployees, boolean isOnline, boolean isFullTime) {
        super(name, fee, maxEmployees, isOnline, isFullTime);
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class CourseCoordinator {
    private Course[] courses;
    private int numCourses;

    public CourseCoordinator(int maxCourses) {
        this.courses = new Course[maxCourses];
        this.numCourses = 0;
    }

    public void addCourse(Course course) {
        if (numCourses < courses.length) {
            courses[numCourses++] = course;
        } else {
            System.out.println("Cannot add more courses. Coordinator is full.");
        }
    }

    public void registerEmployee(String courseName, Employee employee) {
        Course course = findCourseByName(courseName);
        if (course != null) {
            course.registerEmployee(employee);
        } else {
            System.out.println("Course " + courseName + " not found.");
        }
    }

    public String[] listEmployeesForCourse(String courseName) {
        Course course = findCourseByName(courseName);
        if (course != null) {
            return course.listEmployees();
        } else {
            System.out.println("Course " + courseName + " not found.");
            return new String[0];
        }
    }

    private Course findCourseByName(String courseName) {
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].getName().equalsIgnoreCase(courseName)) {
                return courses[i];
            }
        }
        return null;
    }
}

public class coursemanageMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseCoordinator coordinator = new CourseCoordinator(10);

        while (true) {
            try {
                System.out.println("\n1. Add Course");
                System.out.println("2. Register Employee");
                System.out.println("3. List Employees for Course");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1:
                        System.out.print("Enter course name: ");
                        String courseName = scanner.nextLine();
                        System.out.print("Enter course fee: ");
                        double fee = Double.parseDouble(scanner.nextLine().trim());
                        System.out.print("Enter maximum number of employees: ");
                        int maxEmployees = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Is the course online? (true/false): ");
                        boolean isOnline = Boolean.parseBoolean(scanner.nextLine().trim());
                        System.out.print("Is the course full-time? (true/false): ");
                        boolean isFullTime = Boolean.parseBoolean(scanner.nextLine().trim());

                        Course course = new ConcreteCourse(courseName, fee, maxEmployees, isOnline, isFullTime);
                        coordinator.addCourse(course);
                        System.out.println("Course added successfully!");
                        break;

                    case 2:
                        System.out.print("Enter course name to register: ");
                        String regCourseName = scanner.nextLine();
                        System.out.print("Enter employee name: ");
                        String employeeName = scanner.nextLine();

                        Employee employee = new Employee(employeeName);
                        coordinator.registerEmployee(regCourseName, employee);
                        System.out.println("Employee registered successfully!");
                        break;

                    case 3:
                        System.out.print("Enter course name to list employees: ");
                        String listCourseName = scanner.nextLine();

                        String[] employees = coordinator.listEmployeesForCourse(listCourseName);
                        System.out.println("Employees registered for " + listCourseName + ":");
                        if (employees.length == 0) {
                            System.out.println("No employees registered.");
                        } else {
                            for (String emp : employees) {
                                System.out.println(emp);
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numeric values where required.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}

