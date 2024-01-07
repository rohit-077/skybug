package skybug;

import java.util.Scanner;

public class GuessGame {

    public static void main(String[] args) {
        playGuessGame();
    }

    public static void playGuessGame() {
        int maxCount = 7;
        int rounds = 0;
        int totalAttempts = 0;

        while (true) {
            int target = (int) (Math.random() * 100) + 1;
            int count = 0;

            while (count < maxCount) {
                count++;
                totalAttempts++;

                System.out.println("Guess a number from 1 to 100: ");
                Scanner sc = new Scanner(System.in);
                int guessed = sc.nextInt();

                if (guessed < target) {
                    System.out.println("Your guess is lower than the target!\nYou have " + (maxCount - count) + " attempts left!");
                } else if (guessed > target) {
                    System.out.println("Your guess is higher than the target!\nYou have " + (maxCount - count) + " attempts left!");
                } else {
                    System.out.println(guessed + " is the right answer!");
                    System.out.println("You guessed the number in " + count + " attempts.");
                    if (playAgain()) {
                        rounds++;
                        break;
                    } else {
                        System.out.println("Thanks for playing! Your total score is: " + totalAttempts + " attempts in " + rounds + " rounds.");
                        return;
                    }
                }
            }

            System.out.println("You have exceeded the limit for attempts! \nBetter luck next time");
            if (!playAgain()) {
                System.out.println("Thanks for playing! Your total score is: " + totalAttempts + " attempts in " + rounds + " rounds.");
                break;
            }
        }
    }

    public static boolean playAgain() {
        System.out.println("Enter true if you want to play again or enter false if you don't want to continue");
        Scanner ss = new Scanner(System.in);
        boolean playAgain;
        try {
            playAgain = ss.nextBoolean();
        } catch (Exception e) {
            System.out.println("Enter either true or false!");
            playAgain = playAgain();
        }
        return playAgain;
    }
}