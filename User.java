import java.util.ArrayList;
import java.util.Scanner;

public class User {

    Scanner sc = new Scanner(System.in);

    public void registerComplaint(ArrayList<Complaint> list, int id) {
        System.out.print("Enter complaint description: ");
        sc.nextLine(); // clear buffer
        String desc = sc.nextLine();

        Complaint c = new Complaint(id, desc);
        list.add(c);

        System.out.println("Complaint Registered Successfully!");
    }

    public void viewComplaints(ArrayList<Complaint> list) {
        if (list.isEmpty()) {
            System.out.println("No complaints available.");
            return;
        }

        for (Complaint c : list) {
            c.display();
        }
    }
}