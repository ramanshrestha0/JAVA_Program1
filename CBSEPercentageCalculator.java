// import java.util.Scanner;

// public class CBSEPercentageCalculator {
//     public static void main(String[] args) {
//         // Create a Scanner object to read input
//         Scanner scanner = new Scanner(System.in);
        
//         // Declare variables for the marks of 5 subjects
//         float subject1, subject2, subject3, subject4, subject5;
        
//         // Input: Marks for 5 subjects (out of 100)
//         System.out.println("Enter marks out of 100 for each subject:");
        
//         System.out.print("Enter marks for Subject 1: ");
//         subject1 = scanner.nextFloat();
        
//         System.out.print("Enter marks for Subject 2: ");
//         subject2 = scanner.nextFloat();
        
//         System.out.print("Enter marks for Subject 3: ");
//         subject3 = scanner.nextFloat();
        
//         System.out.print("Enter marks for Subject 4: ");
//         subject4 = scanner.nextFloat();
        
//         System.out.print("Enter marks for Subject 5: ");
//         subject5 = scanner.nextFloat();
        
//         // Calculate the total marks obtained
//         float totalMarksObtained = subject1 + subject2 + subject3 + subject4 + subject5;
        
//         // Calculate the percentage
//         float percentage = (totalMarksObtained / 500) * 100;
        
//         // Output the result
//         System.out.println("Total Marks Obtained: " + totalMarksObtained + " out of 500");
//         System.out.println("Percentage: " + percentage + "%");
        
//         // Close the scanner to avoid resource leaks
//         scanner.close();
//     }
// }




//jFrame

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CBSEPercentageCalculator extends JFrame {
    private JTextField subject1Field, subject2Field, subject3Field, subject4Field, subject5Field;
    private JLabel resultLabel;

    public CBSEPercentageCalculator() {
        setTitle("CBSE Percentage Calculator");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Subject 1
        JLabel label1 = new JLabel("Subject 1:");
        label1.setBounds(20, 20, 80, 20);
        add(label1);
        
        subject1Field = new JTextField();
        subject1Field.setBounds(100, 20, 150, 20);
        add(subject1Field);

        // Subject 2
        JLabel label2 = new JLabel("Subject 2:");
        label2.setBounds(20, 50, 80, 20);
        add(label2);
        
        subject2Field = new JTextField();
        subject2Field.setBounds(100, 50, 150, 20);
        add(subject2Field);

        // Subject 3
        JLabel label3 = new JLabel("Subject 3:");
        label3.setBounds(20, 80, 80, 20);
        add(label3);
        
        subject3Field = new JTextField();
        subject3Field.setBounds(100, 80, 150, 20);
        add(subject3Field);

        // Subject 4
        JLabel label4 = new JLabel("Subject 4:");
        label4.setBounds(20, 110, 80, 20);
        add(label4);
        
        subject4Field = new JTextField();
        subject4Field.setBounds(100, 110, 150, 20);
        add(subject4Field);

        // Subject 5
        JLabel label5 = new JLabel("Subject 5:");
        label5.setBounds(20, 140, 80, 20);
        add(label5);
        
        subject5Field = new JTextField();
        subject5Field.setBounds(100, 140, 150, 20);
        add(subject5Field);

        // Button to calculate percentage
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(100, 180, 100, 30);
        add(calculateButton);

        // Label to display the result
        resultLabel = new JLabel("Percentage: ");
        resultLabel.setBounds(20, 220, 250, 20);
        add(resultLabel);

        // Action listener for the button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatePercentage();
            }
        });

        setVisible(true);
    }

    private void calculatePercentage() {
        try {
            // Get the marks from the text fields
            float subject1 = Float.parseFloat(subject1Field.getText());
            float subject2 = Float.parseFloat(subject2Field.getText());
            float subject3 = Float.parseFloat(subject3Field.getText());
            float subject4 = Float.parseFloat(subject4Field.getText());
            float subject5 = Float.parseFloat(subject5Field.getText());

            // Calculate the total marks obtained
            float totalMarksObtained = subject1 + subject2 + subject3 + subject4 + subject5;

            // Calculate the percentage
            float percentage = (totalMarksObtained / 500) * 100;

            // Display the result
            resultLabel.setText("Percentage: " + percentage + "%");
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        new CBSEPercentageCalculator();
    }
}

