import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FacultyManager facultyManager = new FacultyManager();

        int choice;

        do {
            System.out.println("\n===== SCHOOL INFORMATION SYSTEM =====");
            System.out.println("1. Students");
            System.out.println("2. Courses");
            System.out.println("3. Faculty");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Enter a valid number: ");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 3:
                    facultyManager.facultyMenu(sc);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Pick a valid option.");
            }

        } while (choice != 4);

        sc.close();
    }
}

