import java.util.Scanner;

    public class Input {
        public int getUserGuess(Scanner scanner) {
            int guess = -1;
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter your guess: ");
                if (scanner.hasNextInt()) {
                    guess = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }
            return guess;
        }
    }
