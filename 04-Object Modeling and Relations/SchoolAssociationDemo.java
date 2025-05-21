import java.util.*;

class Course {
    String courseName;
    List<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        enrolledStudents = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            student.enrollInCourse(this); // maintain bidirectional link
        }
    }

    public void showEnrolledStudents() {
        System.out.println("Course: " + courseName + " - Enrolled Students:");
        for (Student s : enrolledStudents) {
            System.out.println(" - " + s.name);
        }
    }
}

class Student {
    String name;
    List<Course> courses;

    public Student(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    public void enrollInCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.enrollStudent(this); // maintain bidirectional link
        }
    }

    public void viewCourses() {
        System.out.println("Student: " + name + " - Enrolled Courses:");
        for (Course c : courses) {
            System.out.println(" - " + c.courseName);
        }
    }
}

class School {
    String schoolName;
    List<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showStudents() {
        System.out.println("Students in " + schoolName + ":");
        for (Student s : students) {
            System.out.println(" - " + s.name);
        }
    }
}

class SchoolAssociationDemo {
    public static void main(String[] args) {
        School springfieldHigh = new School("Springfield High");

        Student john = new Student("John");
        Student emily = new Student("Emily");

        springfieldHigh.addStudent(john);
        springfieldHigh.addStudent(emily);

        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        john.enrollInCourse(math);
        john.enrollInCourse(science);
        emily.enrollInCourse(science);

        springfieldHigh.showStudents();
        System.out.println();

        john.viewCourses();
        emily.viewCourses();
        System.out.println();

        math.showEnrolledStudents();
        science.showEnrolledStudents();
    }
}
