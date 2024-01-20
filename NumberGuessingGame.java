import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        playNumberGuessingGame();
    }
       
    private static void playNumberGuessingGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1 ) + lowerBound;
        int maxAttempts = 10; 
        int attempts = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between " + lowerBound + " and " + upperBound);

        do {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == numberToGuess) {
                System.out.println("Congratulatons! You guessed the correct number in  " + attempts + " attempts. ");
                score++;
                System.out.println("Your current score:" +score);

                System.out.println("Do you want to play again? (yes/no): ");
                String playAgain = scanner.next().toLowerCase();

                if (playAgain.equals("yes")) {
                    numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
                    attempts = 0;
                        
                } else {
                    System.out.println("Thanks for playing. Your final score:" +score);
                    break;
                }
            }
                else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");

                }
                
                else{
                    System.out.println("Too high! try again.");
                }
                
                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've reached the maximun number of attempts. the correct number was  " + numberToGuess);
                    System.out.println("Do you want to play again? (yes/no):");
                    String playAgain = scanner.next().toLowerCase();

                    if(playAgain.equals("yes")) {
                        numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
                        attempts = 0;
                    }else {
                        System.out.println("Thanks for playing. Your final score: " + score);
                        break;
                    }
                }

            
        }while (true); 
                
        scanner.close();
    }
}


   




    
