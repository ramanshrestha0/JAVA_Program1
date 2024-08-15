// import java.util.Scanner;

// public class Greeting {

//     public static void main(String[] args) {
        
//         Scanner scanner = new Scanner(System.in);

       
//         System.out.print("Please enter your name: ");
//         String name = scanner.nextLine();

     
//         System.out.println("Hello " + name + ", have a good day!");
        

      
//         scanner.close();
//     }
// }


import java.util.Scanner;

public class Greeting {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();

        
        System.out.println("Hello " + name + "!");

       
        System.out.print("How old are you, " + name + "? ");
        int age = scanner.nextInt();

        

       
        System.out.println("You are " + age + " years old, " + name + "!");


        scanner.nextLine();


        System.out.print("Oh then "+ name + " What is your aim?:");
        String name2 = scanner.nextLine();

        System.out.println("Your aim is to be " + name2 + " .Oh nice " + name + " Best wishes for your future..");

        scanner.nextLine();

        System.out.print("you are a very good person"+ name + " Do you have GF?");
        String name3 = scanner.nextLine();

        System.out.println("Oh" + name3 + " .that sound good " + name + " Well its nice to talk with you Mrs" +name+".");

        
        scanner.close();
    }
}
