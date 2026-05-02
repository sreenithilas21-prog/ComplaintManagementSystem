import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;
public class ComplaintManagementSystem {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Complaint Management System");

frame.setSize(800, 650);
frame.setLayout(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JLabel lblId = new JLabel("Complaint ID");
lblId.setBounds(50, 50, 100, 30);
frame.add(lblId);

JTextField txtId = new JTextField();
txtId.setBounds(180, 50, 200, 30);
frame.add(txtId);
JLabel lblName = new JLabel("Name");
lblName.setBounds(50, 100, 100, 30);
frame.add(lblName);

JTextField txtName = new JTextField();
txtName.setBounds(180, 100, 200, 30);
frame.add(txtName);
JLabel lblType = new JLabel("Complaint Type");
lblType.setBounds(50, 150, 120, 30);
frame.add(lblType);

JTextField txtType = new JTextField();
txtType.setBounds(180, 150, 200, 30);
frame.add(txtType);
JLabel lblDesc = new JLabel("Description");
lblDesc.setBounds(50, 200, 100, 30);
frame.add(lblDesc);

JTextArea txtDesc = new JTextArea();

JScrollPane scroll = new JScrollPane(txtDesc);
scroll.setBounds(180, 200, 250, 80);

frame.add(scroll);
JLabel lblStatus = new JLabel("Status");
lblStatus.setBounds(50, 310, 100, 30);
frame.add(lblStatus);

JTextField txtStatus = new JTextField();
txtStatus.setBounds(180, 310, 200, 30);
frame.add(txtStatus);
JButton btnInsert = new JButton("Insert");
btnInsert.setBounds(50, 370, 100, 30);
frame.add(btnInsert);

JButton btnView = new JButton("View");
btnView.setBounds(170, 370, 100, 30);
frame.add(btnView);

JButton btnUpdate = new JButton("Update");
btnUpdate.setBounds(290, 370, 100, 30);
frame.add(btnUpdate);

JButton btnDelete = new JButton("Delete");
btnDelete.setBounds(410, 370, 100, 30);
frame.add(btnDelete);
JTable table = new JTable();

JScrollPane tableScroll = new JScrollPane(table);

tableScroll.setBounds(50, 430, 680, 150);

frame.add(tableScroll);
btnInsert.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO complaints(name, complaint_type, description, status, date) VALUES (?, ?, ?, ?, CURDATE())";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, txtName.getText());
            pst.setString(2, txtType.getText());
            pst.setString(3, txtDesc.getText());
            pst.setString(4, txtStatus.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Complaint Inserted Successfully");

                    } catch(Exception ex) {
                        System.out.println(ex);
                    }
                }
            });
            btnView.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM complaints";

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();
DefaultTableModel model = new DefaultTableModel();

            model.addColumn("ID");
            model.addColumn("Name");
            model.addColumn("Type");
            model.addColumn("Description");
            model.addColumn("Status");
            model.addColumn("Date");

            while(rs.next()) {

                model.addRow(new Object[]{
                    rs.getInt("complaint_id"),
                    rs.getString("name"),
                    rs.getString("complaint_type"),
                    rs.getString("description"),
                    rs.getString("status"),
                    rs.getDate("date")
                });
            }

            table.setModel(model);

        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
});
btnUpdate.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "UPDATE complaints SET name=?, complaint_type=?, description=?, status=? WHERE complaint_id=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, txtName.getText());
            pst.setString(2, txtType.getText());
            pst.setString(3, txtDesc.getText());
            pst.setString(4, txtStatus.getText());
            pst.setInt(5, Integer.parseInt(txtId.getText()));
            pst.executeUpdate();

            JOptionPane.showMessageDialog(frame, "Updated Successfully");

        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
});
btnDelete.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM complaints WHERE complaint_id=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, Integer.parseInt(txtId.getText()));

            pst.executeUpdate();

            JOptionPane.showMessageDialog(frame, "Deleted Successfully");
            } catch(Exception ex) {
            System.out.println(ex);
        }
    }
});
frame.setVisible(true);
}
}