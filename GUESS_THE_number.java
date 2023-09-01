import java.util.Random;
import java.util.Scanner;

public class GUESS_THE_number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int attempts = 0;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to Guess the Number!");

        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out
                    .println("I've selected a number between " + minRange + " and " + maxRange + ". Try to guess it!");

            int userGuess;
            boolean hasGuessedCorrectly = false;

            while (!hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Please guess within the valid range.");
                } else if (userGuess < randomNumber) {
                    System.out.println("Lower! Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Higher! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + randomNumber + " in " + attempts
                            + " attempts.");
                    score += attempts;
                    hasGuessedCorrectly = true;
                }
            }

            System.out.print("Play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();

            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }

            attempts = 0;
        }

        System.out.println("Your total score is: " + score);
        scanner.close();
    }
}
