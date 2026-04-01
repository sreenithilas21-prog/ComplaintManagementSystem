public class Complaint {
    int id;
    String description;
    String status;
    String assignedTo;

    public Complaint(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "Pending";
        this.assignedTo = "Not Assigned";
    }

    public void display() {
        System.out.println("\nID: " + id);
        System.out.println("Description: " + description);
        System.out.println("Status: " + status);
        System.out.println("Assigned To: " + assignedTo);
    }
}