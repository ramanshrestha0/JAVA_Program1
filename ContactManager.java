import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class ContactManager extends JFrame {

    private JTextField nameField, phoneField, emailField, searchField;
    private JTextArea outputArea;
    private Connection conn;

    public ContactManager() {
       
        setTitle("Contact Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact_management", "root", "");
            createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        inputPanel.add(phoneField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        JButton addButton = new JButton("Add Contact");
        addButton.addActionListener(new AddButtonListener());
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());

        searchPanel.add(new JLabel("Search by Name:"));
        searchField = new JTextField(20);
        searchPanel.add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new SearchButtonListener());
        searchPanel.add(searchButton);

        add(searchPanel, BorderLayout.CENTER);

      
        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);
    }

    // private void createTable() throws SQLException {
    //     String createTableSQL = "CREATE TABLE IF NOT EXISTS contacts (" +
    //             "id INT AUTO_INCREMENT PRIMARY KEY," +
    //             "name VARCHAR(100) NOT NULL," +
    //             "phone VARCHAR(15) NOT NULL," +
    //             "email VARCHAR(100))";
    //     try (Statement stmt = conn.createStatement()) {
    //         stmt.execute(createTableSQL);
    //     }
    // }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();

            if (name.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(ContactManager.this,
                        "Name and phone are required fields.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String insertSQL = "INSERT INTO contacts (name, phone, email) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                pstmt.setString(1, name);
                pstmt.setString(2, phone);
                pstmt.setString(3, email);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(ContactManager.this,
                        "Contact added successfully.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                nameField.setText("");
                phoneField.setText("");
                emailField.setText("");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(ContactManager.this,
                        "Error adding contact: " + ex.getMessage(),
                        "Database Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class SearchButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String searchName = searchField.getText();
            if (searchName.isEmpty()) {
                JOptionPane.showMessageDialog(ContactManager.this,
                        "Please enter a name to search.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String searchSQL = "SELECT * FROM contacts WHERE name LIKE ?";
            try (PreparedStatement pstmt = conn.prepareStatement(searchSQL)) {
                pstmt.setString(1, "%" + searchName + "%");
                try (ResultSet rs = pstmt.executeQuery()) {
                    outputArea.setText("");
                    while (rs.next()) {
                        outputArea.append("ID: " + rs.getInt("id") + "\n");
                        outputArea.append("Name: " + rs.getString("name") + "\n");
                        outputArea.append("Phone: " + rs.getString("phone") + "\n");
                        outputArea.append("Email: " + rs.getString("email") + "\n");
                        outputArea.append("-----------\n");
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(ContactManager.this,
                        "Error searching contact: " + ex.getMessage(),
                        "Database Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ContactManager frame = new ContactManager();
            frame.setVisible(true);
        });
    }
}
