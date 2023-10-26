package Task1;

import java.util.Random;
import java.util.Scanner;

public class Guessing_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1; // Minimum number in the guessing range
        int maxRange = 100; // Maximum number in the guessing range
        int maxAttempts = 3; // Maximum number of attempts allowed
        int score = 0; // Player's score based on the number of attempts

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange; // Generate a random number
            int guess;
            int attempts = 0;

            System.out
                    .println("I've selected a number between " + minRange + " and " + maxRange + ". Try to guess it!");

            boolean guessedCorrectly = false;

            while (!guessedCorrectly && attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++; // Increment the attempts counter

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                    guessedCorrectly = true;
                } else if (guess < targetNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've exceeded the maximum number of attempts.");
            }

            score += attempts; // Update the player's score
            System.out.println("It took you " + attempts + " attempts to guess the number.");
            System.out.println("Your current score is: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing the Number Guessing Game!");
    }
}
