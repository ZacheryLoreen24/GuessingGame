// Programmer: Zachery Loreen
//Date: 1/5/2023
//Assignment: Lab 1 - Guessing Game
// This program will ask if a user wants to play a guessing game, if they do then the program will run until the user wants to stop.
// For extra credit I did... I don't believe there's any extra credit for me to earn here, my program runs perfectly though.
// I got all this working, but I couldn't get... everything works perfect

import java.util.Scanner; //import of scanner
import java.util.*;
public class guessingGame { //start of class
    public static void main(String[] args) { // start of main method

        System.out.println(
                 //line break
                "I will think of a number between 1 and\n100 and will allow you to guess until\nyou get it. " +
                "For each guess, I will tell you\nwhether the right answer is higher or lower\nthan your guess."
                // line break
                 );
        Instructions(); // runs the instructions method
    } // end of main method
    public static void Instructions() { //start of instruction methods, informs the user details of the game
        Scanner scan = new Scanner(System.in);
        String option = "";
        int gamesPlayed = 0;
        int guesses = 0;
        double average = 0;
        int bestGame = 100;
        int current;

        while (!option.equalsIgnoreCase("n") && !option.equalsIgnoreCase("No")
                && !option.equalsIgnoreCase("nope)")) {
            System.out.println("Would you like to play the game?");
            option = scan.nextLine();

            if (option.equalsIgnoreCase("y") || option.equalsIgnoreCase("yes") ||
                    option.equalsIgnoreCase("yeah")) { //start of while loop
                current = playGame();
                gamesPlayed++;
                guesses += current;

                if (current < bestGame) {
                    bestGame = current; } // end of if statement
                    average = (double) guesses / gamesPlayed;

            } else if (option.equalsIgnoreCase("n") || option.equalsIgnoreCase("no") ||
                    option.equalsIgnoreCase("nope")) {

                if (gamesPlayed == 0) {
                    System.out.println("Why won't you play with me? ;(");

                } else {
                    report(guesses, gamesPlayed, average, bestGame); }

                } else {
                System.out.println("Command not recognized, please try again");
                } // end of else statements

        } // end of while loop
    }//end of instructions
    public static int playGame() { // start of playGame method
        Scanner scan = new Scanner(System.in);
        int range = 100;
        int numTries = 0;

        Random rand = new Random(); //computer generates random number
        int randomNumber = rand.nextInt(range) + 1;

        System.out.println("I'm thinking of a number between 1 and " + range);

        int guess = 0;

        while(guess != randomNumber) { // start of while loop
            guess = scan.nextInt();
                if (guess > randomNumber) {
                    System.out.println("Your Guess:" + guess);
                    System.out.println("Mystery number is lower.");
                    numTries++;

                } else if (guess < randomNumber) {
                    System.out.println("Your Guess: " + guess);
                    System.out.println("Mystery number is higher.");
                    numTries++;

                } else {
                    numTries++;
                    System.out.println("Congratulations, you got it in " + numTries + " tries.");
                } // end of else
        } // end of while loop
        return numTries;
    } // end of playGame method
    public static void report(int guesses, int gamesPlayed, double average, int bestGame) { //lists the users game stats
        System.out.println("Overall results:");
        System.out.println("Total Games = " + gamesPlayed); //displays amount of games played
        System.out.println("Total Guesses = " + guesses); //total number of guesses
        System.out.printf("Guesses/Game = %.2f ", average); //average number of guesses per game
        System.out.println("\nBest Game = " + bestGame); // the best game played

    } // end of report method
} //end of class
    