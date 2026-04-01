import java.util.ArrayList;
import java.util.Scanner;

public class Admin {

    Scanner sc = new Scanner(System.in);

    public void assignComplaint(ArrayList<Complaint> list) {
        System.out.print("Enter Complaint ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Complaint c : list) {
            if (c.id == id) {
                System.out.print("Assign to: ");
                c.assignedTo = sc.nextLine();
                c.status = "Assigned";
                System.out.println("Assigned Successfully!");
                return;
            }
        }
        System.out.println("Complaint Not Found!");
    }

    public void resolveComplaint(ArrayList<Complaint> list) {
        System.out.print("Enter Complaint ID: ");
        int id = sc.nextInt();

        for (Complaint c : list) {
            if (c.id == id) {
                c.status = "Resolved";
                System.out.println("Resolved Successfully!");
                return;
            }
        }
        System.out.println("Complaint Not Found!");
    }

    public void closeComplaint(ArrayList<Complaint> list) {
        System.out.print("Enter Complaint ID: ");
        int id = sc.nextInt();

        for (Complaint c : list) {
            if (c.id == id) {
                c.status = "Closed";
                System.out.println("Closed Successfully!");
                return;
            }
        }
        System.out.println("Complaint Not Found!");
    }
}