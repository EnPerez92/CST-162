import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    static final int MAX = 50; // max students
    static String[] ids = new String[MAX];
    static String[] names = new String[MAX];
    static double[] gpas = new double[MAX];
    static ArrayList<String>[] completedCourses = new ArrayList[MAX];
    static int[] totalCredits = new int[MAX];
    static int count = 0;

    @SuppressWarnings("unchecked")
    public static void Student(Scanner sc) {
        int choice;
        do {
            System.out.println("\n=== STUDENT MENU ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student GPA");
            System.out.println("4. Add Completed Course");
            System.out.println("5. Delete Student");
            System.out.println("6. Check Graduation Eligibility");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose: ");

            while (!sc.hasNextInt()) {
                System.out.print("Enter a valid number: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent(sc);
                case 2 -> viewStudents();
                case 3 -> updateGPA(sc);
                case 4 -> addCompletedCourse(sc);
                case 5 -> deleteStudent(sc);
                case 6 -> checkGraduation(sc);
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid option.");
            }
        } while (choice != 0);
    }


    static void addStudent(Scanner sc) {
        if (count >= MAX) {
            System.out.println("Student list is full.");
            return;
        }
        System.out.print("Enter Student ID: ");
        ids[count] = sc.nextLine();

        System.out.print("Enter Name: ");
        names[count] = sc.nextLine();

        System.out.print("Enter GPA: ");
        gpas[count] = sc.nextDouble();
        sc.nextLine(); // consume newline

        completedCourses[count] = new ArrayList<>();
        totalCredits[count] = 0;

        count++;
        System.out.println("Student added.");
    }

    static void viewStudents() {
        if (count == 0) {
            System.out.println("No students available.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println("\nStudent #" + (i + 1));
            System.out.println("ID: " + ids[i]);
            System.out.println("Name: " + names[i]);
            System.out.println("GPA: " + gpas[i]);
            System.out.println("Total Credits: " + totalCredits[i]);
            System.out.println("Completed Courses: " + completedCourses[i]);
        }
    }

    static void updateGPA(Scanner sc) {
        System.out.print("Enter Student ID to update GPA: ");
        String id = sc.nextLine();
        int index = findStudentIndex(id);
        if (index == -1) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter new GPA: ");
        gpas[index] = sc.nextDouble();
        sc.nextLine();
        System.out.println("GPA updated.");
    }

    static void addCompletedCourse(Scanner sc) {
        System.out.print("Enter Student ID to add course: ");
        String id = sc.nextLine();
        int index = findStudentIndex(id);
        if (index == -1) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter course name: ");
        String course = sc.nextLine();
        System.out.print("Enter course credits: ");
        int credits = sc.nextInt();
        sc.nextLine();

        completedCourses[index].add(course);
        totalCredits[index] += credits;
        System.out.println("Course added.");
    }

    static void deleteStudent(Scanner sc) {
        System.out.print("Enter Student ID to delete: ");
        String id = sc.nextLine();
        int index = findStudentIndex(id);
        if (index == -1) {
            System.out.println("Student not found.");
            return;
        }
        for (int i = index; i < count - 1; i++) {
            ids[i] = ids[i + 1];
            names[i] = names[i + 1];
            gpas[i] = gpas[i + 1];
            completedCourses[i] = completedCourses[i + 1];
            totalCredits[i] = totalCredits[i + 1];
        }
        count--;
        System.out.println("Student deleted.");
    }

    static void checkGraduation(Scanner sc) {
        System.out.print("Enter Student ID to check graduation: ");
        String id = sc.nextLine();
        int index = findStudentIndex(id);
        if (index == -1) {
            System.out.println("Student not found.");
            return;
        }
        if (gpas[index] >= 2.0 && totalCredits[index] >= 120) {
            System.out.println("Student is eligible to graduate!");
        } else {
            System.out.println("Student is NOT eligible to graduate.");
        }
    }

    static int findStudentIndex(String id) {
        for (int i = 0; i < count; i++) {
            if (ids[i].equalsIgnoreCase(id)) return i;
        }
        return -1;
    }
}
