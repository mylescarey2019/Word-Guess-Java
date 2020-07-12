package com.example.wordgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    // placeholder method
    public void playGame() {
        // terminal input
        Scanner scan = new Scanner(System.in);
        char keyStroke;

//        ArrayList<String> presidentNames = new ArrayList<String>(Arrays.asList("JAMES POLK",
//                "FRANKLIN D ROOSEVELT", "BARACK OBAMA"));
        // full word list
        ArrayList<String> presidentNames2 = new ArrayList<String>(Arrays.asList("GEORGE WASHINGTON","JOHN ADAMS","THOMAS JEFFERSON",
                "JAMES MADISON","JAMES MONROE","JOHN QUINCY ADAMS","ANDREW JACKSON","MARTIN VAN BUREN","WILLIAM HARRISON",
                "JOHN TYLER","JAMES POLK","ZACHARY TAYLOR","MILLARD FILLMORE","FRANKLIN PIERCE","JAMES BUCHANAN","ABRAHAM LINCOLN","ANDREW JOHNSON",
                "ULYSSES S GRANT","RUTHERFORD B HAYES","JAMES GARFIELD",
                "CHESTER ARTHUR","GROVER CLEVELAND","BENJAMIN HARRISON","WILLIAM MCKINLEY","THEODORE ROOSEVELT","WILLIAM H TAFT",
                "WOODROW WILSON", "WARREN HARDING","CALVIN COOLIDGE","HERBERT HOOVER",
                "FRANKLIN D ROOSEVELT","HARRY S TRUMAN","DWIGHT EISENHOWER","JOHN F KENNEDY","LYNDON JOHNSON","RICHARD NIXON","GERALD FORD",
                "JIMMY CARTER","RONALD REAGAN","GEORGE H W BUSH","BILL CLINTON","GEORGE W BUSH","BARACK OBAMA","DONALD TRUMP"));


        ArrayList<String> presidentNames = new ArrayList<String>(Arrays.asList("MILO","RUSSELL","GEORGE","SHERMAN","SMOKEY"));

        GameLogic gameLogic = new GameLogic(presidentNames);

        //WordPool wordPool = new WordPool(puzzleList);
//        gameLogic.processGuess('t');
//        gameLogic.diagnosticSummary();
//        gameLogic.processGuess('x');
//        gameLogic.diagnosticSummary();
//        gameLogic.processGuess('T');
////        gameLogic.diagnosticSummary();
////        gameLogic.processGuess('e');
////        gameLogic.diagnosticSummary();
////        gameLogic.processGuess('s');
////        gameLogic.diagnosticSummary();
////        gameLogic.processGuess('o');
//        gameLogic.diagnosticSummary();
//        gameLogic.processGuess('w');
//        gameLogic.diagnosticSummary();
//        gameLogic.processGuess('n');
//        gameLogic.diagnosticSummary();
//        gameLogic.processGuess('q');
//        gameLogic.diagnosticSummary();
//        gameLogic.processGuess('y');
//        gameLogic.diagnosticSummary();
//        gameLogic.processGuess('S');
////        gameLogic.diagnosticSummary();
////        gameLogic.processGuess('s');
////        gameLogic.diagnosticSummary();
////        gameLogic.processGuess('o');

        while (gameLogic.hasWordToPlay) {

            // TO-DO
            // ********************************************
            // terminal input goes here
            System.out.println("\nEnter a letter 'a' through 'z'\n");
            keyStroke = scan.next().charAt(0);
            gameLogic.processGuess(keyStroke);

            // gameLogic.processGuess(letter) goes here
            // ********************************************

            if (gameLogic.state == GameState.GOTONEXTWORD) {
                gameLogic.hasWordToPlay = false; // don't know if game will have any words left
                if (gameLogic.wordPool.isWordRemaining()) {
                    gameLogic.nextWord(); // will get next word and also toggle game.hasWord to true
                    System.out.println("The next name is [" + gameLogic.currentWord.getDisplayableWord() + "]");
                }
            }
//            gameLogic.wordPool.showWords();
//            gameLogic.diagnosticSummary();
//            gameLogic.hasWordToPlay = false;  // don't know if game has any words left yet
//            if (gameLogic.wordPool.isWordRemaining()) {
//                gameLogic.nextWord();
//            }
        }

        // all names have been played
        System.out.println("\nGame over - all 44 names have been played");
        System.out.println("\nThank you for playing, your final score is, Wins: " + gameLogic.wordsWon + " Losses: " + gameLogic.wordsLost);

//        System.out.println("no more words left ");

//        //Word word1 = gameLogic.wordPool.getWordFromPool();
//        System.out.println("Word remaining: " + gameLogic.wordPool.isWordRemaining());
//        gameLogic.wordPool.showWords();
//        Word word2 = gameLogic.wordPool.getWordFromPool();
//        System.out.println("Word remaining: " + gameLogic.wordPool.isWordRemaining());
//        gameLogic.wordPool.showWords();
//        Word word3 = gameLogic.wordPool.getWordFromPool();
//        System.out.println("Word remaining: " + gameLogic.wordPool.isWordRemaining());
//        gameLogic.wordPool.showWords();
//        Word word4 = gameLogic.wordPool.getWordFromPool();
//        if (word4 == null) {
//            System.out.println("no more words left ");
//        }
    }
}
