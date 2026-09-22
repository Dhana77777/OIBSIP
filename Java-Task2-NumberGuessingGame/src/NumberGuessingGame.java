import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int round = 1;
        int totalScore = 0;
        String playAgain = "yes";

        System.out.println("=================================");
        System.out.println("     NUMBER GUESSING GAME");
        System.out.println("=================================");

        while (playAgain.equalsIgnoreCase("yes")) {

            int secretNumber = random.nextInt(100) + 1;
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n----- Round " + round + " -----");
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");

                // Validate that the user enters a number
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.next();
                    continue;
                }

                int guess = scanner.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                attempts++;

                if (guess == secretNumber) {

                    guessedCorrectly = true;

                    int score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;

                    System.out.println("Correct! 🎉");
                    System.out.println("You guessed the number in "
                            + attempts + " attempts.");
                    System.out.println("Round Score: " + score);

                    break;

                } else if (guess < secretNumber) {

                    System.out.println("Too Low! Try a higher number.");

                } else {

                    System.out.println("Too High! Try a lower number.");
                }

                System.out.println("Attempts remaining: "
                        + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {

                System.out.println("\nYou Lost! 😔");
                System.out.println("The correct number was: "
                        + secretNumber);
            }

            System.out.println("\n=================================");
            System.out.println("Round " + round + " completed.");
            System.out.println("Total Score: " + totalScore);
            System.out.println("=================================");

            System.out.print("\nDo you want to play again? (yes/no): ");
            playAgain = scanner.next();

            round++;
        }

        System.out.println("\n=================================");
        System.out.println("        GAME OVER");
        System.out.println("Final Score: " + totalScore);
        System.out.println("Thanks for playing!");
        System.out.println("=================================");

        scanner.close();
    }
}
