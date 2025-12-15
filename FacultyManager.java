import java.util.ArrayList;
import java.util.Scanner;

public class FacultyManager {
    private ArrayList<Faculty> facultyList = new ArrayList<>();
    private int nextFacultyId = 1000; // auto ID start

    public void facultyMenu(Scanner sc) {
        int choice;

        do {
            System.out.println("\n===== FACULTY MENU =====");
            System.out.println("1. Add new faculty");
            System.out.println("2. Delete faculty");
            System.out.println("3. View all faculty");
            System.out.println("4. Update faculty info");
            System.out.println("5. Name and contact info (search)");
            System.out.println("6. Faculty subject (search)");
            System.out.println("7. Position (search)");
            System.out.println("8. Availability (search)");
            System.out.println("9. Back to menu");
            System.out.print("Choose option: ");

            while (!sc.hasNextInt()) {
                System.out.print("Please enter a number (1-9): ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1 -> addFaculty(sc);
                case 2 -> deleteFaculty(sc);
                case 3 -> viewAllFaculty();
                case 4 -> updateFaculty(sc);
                case 5 -> searchByNameOrContact(sc);
                case 6 -> searchBySubject(sc);
                case 7 -> searchByPosition(sc);
                case 8 -> searchByAvailability(sc);
                case 9 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 9);
    }

    // 1) Add option
    private void addFaculty(Scanner sc) {
        System.out.println("\n--- Add New Faculty ---");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Contact Info (phone/email): ");
        String contact = sc.nextLine();

        System.out.print("Subject: ");
        String subject = sc.nextLine();

        System.out.print("Position (Professor, Adjunct, etc.): ");
        String position = sc.nextLine();

        System.out.print("Availability (days/hours): ");
        String availability = sc.nextLine();

        Faculty f = new Faculty(nextFacultyId, name, contact, subject, position, availability);
        facultyList.add(f);
        System.out.println("Faculty added! Assigned ID: " + nextFacultyId);
        nextFacultyId++;
    }

    // 2) Delete option
    private void deleteFaculty(Scanner sc) {
        System.out.println("\n--- Delete Faculty ---");
        if (facultyList.isEmpty()) {
            System.out.println("No faculty to delete.");
            return;
        }

        System.out.print("Enter Faculty ID to delete: ");
        int id = readInt(sc);

        int index = findFacultyIndexById(id);
        if (index == -1) {
            System.out.println("Faculty ID not found.");
        } else {
            Faculty removed = facultyList.remove(index);
            System.out.println("Deleted: " + removed.getName() + " (ID " + removed.getId() + ")");
        }
    }

    // 3) View all option 
    private void viewAllFaculty() {
        System.out.println("\n--- View All Faculty ---");
        if (facultyList.isEmpty()) {
            System.out.println("No faculty records found.");
            return;
        }
        for (Faculty f : facultyList) {
            System.out.println(f);
        }
    }

    // 4) Update option 
    private void updateFaculty(Scanner sc) {
        System.out.println("\n--- Update Faculty Info ---");
        if (facultyList.isEmpty()) {
            System.out.println("No faculty to update.");
            return;
        }

        System.out.print("Enter Faculty ID to update: ");
        int id = readInt(sc);
        sc.nextLine(); // consume newline 

        Faculty f = findFacultyById(id);
        if (f == null) {
            System.out.println("Faculty ID not found.");
            return;
        }

        System.out.println("Current info:");
        System.out.println(f);

        System.out.println("What do you want to update?");
        System.out.println("1. Name");
        System.out.println("2. Contact Info");
        System.out.println("3. Subject");
        System.out.println("4. Position");
        System.out.println("5. Availability");
        System.out.print("Choose (1-5): ");

        int choice = readInt(sc);
        sc.nextLine(); // consume newline

        switch (choice) {
            case 1 -> {
                System.out.print("New Name: ");
                f.setName(sc.nextLine());
            }
            case 2 -> {
                System.out.print("New Contact Info: ");
                f.setContactInfo(sc.nextLine());
            }
            case 3 -> {
                System.out.print("New Subject: ");
                f.setSubject(sc.nextLine());
            }
            case 4 -> {
                System.out.print("New Position: ");
                f.setPosition(sc.nextLine());
            }
            case 5 -> {
                System.out.print("New Availability: ");
                f.setAvailability(sc.nextLine());
            }
            default -> System.out.println("Invalid update choice.");
        }

        System.out.println("Update complete!");
    }

    // 5) Name + contact search option
    private void searchByNameOrContact(Scanner sc) {
        System.out.println("\n--- Search: Name / Contact ---");
        if (facultyList.isEmpty()) {
            System.out.println("No faculty records found.");
            return;
        }

        System.out.print("Enter name or contact keyword: ");
        String keyword = sc.nextLine().toLowerCase();

        boolean found = false;
        for (Faculty f : facultyList) {
            if (f.getName().toLowerCase().contains(keyword) ||
                f.getContactInfo().toLowerCase().contains(keyword)) {
                System.out.println(f);
                found = true;
            }
        }

        if (!found) System.out.println("No matches found.");
    }

    // 6) Subject search option 
    private void searchBySubject(Scanner sc) {
        System.out.println("\n--- Search: Subject ---");
        searchByField(sc, "subject");
    }

    // 7) Position search option
    private void searchByPosition(Scanner sc) {
        System.out.println("\n--- Search: Position ---");
        searchByField(sc, "position");
    }

    // 8) Availability search option
    private void searchByAvailability(Scanner sc) {
        System.out.println("\n--- Search: Availability ---");
        searchByField(sc, "availability");
    }

    // helper for 6/7/8 option 
    private void searchByField(Scanner sc, String field) {
        if (facultyList.isEmpty()) {
            System.out.println("No faculty records found.");
            return;
        }

        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine().toLowerCase();

        boolean found = false;
        for (Faculty f : facultyList) {
            String value = switch (field) {
                case "subject" -> f.getSubject();
                case "position" -> f.getPosition();
                case "availability" -> f.getAvailability();
                default -> "";
            };

            if (value.toLowerCase().contains(keyword)) {
                System.out.println(f);
                found = true;
            }
        }

        if (!found) System.out.println("No matches found.");
    }

    // ===== Utility Methods =====
    private Faculty findFacultyById(int id) {
        for (Faculty f : facultyList) {
            if (f.getId() == id) return f;
        }
        return null;
    }

    private int findFacultyIndexById(int id) {
        for (int i = 0; i < facultyList.size(); i++) {
            if (facultyList.get(i).getId() == id) return i;
        }
        return -1;
    }

    private int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            sc.next();
        }
        return sc.nextInt();
    }
}


