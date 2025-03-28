class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    String university;

    Intern(String name, int id, double salary, String university) {
        super(name, id, salary);
        this.university = university;
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("University: " + university);
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Manager("Arun", 101, 80000, 10);
        Employee e2 = new Developer("Priya", 102, 60000, "Java");
        Employee e3 = new Intern("Rahul", 103, 15000, "IIT");

        e1.displayDetails();
        System.out.println();
        e2.displayDetails();
        System.out.println();
        e3.displayDetails();
    }
}
