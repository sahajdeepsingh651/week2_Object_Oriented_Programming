import java.util.*;

class Faculty {
    String name;

    public Faculty(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("Faculty: " + name);
    }
}

class Department {
    String departmentName;
    List<Faculty> facultyList;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        facultyList = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        if (!facultyList.contains(faculty)) {
            facultyList.add(faculty);
        }
    }

    public void showDepartmentDetails() {
        System.out.println("Department: " + departmentName);
        for (Faculty f : facultyList) {
            f.showDetails();
        }
    }
}

class University {
    String universityName;
    List<Department> departments;

    public University(String universityName) {
        this.universityName = universityName;
        departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public Department getDepartment(String name) {
        for (Department d : departments) {
            if (d.departmentName.equals(name)) {
                return d;
            }
        }
        return null;
    }

    public void showUniversityDetails() {
        System.out.println("University: " + universityName);
        for (Department d : departments) {
            d.showDepartmentDetails();
        }
    }

    public void deleteUniversity() {
        departments.clear();  // destroys all departments
        System.out.println(universityName + " has been deleted along with all its departments.");
    }
}

class UniversityCompositionAggregationDemo {
    public static void main(String[] args) {
        University mit = new University("MIT");

        mit.addDepartment("Computer Science");
        mit.addDepartment("Mechanical Engineering");

        Faculty drSmith = new Faculty("Dr. Smith");
        Faculty drTaylor = new Faculty("Dr. Taylor");

        Department cs = mit.getDepartment("Computer Science");
        Department mech = mit.getDepartment("Mechanical Engineering");

        if (cs != null) {
            cs.addFaculty(drSmith);
        }
        if (mech != null) {
            mech.addFaculty(drTaylor);
            mech.addFaculty(drSmith); // Shared faculty (aggregation)
        }

        mit.showUniversityDetails();

        System.out.println("\nFaculty exists independently:");
        drSmith.showDetails();

        System.out.println();
        mit.deleteUniversity(); // All departments deleted

        mit.showUniversityDetails(); // No departments left
    }
}
