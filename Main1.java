import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        boolean playAgain = true;
        int score = 0;
        while (playAgain) {
            int numberguess = ran.nextInt(100) + 1; 
            int attempts = 0;
            int maxAttempts = 5;
            boolean guessedCorrect = false;
            System.out.println("Guess the number between 1 and 100. You have " + maxAttempts + " attempts.");
            while (attempts < maxAttempts && !guessedCorrect) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;
                if (userGuess == numberguess) {
                    guessedCorrect = true;
                    score += (maxAttempts - attempts + 1); 
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                } else if (userGuess < numberguess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            if (!guessedCorrect) {
                System.out.println("Sorry! You've used all your attempts. The correct number was " + numberguess);
            }
            System.out.println("Your current score is: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String response = sc.next();
            playAgain = response.equalsIgnoreCase("yes");
        }
       System.out.println("Thanks for playing! Your final score is: " + score);
        sc.close();
    }
}