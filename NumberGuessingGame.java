import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int rounds = 3; // number of rounds
        int totalScore = 0;

        System.out.println("🎮 Welcome to the Number Guessing Game!");
        System.out.println("You have " + rounds + " rounds to play.\n");

        for (int r = 1; r <= rounds; r++) {
            int numberToGuess = rand.nextInt(100) + 1; // Random number 1–100
            int attemptsLeft = 7; // limit attempts per round
            boolean guessedCorrect = false;

            System.out.println("---- Round " + r + " ----");
            System.out.println("Guess a number between 1 and 100. You have " + attemptsLeft + " attempts.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attemptsLeft--;

                if (userGuess == numberToGuess) {
                    System.out.println("✅ Correct! You guessed it.");
                    int score = attemptsLeft + 1; // more attempts left = higher score
                    totalScore += score;
                    System.out.println("You earned " + score + " points this round.");
                    guessedCorrect = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Attempts left: " + attemptsLeft);
                } else {
                    System.out.println("Too high! Attempts left: " + attemptsLeft);
                }
            }

            if (!guessedCorrect) {
                System.out.println("❌ You ran out of attempts! The number was " + numberToGuess);
            }
            System.out.println();
        }

        System.out.println("🏆 Game Over! Your total score is: " + totalScore);
    }
}