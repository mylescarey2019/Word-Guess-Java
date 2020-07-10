package com.example.wordgame;

import com.example.wordapi.Word;
import com.example.wordapi.WordPool;

import java.util.ArrayList;

// class for game logic
// this contains the core letter guessing logic, tracks game score, and draws down the word pool
public class GameLogic {
    private ArrayList<String> puzzleWordList;
    //private WordPool wordPool;
    public WordPool wordPool;  // temporally made public
    public Word currentWord;
    private int guesses;
    public GameState state;
    private String savedDisplayableWord;
    public int wordsWon;
    public int wordLost;
    private char[] lettersGuessed;

    public GameLogic(ArrayList<String> puzzleWordList ) {
        wordPool = new WordPool(puzzleWordList);
        guesses = 6;
        wordsWon = 0;
        wordLost = 0;
        state = GameState.GOTONEXTWORD;
        savedDisplayableWord = "";

        // temp debug output
            System.out.println("Word remaining: " + wordPool.isWordRemaining());
            wordPool.showWords();
        //

        currentWord = wordPool.getWordFromPool(); // Word object
        if (currentWord != null) {
            savedDisplayableWord = currentWord.getDisplayableWord();
        }

        System.out.println("\nWelcome to Word Guess - US Presidential Edition");
        System.out.println("Solve each of the 44 president name puzzles, use keyboard A through Z");
        System.out.println("You lose the word if you accumulate 6 missed guesses, lets begin.");
        System.out.println("\nThe first name is [" +  savedDisplayableWord + "]");
    }

    public void processGuess(char letterGuess) {
        // to-do learn how to leverage inner class methods for use in outer method
        // learn lambdas to see if they are applicable here
        class GuessHelpers {
            public void validateGuess(char letter) {}  // will need to return boolean & String
            public void printGuessResult(boolean isHit, boolean roundOver) {}
            public void printWordEndResult(boolean isSolved, boolean gameOver) {}
        }

        // main logic of processGuess goes here and needs to utilize the GuessHelper methods
    }



    // placeholder method
    public void summary() {
        System.out.println("in com.example.wordgame.GuessLogic class object summary method");
    }
}
