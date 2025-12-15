import java.util.Scanner;
public class CoursesSubMenu {
    static final int MAX=50;
    static String[] names=new String[MAX];
    static String[] times=new String[MAX];
    static int[] credits=new int[MAX];
    static String[] lengths=new String[MAX];
    static String[] professors=new String[MAX];
    static int[] capacities=new int[MAX];
    static int count=0;

    public static void CoursesSubMenu(Scanner sc){
        int choice;
        do{
            System.out.println("\n=== COURSE MENU ===");
            System.out.println("1. Add Course");
            System.out.println("2. View Courses");
            System.out.println("3. Update Course");
            System.out.println("4. Delete Course");
            System.out.println("0. Back to Main Menu");
            System.out.println("Choose: ");
            choice=sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    addCourse(sc); break;
                case 2:
                    viewCourses(); break;
                case 3:
                    updateCourse(sc); break;
                case 4:
                    deleteCourse(sc); break;
                case 0:
                    System.out.println("Returning..."); break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice !=0);
    }
    static void addCourse (Scanner sc){
        if (count >= MAX){
            System.out.println("Course list is full.");
            return;
        }
        System.out.print("Name: ");
        names[count]=sc.nextLine();
        System.out.print("Time: ");
        times[count]=sc.nextLine();
        System.out.print("Credit hours: ");
        credits[count]=sc.nextInt();
        sc.nextLine();
        System.out.print("Course length: ");
        lengths[count]=sc.nextLine();
        System.out.print("Professor: ");
        professors[count]=sc.nextLine();
        System.out.print("Capacity: ");
        capacities[count]=sc.nextInt();
        sc.nextLine();
        count++;
        System.out.println("Course added.");
    }
    static void viewCourses(){
        if (count==0){
            System.out.println("No course available.");
            return;
        }
        System.out.println("\n=== ALL COURSES ===");
        for (int i=0;i<count;i++){
            System.out.println("\nCourse #"+(i+1));
            System.out.println("Name: "+names[i]);
            System.out.println("Time: "+times[i]);
            System.out.println("Credits: "+credits[i]);
            System.out.println("Length: "+lengths[i]);
            System.out.println("Professor: "+professors[i]);
            System.out.println("Capacity: "+capacities[i]);
        }
    }
    static void updateCourse(Scanner sc){
        if (count==0){
            System.out.println("No course to update.");
            return;
        }
        viewCourses();
        System.out.println("Which course number to update?");
        int index=sc.nextInt()-1;
        sc.nextLine();
        if (index<0||index>=count){
            System.out.println("Invalid number.");
            return;
        }
        System.out.print("New name: ");
        names[index]=sc.nextLine();
        System.out.print("New time: ");
        times[index]=sc.nextLine();
        System.out.print("New credits: ");
        credits[index]=sc.nextInt();
        sc.nextLine();
        System.out.print("New length: ");
        lengths[index]=sc.nextLine();
        System.out.print("New professor: ");
        professors[index]=sc.nextLine();
        System.out.print("New capacity: ");
        capacities[index]=sc.nextInt();
        sc.nextLine();
        System.out.println("Course updated.");
    
    }
    static void deleteCourse(Scanner sc){
        if(count==0){
            System.out.println("No courses to delete."); return;
        }
        viewCourses();
        System.out.print("Which course number do you want to delete?");
        int index=sc.nextInt()-1;
        sc.nextLine();
        if (index<0||index>=count){
            System.out.println("Invalid number."); return;
        }
        for (int i=index;i<count-1;i++){
            names[i]=names[i+1];
            times[i]=times[i+1];
            credits[i]=credits[i+1];
            lengths[i]=lengths[i+1];
            professors[i]=professors[i+1];
            capacities[i]=capacities[i+1];
        }
        count--;
        System.out.println("Course deleted.");
    }
}