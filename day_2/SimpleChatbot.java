import java.util.Scanner;

public class SimpleChatbot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        
        System.out.println("Hello! I'm a simple chatbot. Type 'exit' to end the chat.");

        while (true) {
            System.out.print("You: ");
            userInput = scanner.nextLine();
            
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Chatbot: Goodbye! Have a great day!");
                break;
            }
            
            String response = getResponse(userInput);
            System.out.println("Chatbot: " + response);
        }

        scanner.close();
    }

    private static String getResponse(String input) {
        String response;

        switch (input.toLowerCase()) {
            case "hi":
            case "hello":
                response = "Hello! How can I help you today?";
                break;
            case "how are you":
                response = "I'm just a bot, but I'm doing well! How can I assist you?";
                break;
            case "what's your name":
                response = "I'm a simple chatbot created by a Java programmer. I don't have a name!";
                break;
            case "bye":
                response = "Goodbye! Have a nice day!";
                break;
            default:
                response = "Sorry, I didn't understand that. Can you please rephrase?";
                break;
        }

        return response;
    }
}
