import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<String> complaints = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Complaint Management System ---");
            System.out.println("1. Register Complaint");
            System.out.println("2. View Complaints");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    registerComplaint();
                    break;
                case 2:
                    viewComplaints();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);
    }

    public static void registerComplaint() {
        System.out.print("Enter complaint: ");
        String complaint = sc.nextLine();
        complaints.add(complaint);
        System.out.println("Complaint registered!");
    }

    public static void viewComplaints() {
        if (complaints.isEmpty()) {
            System.out.println("No complaints found.");
        } else {
            System.out.println("\n--- Complaints ---");
            for (int i = 0; i < complaints.size(); i++) {
                System.out.println((i + 1) + ". " + complaints.get(i));
            }
        }
    }
}