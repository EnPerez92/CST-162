import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    private ArrayList<Student> students = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    

    public void addStudent() {
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter GPA: ");
        double gpa = sc.nextDouble();
        sc.nextLine();

        students.add(new Student(id, name, gpa));
        System.out.println("Student added.");
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    public Student findStudentById(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public void updateStudentGPA() {
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();

        Student s = findStudentById(id);
        if (s != null) {
            System.out.print("Enter new GPA: ");
            s.setGpa(sc.nextDouble());
            sc.nextLine();
            System.out.println("GPA updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void deleteStudent() {
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();

        Student s = findStudentById(id);
        if (s != null) {
            students.remove(s);
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void checkGraduationEligibility() {
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();

        Student s = findStudentById(id);
        if (s != null) {
            System.out.println(
                s.isEligibleToGraduate()
                    ? "Eligible to graduate."
                    : "Not eligible to graduate."
            );
        } else {
            System.out.println("Student not found.");
        }
    }
}
