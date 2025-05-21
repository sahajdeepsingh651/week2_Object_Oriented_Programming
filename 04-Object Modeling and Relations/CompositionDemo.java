import java.util.*;

class Employee {
    String name;

    public Employee(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("Employee: " + name);
    }
}

class Department {
    String departmentName;
    List<Employee> employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        employees = new ArrayList<>();
    }

    public void addEmployee(String employeeName) {
        Employee emp = new Employee(employeeName);
        employees.add(emp);
    }

    public void showDepartmentDetails() {
        System.out.println("Department: " + departmentName);
        for (Employee emp : employees) {
            emp.showDetails();
        }
    }
}

class Company {
    String companyName;
    List<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        Department dept = new Department(departmentName);
        departments.add(dept);
    }

    public Department getDepartment(String departmentName) {
        for (Department d : departments) {
            if (d.departmentName.equals(departmentName)) {
                return d;
            }
        }
        return null;
    }

    public void showCompanyDetails() {
        System.out.println("Company: " + companyName);
        for (Department dept : departments) {
            dept.showDepartmentDetails();
        }
    }

    public void deleteCompany() {
        departments.clear(); // This removes all departments and their employees
        System.out.println(companyName + " has been deleted along with all departments and employees.");
    }
}

class CompositionDemo {
    public static void main(String[] args) {
        Company techCorp = new Company("TechCorp");

        techCorp.addDepartment("IT");
        techCorp.addDepartment("HR");

        Department it = techCorp.getDepartment("IT");
        if (it != null) {
            it.addEmployee("Alice");
            it.addEmployee("Bob");
        }

        Department hr = techCorp.getDepartment("HR");
        if (hr != null) {
            hr.addEmployee("Charlie");
        }

        techCorp.showCompanyDetails();
        System.out.println();

        techCorp.deleteCompany(); // Removes all departments and employees
        System.out.println();

        techCorp.showCompanyDetails(); // Should show no departments
    }
}
