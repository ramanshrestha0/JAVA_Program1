
import java.util.Scanner;

// public class IncrementDecrementExample {
//     public static void main(String[] args) {
//         int x = 5;

//         // Post-increment: x is used first, then incremented
//         System.out.println("Post-increment (x++): " + (x++)); // Prints 5
//         System.out.println("After post-increment: " + x);     // Now x is 6

//         // Pre-increment: x is incremented first, then used
//         System.out.println("Pre-increment (++x): " + (++x));  // Prints 7

//         // Post-decrement: x is used first, then decremented
//         System.out.println("Post-decrement (x--): " + (x--)); // Prints 7
//         System.out.println("After post-decrement: " + x);     // Now x is 6

//         // Pre-decrement: x is decremented first, then used
//         System.out.println("Pre-decrement (--x): " + (--x));  // Prints 5
//     }
// }


public class IncrementDecrementExample {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        System.out.print("Enter the value for increment or decrement:");
        int x =scanner.nextInt();

        System.out.println("Post-increment (x++): " + (x++)); // Prints 5
                System.out.println("After post-increment: " + x);     // Now x is 6
        
                 
               System.out.println("Pre-increment (++x): " + (++x));  // Prints 7
    
           
                 System.out.println("Post-decrement (x--): " + (x--)); // Prints 7
                System.out.println("After post-decrement: " + x);     // Now x is 6
        
                 
                System.out.println("Pre-decrement (--x): " + (--x));  // Prints 5
    }
}