package com.example.wordgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// Game play - main/outer logic flow class
public class Game {
    public static int nameCount;
    Scanner scan = new Scanner(System.in);

    // helper method to get number of names player wants to guess
    private int getNameCount(boolean isFirstGame) {
        if (isFirstGame) {
            System.out.println("\nWelcome to Word Guess - US Presidential Edition");
        }

        System.out.println("Enter how many Presidents to guess - between 1 and 44");

        int nameCount = 0;
        boolean needValidCount = true;

        while (needValidCount) {
            while (!scan.hasNextInt()) {
                scan.next();
            }
            nameCount = scan.nextInt();
            scan.nextLine();
            if (nameCount > 0 && nameCount < 45) {
                System.out.println("Very good, lets proceed with " + nameCount + " US Presidents to guess.");
                needValidCount = false;
            } else {
                System.out.println("Enter how many Presidents to guess - between 1 and 44");
            }
        }
        return nameCount;
    }

    // helper method to see if player want to play another game
    private boolean playAgain() {
        char prompt;
        do {
            System.out.println("Play again, y/n ?");
            prompt = scan.next().charAt(0);
        } while (!Character.toString(prompt).matches("[ynYN]"));
        return (prompt == 'y' || prompt == 'Y') ? true : false;
    }


    // main game loop driver - repeat until all words guessed at then ask if user want to play again
    public void playGame() {
        boolean isFirstGame = true;
        boolean playAnotherGame = true;
        char keyStroke;

        // full name list
        ArrayList<String> presidentNames = new ArrayList<String>(Arrays.asList("GEORGE WASHINGTON", "JOHN ADAMS", "THOMAS JEFFERSON",
                "JAMES MADISON", "JAMES MONROE", "JOHN QUINCY ADAMS", "ANDREW JACKSON", "MARTIN VAN BUREN", "WILLIAM HARRISON",
                "JOHN TYLER", "JAMES POLK", "ZACHARY TAYLOR", "MILLARD FILLMORE", "FRANKLIN PIERCE", "JAMES BUCHANAN", "ABRAHAM LINCOLN", "ANDREW JOHNSON",
                "ULYSSES S GRANT", "RUTHERFORD B HAYES", "JAMES GARFIELD",
                "CHESTER ARTHUR", "GROVER CLEVELAND", "BENJAMIN HARRISON", "WILLIAM MCKINLEY", "THEODORE ROOSEVELT", "WILLIAM H TAFT",
                "WOODROW WILSON", "WARREN HARDING", "CALVIN COOLIDGE", "HERBERT HOOVER",
                "FRANKLIN D ROOSEVELT", "HARRY S TRUMAN", "DWIGHT EISENHOWER", "JOHN F KENNEDY", "LYNDON JOHNSON", "RICHARD NIXON", "GERALD FORD",
                "JIMMY CARTER", "RONALD REAGAN", "GEORGE H W BUSH", "BILL CLINTON", "GEORGE W BUSH", "BARACK OBAMA", "DONALD TRUMP"));

        // shortened test name list - the family cats
//        ArrayList<String> presidentNames = new ArrayList<String>(Arrays.asList("MILO", "RUSSELL", "GEORGE", "SHERMAN", "SMOKEY"));

        // create variable for the game/guess logic class
        GameLogic gameLogic;

        while (playAnotherGame) {
            // ask user how many names they want to guess
            this.nameCount = getNameCount(isFirstGame);
            // create a new instance of the game/guess logic
            // Future Refactor opportunity : create game reset method in gameLogic class instead of instantiating a new instance
            gameLogic = new GameLogic(presidentNames);

            while (gameLogic.hasWordToPlay) {
                System.out.println("\nEnter a letter 'a' through 'z'\n");
                keyStroke = scan.next().charAt(0);
                gameLogic.processGuess(keyStroke);

                if (gameLogic.state == GameState.GOTONEXTWORD) {
                    gameLogic.hasWordToPlay = false; // assume no words left until proven otherwise
                    if (gameLogic.wordPool.isWordRemaining()) {
                        gameLogic.nextWord(); // will get next word and also toggle game.hasWordToPlay to true
                        System.out.println("The next name is [" + gameLogic.currentWord.getDisplayableWord() + "]");
                    }
                }
            }

            // all names have been played
            System.out.println("\nGame over - all " + Game.nameCount + " US president names have been played");
            System.out.println("\nYour final score is, Wins: " + gameLogic.wordsWon + " Losses: " + gameLogic.wordsLost);

            isFirstGame = false;
            playAnotherGame = playAgain();
        }
        System.out.println("\nThanks for playing");
    }
}
