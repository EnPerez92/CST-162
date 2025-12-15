import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    private static ArrayList<Student> students = new ArrayList<>();

    private static Scanner sc = new Scanner(System.in);

    public static void addStudent() {
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter student GPA: ");
        double gpa = sc.nextDouble();
        sc.nextLine();

        students.add(new Student(id, name, gpa));
        System.out.println("Student added successfully.");
    }

    public static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    private static Student findStudentById(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public static void updateStudentGPA() {
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();

        Student s = findStudentById(id);
        if (s != null) {
            System.out.print("Enter new GPA: ");
            double gpa = sc.nextDouble();
            sc.nextLine();
            s.setGpa(gpa);
            System.out.println("GPA updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void addCompletedCourse() {
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();

        Student s = findStudentById(id);
        if (s != null) {
            System.out.print("Enter course name: ");
            String course = sc.nextLine();

            System.out.print("Enter course credits: ");
            int credits = sc.nextInt();
            sc.nextLine();

            s.addCourse(course, credits);
            System.out.println("Course added to student record.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void deleteStudent() {
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();

        Student s = findStudentById(id);
        if (s != null) {
            students.remove(s);
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void checkGraduationEligibility() {
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();

        Student s = findStudentById(id);
        if (s != null) {
            if (s.isEligibleToGraduate()) {
                System.out.println("Student is eligible to graduate.");
            } else {
                System.out.println("Student is NOT eligible to graduate.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }
}
