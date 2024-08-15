
import java.util.Scanner;

// public class ExpressionExample {
//     public static void main(String[] args) {
//         int x = 10;
//         int y = 5;
//         int z = 2;

//         int result = (x - y) / z;
//         System.out.println("The result of (x - y) / z is: " + result);
//     }
// }



public class Expresion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of x:");
        int x = scanner.nextInt();

        System.out.print("Enter the value of y:");
        int y = scanner.nextInt();

        System.out.print("Enter the value of z:");
        int z = scanner.nextInt();

        int result = (x - y) / z;

        System.out.println("The result of (x - y) / z is: " + result);

        scanner.close();

    }    
    }
    