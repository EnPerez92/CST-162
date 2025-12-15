import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    private ArrayList<Student> students = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public static void Student() {

    Scanner sc = new Scanner(System.in);
    int choice;

    do {
        System.out.println("\n--- STUDENT MENU ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update Student GPA");
        System.out.println("4. Add Completed Course");
        System.out.println("5. Delete Student");
        System.out.println("6. Check Graduation Eligibility");
        System.out.println("7. Back to Main Menu");
        System.out.print("Choose an option: ");

        choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> addStudent();
            case 2 -> viewAllStudents();
            case 3 -> updateStudentGPA();
            case 4 -> addCompletedCourse();
            case 5 -> deleteStudent();
            case 6 -> checkGraduationEligibility();
            case 7 -> System.out.println("Returning to main menu...");
            default -> System.out.println("Invalid choice.");
        }

    } while (choice != 7);
}


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
