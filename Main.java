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
            System.out.println("3. Edit Complaint");
            System.out.println("4. Delete Complaint");
            System.out.println("5. Search Complaint");
            System.out.println("6. Exit");
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
                    editComplaint();
                    break;
                case 4:
                    deleteComplaint();
                    break;
                case 5:
                    searchComplaint();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    // Add complaint
    public static void registerComplaint() {
        System.out.print("Enter complaint: ");
        String complaint = sc.nextLine();
        complaints.add(complaint);
        System.out.println("Complaint registered!");
    }

    // View all complaints
    public static void viewComplaints() {
        if (complaints.isEmpty()) {
            System.out.println("No complaints found.");
            return;
        }

        System.out.println("\n--- Complaints ---");
        for (int i = 0; i < complaints.size(); i++) {
            System.out.println((i + 1) + ". " + complaints.get(i));
        }
    }

    // Edit complaint
    public static void editComplaint() {
        viewComplaints();

        if (complaints.isEmpty()) return;

        System.out.print("Enter complaint number to edit: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index <= 0 || index > complaints.size()) {
            System.out.println("Invalid number!");
            return;
        }

        System.out.print("Enter new complaint: ");
        String newComplaint = sc.nextLine();

        complaints.set(index - 1, newComplaint);
        System.out.println("Complaint updated!");
    }

    // Delete complaint
    public static void deleteComplaint() {
        viewComplaints();

        if (complaints.isEmpty()) return;

        System.out.print("Enter complaint number to delete: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index <= 0 || index > complaints.size()) {
            System.out.println("Invalid number!");
            return;
        }

        complaints.remove(index - 1);
        System.out.println("Complaint deleted!");
    }

    // Search complaint
    public static void searchComplaint() {
        System.out.print("Enter keyword to search: ");
        String keyword = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < complaints.size(); i++) {
            if (complaints.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println((i + 1) + ". " + complaints.get(i));
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching complaints found.");
        }
    }
}