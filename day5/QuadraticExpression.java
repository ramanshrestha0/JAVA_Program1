// public class QuadraticExpression {
//     public static void main(String[] args) {
//         double a = 2;
//         double b = 5;
//         double c = 3;

//         double result = (Math.pow(b, 2) - 4 * a * c) / (2 * a);
//         System.out.println("The result of the expression (b^2 - 4ac) / 2a is: " + result);
//     }
// }

import java.util.Scanner;

public  class QuadraticExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of a:");
        double a = scanner.nextDouble();

        System.out.print("Enter the value of b:");
        double b = scanner.nextDouble();

        System.out.print("Enter the value of c:");
        double c= scanner.nextDouble();

        double result = (Math.pow(b, 2) - 4 * a * c) / (2 * a);

        System.out.println("The result of the expression (b^2 - 4ac) / 2a is: " + result);


        scanner.close();


    }
}