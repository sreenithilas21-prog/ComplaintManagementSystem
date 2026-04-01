import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Complaint> complaints = new ArrayList<>();

        User user = new User();
        Admin admin = new Admin();

        int choice;
        int idCounter = 1;

        do {
            System.out.println("\n==== Complaint Management System ====");
            System.out.println("1. Register Complaint");
            System.out.println("2. View Complaints");
            System.out.println("3. Assign Complaint");
            System.out.println("4. Resolve Complaint");
            System.out.println("5. Close Complaint");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    user.registerComplaint(complaints, idCounter++);
                    break;
                case 2:
                    user.viewComplaints(complaints);
                    break;
                case 3:
                    admin.assignComplaint(complaints);
                    break;
                case 4:
                    admin.resolveComplaint(complaints);
                    break;
                case 5:
                    admin.closeComplaint(complaints);
                    break;
                case 0:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }
}
