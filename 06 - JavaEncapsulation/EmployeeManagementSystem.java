// Abstract class Employee
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getter and Setter methods (Encapsulation)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateSalary();

    // Concrete method to display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
    }
}

// Interface Department
interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

// FullTimeEmployee subclass
class FullTimeEmployee extends Employee implements Department {
    private String department;

    // Constructor
    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    // Implementing calculateSalary() for Full-Time Employee
    @Override
    public double calculateSalary() {
        return getBaseSalary(); // Full-time salary is fixed (baseSalary)
    }

    // Implementing Department interface methods
    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Full-time Employee works in " + department + " department.";
    }
}

// PartTimeEmployee subclass
class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double hourlyRate;
    private String department;

    // Constructor
    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, hourlyRate * hoursWorked);  // Base salary calculated based on hoursWorked and hourlyRate
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    // Implementing calculateSalary() for Part-Time Employee
    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;  // Part-time salary is based on work hours
    }

    // Implementing Department interface methods
    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Part-time Employee works in " + department + " department.";
    }
}

// Main class to test the Employee Management System
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Create instances of FullTimeEmployee and PartTimeEmployee
        Employee emp1 = new FullTimeEmployee(1, "John Doe", 50000);
        Employee emp2 = new PartTimeEmployee(2, "Jane Smith", 20, 80);  // 80 hours at $20/hour

        // Assign departments to employees
        ((FullTimeEmployee) emp1).assignDepartment("HR");
        ((PartTimeEmployee) emp2).assignDepartment("IT");

        // Display employee details and calculated salary
        emp1.displayDetails();
        System.out.println("Salary: " + emp1.calculateSalary());
        System.out.println(((FullTimeEmployee) emp1).getDepartmentDetails());

        System.out.println();

        emp2.displayDetails();
        System.out.println("Salary: " + emp2.calculateSalary());
        System.out.println(((PartTimeEmployee) emp2).getDepartmentDetails());
    }
}
