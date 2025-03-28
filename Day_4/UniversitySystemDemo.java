import java.util.*;

class Course {
    String courseName;
    Professor professor;
    List<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        enrolledStudents = new ArrayList<>();
    }

    public void assignProfessor(Professor prof) {
        this.professor = prof;
        System.out.println("Professor " + prof.name + " assigned to " + courseName);
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        System.out.println(student.name + " enrolled in " + courseName);
    }

    public void showCourseInfo() {
        System.out.println("Course: " + courseName);
        if (professor != null)
            System.out.println("Professor: " + professor.name);
        else
            System.out.println("No professor assigned yet.");

        System.out.println("Enrolled Students:");
        for (Student s : enrolledStudents) {
            System.out.println(" - " + s.name);
        }
    }
}

class Professor {
    String name;
    List<Course> teachingCourses;

    public Professor(String name) {
        this.name = name;
        teachingCourses = new ArrayList<>();
    }

    public void assignToCourse(Course course) {
        course.assignProfessor(this);
        teachingCourses.add(course);
    }

    public void showTeachingCourses() {
        System.out.println("Professor: " + name + " is teaching:");
        for (Course c : teachingCourses) {
            System.out.println(" - " + c.courseName);
        }
    }
}

class Student {
    String name;
    List<Course> enrolledCourses;

    public Student(String name) {
        this.name = name;
        enrolledCourses = new ArrayList<>();
    }

    public void enrollCourse(Course course) {
        course.enrollStudent(this);
        enrolledCourses.add(course);
    }

    public void showEnrolledCourses() {
        System.out.println("Student: " + name + " is enrolled in:");
        for (Course c : enrolledCourses) {
            System.out.println(" - " + c.courseName);
        }
    }
}

class UniversitySystemDemo {
    public static void main(String[] args) {
        Course java = new Course("Java Programming");
        Course physics = new Course("Physics 101");

        Professor profMohan = new Professor("Mohan");
        Professor profRiya = new Professor("Riya");

        Student raj = new Student("Raj");
        Student diya = new Student("Diya");

        // Assign professors
        profMohan.assignToCourse(java);
        profRiya.assignToCourse(physics);

        // Students enroll
        raj.enrollCourse(java);
        raj.enrollCourse(physics);
        diya.enrollCourse(java);

        System.out.println();
        raj.showEnrolledCourses();
        diya.showEnrolledCourses();

        System.out.println();
        profMohan.showTeachingCourses();
        profRiya.showTeachingCourses();

        System.out.println();
        java.showCourseInfo();
        physics.showCourseInfo();
    }
}
