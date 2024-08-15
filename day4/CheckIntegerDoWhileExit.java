// import java.util.Scanner;

// public class CheckInteger {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.print("Enter a number: ");
        
      
//         if (scanner.hasNextInt()) {
//             int number = scanner.nextInt();
//             System.out.println("You entered an integer: " + number);
//         } else {
//             System.out.println("The input is not an integer.");
//         }
        
//         scanner.close();
//     }
// }


import java.util.Scanner;

public class CheckIntegerDoWhileExit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        do {
            System.out.print("Enter a number: ");

            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                System.out.println("You entered a valid integer: " + number);
            } else {
                System.out.println("The input is not an integer. Please try again.");
                scanner.next(); // Consume the invalid input
            }

            // Ask if the user wants to exit
            System.out.print("Do you want to exit? (yes/no): ");
            String response = scanner.next();

            if (response.equalsIgnoreCase("yes")) {
                exit = true; // Exit the loop if user types "yes"
            }

        } while (!exit); // Loop continues until the user wants to exit

        scanner.close();
    }
}
