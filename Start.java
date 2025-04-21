import java.util.Random;
import java.util.Scanner;

public class Start {
    private int secretNumber;
    private final int maxAttempts = 10;
    private User user;
    private Scroll guessHistory;
    private Check guessChecker;
    private Exit exitHandler;

    public Start() {
        Random random = new Random();
        this.secretNumber = random.nextInt(100) + 1; // Number between 1 and 100
        this.user = new User();
        this.guessHistory = new Scroll();
        this.guessChecker = new Check(secretNumber);
        this.exitHandler = new Exit();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🎮 Welcome to the Secret Number Challenge!");
        System.out.print("🧑‍💻 Enter your name, challenger: ");
        String name = scanner.nextLine();
        user.setName(name);

        System.out.println("\n🌟 Alright, " + user.getName() + "! Your mission is to guess the secret number between 1 and 100.");
        System.out.println("🔑 You have " + maxAttempts + " chances to succeed. Let’s get started!");

        int guess = -1; // Initialize guess to ensure it’s always defined

        while (user.getAttempts() < maxAttempts) {
            // Input validation
            while (true) {
                System.out.print("🎯 Enter your guess: ");
                String input = scanner.nextLine();
                try {
                    guess = Integer.parseInt(input);
                    if (guess < 1 || guess > 100) {
                        System.out.println("⚠️ Please choose a number between 1 and 100.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("🚫 Invalid input! Please enter a valid number.");
                }
            }

            user.incrementAttempts();
            guessHistory.addGuess(guess);

            String result = guessChecker.checkGuess(guess);
            System.out.println("📝 " + result);
            giveHint(guess);
            guessHistory.displayHistory();

            if (result.contains("Congrats")) {
                System.out.println("\n🏆 You did it, " + user.getName() + "! It took you " + user.getAttempts() + " guesses.");
                break;
            }

            System.out.println("⏳ You have " + (maxAttempts - user.getAttempts()) + " guesses left.");
        }

        if (user.getAttempts() >= maxAttempts && !guessChecker.checkGuess(guess).contains("Congrats")) {
            System.out.println("\n💔 Game Over! You've used all your attempts.");
            System.out.println("🔍 The secret number was: " + secretNumber);
        }

        scanner.close();
    }

    private void giveHint(int guess) {
        int difference = Math.abs(secretNumber - guess);
        if (difference == 0) {
            // Correct guess
        } else if (difference <= 5) {
            System.out.println("🔥 You're really close! Just a bit more!");
        } else if (difference <= 10) {
            System.out.println("🌡️ Getting warmer! Keep going!");
        } else {
            System.out.println("❄️ You’re far off! Try something else.");
        }
    }

    public static void main(String[] args) {
        Start game = new Start();
        game.playGame();
    }
}
