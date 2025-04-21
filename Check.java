public class Check {
    private int secretNumber;

    public Check(int secretNumber) {
        this.secretNumber = secretNumber;
    }

    public String checkGuess(int guess) {
        if (guess < secretNumber) {
            return "Too low. Try again.";
        } else if (guess > secretNumber) {
            return "Too high. Try again.";
        } else {
            return "Congratulations! You guessed the correct number.";
        }
    }
}