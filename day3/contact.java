import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
//make database contact
//make table details
//make four columns named id,name,address and pnone
class Database {
    void intoDatabase(String name, String address, String phone) {
        String query = "INSERT INTO details (name, address, phone) VALUES (?, ?, ?)";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact?serverTimezone=UTC",
                "root", "");
                PreparedStatement st = con.prepareStatement(query)) 
                {
            st.setString(1, name);
            st.setString(2, address);
            st.setString(3, phone);
            int rowsInserted = st.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user is inserted successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String[] searchDatabase(String name1) {
        String[] contactdetails = new String[3];
        String sql = "SELECT name, address, phone FROM details WHERE name = ?";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact?serverTimezone=UTC",
                "root", "");
                PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, name1);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    contactdetails[0] = result.getString("name");
                    contactdetails[1] = result.getString("address");
                    contactdetails[2] = result.getString("phone");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contactdetails;
    }
}


public class Contact 
{
    public static void main(String[] args) {
        JFrame j1 = new JFrame();
        j1.setSize(1000, 1000);
        j1.setTitle("Contact Management");
        j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j1.setLayout(null);

        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();
        JTextField t4 = new JTextField();
        JButton b1 = new JButton("Submit");
        JButton b2 = new JButton("Search");
        JLabel m1 = new JLabel();
        JLabel m2 = new JLabel("Name:");
        JLabel m3 = new JLabel("Address:");
        JLabel m4 = new JLabel("Phone:");
        JLabel m5 = new JLabel();
        JLabel m6 = new JLabel();
        JLabel m7 = new JLabel();

        t1.setBounds(150, 50, 150, 25);
        t2.setBounds(150, 80, 150, 25);
        t3.setBounds(150, 110, 150, 25);
        t4.setBounds(350, 80, 150, 25);
        b1.setBounds(150, 170, 80, 25);
        b2.setBounds(350, 110, 80, 25);
        m1.setBounds(150, 250, 200, 25);
        m2.setBounds(50, 50, 100, 25);
        m3.setBounds(50, 80, 100, 25);
        m4.setBounds(50, 110, 100, 25);
        m5.setBounds(50, 280, 100, 25);
        m6.setBounds(50, 310, 100, 25);
        m7.setBounds(50, 340, 100, 25);

        j1.add(t1);
        j1.add(t2);
        j1.add(t3);
        j1.add(t4);
        j1.add(b1);
        j1.add(b2);
        j1.add(m1);
        j1.add(m2);
        j1.add(m3);
        j1.add(m4);
        j1.add(m5);
        j1.add(m6);
        j1.add(m7);

        Database d1 = new Database();

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = t1.getText();
                String address = t2.getText();
                String phone = t3.getText();
                if (name.isEmpty() || address.isEmpty() || phone.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "COMPLETE THE FORM", "Warning Message",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    d1.intoDatabase(name, address, phone);
                    m1.setText("New User Added");
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 

            {
                String name = t4.getText();
                if (name.isEmpty()) 
                {
                    JOptionPane.showMessageDialog(null, "ENTER NAME TO SEARCH", "Warning Message",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    String[] contactdetails = d1.searchDatabase(name);
                    if (contactdetails[0] == null) 
                    {
                        m1.setText("No Contact found");
                    } 

                    else 
                    {
                        m5.setText("Name: " + contactdetails[0]);
                        m6.setText("Address: " + contactdetails[1]);
                        m7.setText("Phone: " + contactdetails[2]);
                    }
                }
            }
        });

        j1.setVisible(true);
    }
}