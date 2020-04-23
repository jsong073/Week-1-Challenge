/*
This program will simulate a game of dice
Players will randomly roll two dice. The sum of the dice rolls will be added to the player's score.
If one of the dice rolls a 1, there will be no points added to the player's score. If both dice roll a 1, 25 points are
added.
When the score reaches 100+, the game ends.
Variables:
    a. A randomizer
    b. Two ints to hold the dice rolls
    c. One int to hold the score
    d. (Maybe) a boolean to check if both dice rolled a 1
    e. A String to record the user's response
    f. A boolean to check if the game will continue
Process:
    a. A loop will be needed, which continues as long as the player says "yes" to rolling again, and the score is less
    than 100.
    b. Inside the loop, the two ints that hold dice rolls (diceRoll1 and diceRoll2) will be assigned a random value
    between 1 and 6.
    c. IF both diceRoll1 and diceRoll2 equal 1 THEN
        add 25 to score
       ELSEIF diceRoll1 or diceRoll2 equal 1 THEN
        add 0 to score
       ELSE
        add the sum of diceRoll1 and diceRoll2 to score
       ENDIF
    d. Ask the user if they want to roll again
        i. IF user types "yes" THEN
                Set boolean continueGame to true
           ELSE
                Set boolean continueGame to false

 */

import java.util.Random;
import java.util.Scanner;

public class GameOfDice {
    public static void main (String[] args) {
        //Variables
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int diceRoll1 = 0;
        int diceRoll2 = 0;
        boolean continueGame = true;
        String userResponse = "";

        //explains the rules and starts the game
        System.out.println("Welcome. Let's play a Game of Dice.");
        System.out.println("THE RULES: Two dice will be rolled. Their total will be added to your score. You win when" +
                " you hit 100.");
        System.out.println("\t\t\tIf you get 1 on either of your dice, you score nothing. However, if you roll 1 on both" +
                " of your dice, you score 25.");
        System.out.println();
        System.out.println("Ready? Let's begin.");
        do {
            diceRoll1 = 1 + random.nextInt(6);
            diceRoll2 = 1 + random.nextInt(6);
            /*
            IF both dice rolls equal 1 THEN
                add 25 to score
            ELSEIF either dice roll equals 1 THEN
                add 0 to score. Due to the first conditional, this ELSEIF only comes into play if only one dice
                rolls a 1
            ELSE
                add the dice rolls to the score
             */
            if (diceRoll1 == 1 && diceRoll2 == 1) {
                score += 25;
            } else if (diceRoll1 == 1 || diceRoll2 == 1) {
                score += 0;
            } else {
                score += (diceRoll1 + diceRoll2);
            }

            //Prints out the rolls and the score
            System.out.println("Your rolls: " + diceRoll1 + " & " + diceRoll2);
            System.out.println("Score: " + score);

            /*
            IF score is less than 100
                Prompts the user to roll again or quit.
            ENDIF
             */
            if (score < 100) {
                System.out.print("Roll again? (Y/N)? ");
                userResponse = input.nextLine();

                //This while loop ensures the only answers that go through will be either "y" or "n"
                while ((userResponse.equalsIgnoreCase("y") ||
                        userResponse.equalsIgnoreCase("n")) == false) {
                    System.out.print("Please enter \"Y\" or \"N\". Roll again (Y/N)? ");
                    userResponse = input.nextLine();
                }
                /*
                IF user enters "y" THEN
                    set continueGame to true, which should continue the loop as long as score is still less than 100
                ELSE
                    set continueGame to false, which should break the loop
                ENDIF
                */
                if (userResponse.equalsIgnoreCase("y")) {
                    continueGame = true;
                } else {
                    continueGame = false;
                }
            }

            System.out.println();

        } while (continueGame == true && score < 100);

        if (score >= 100) {
            System.out.println("You have scored " + score + ". You win!");
        }
        System.out.println("Thanks for playing. Goodbye.");
    }
}
