// William G. Greiner
// 11/7/21
// CS 141
// LAB 4; Guessing Game

import java.util.Scanner;
import java.util.Random;

// This program plays a guessing game with the user as many times as
// the user wants and then displays their results after they are done.
public class GuessingGame {

    public final static int MAX_NUM = 100;

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        Random rand = new Random();
        boolean a = true;
        int gameCount = 0;
        int guessCount = 0;
        int best = 0;

        introduction();
        while (a) {
            System.out.println("I'm thinking of a number between 1 and " + MAX_NUM);
            int guesses = game(rand, user);
            System.out.println("Do you want to play again? ");
            String playAgain = user.next();

            if (playAgain.charAt(0) == 'n') {
                a = false;
            } else if (playAgain.charAt(0) == 'N') {
                a = false;
            }

            if (best > guesses || best == 0) {
                best = guesses;
            }
            guessCount += guesses;
            gameCount++;
        }
        results(gameCount, guessCount, best);
    }

    // Introduces the user to the game, and describes the range between
    // which a number will be randomly picked, the number they will guess.
    public static void introduction() {
        System.out.println("This program allows you to play a guessing game.");
        System.out.println("I will think of a number between 1 and ");
        System.out.println(MAX_NUM + " and will allow you to guess until");
        System.out.println("you get it. For each guess, I will tell you");
        System.out.println("whether the right answer is higher or lower");
        System.out.println("than your guess.");
    }

    // Prompts the user to enter their guesses for the game, and checks whether
    // their number is correct or not.
    public static int game(Random rand, Scanner user) {
        boolean b = true;
        int guessCount = 1;
        int num = rand.nextInt(MAX_NUM) + 1;
        while (b) {
            int guess = user.nextInt();
            if (guess > num) {
                System.out.println("It's lower.");
                guessCount++;
            } else if (guess < num) {
                System.out.println("It's higher.");
                guessCount++;
            } else {
                System.out.println("You got it right in " + guessCount + " guesses.");
                b = false;
            }
        }
        return guessCount;
    }

    // Displays the user's results from all of the games they played.
    public static void results(int gameCount, int guessCount, int best) {
        double average = (double) guessCount/gameCount;
        System.out.println("Overall results:");
        System.out.println("\ttotal games = " + gameCount);
        System.out.println("\ttotal guesses = " + guessCount);
        System.out.println("\tguesses/game = " + average);
        System.out.println("\tbest game = " + best);
    }
}
