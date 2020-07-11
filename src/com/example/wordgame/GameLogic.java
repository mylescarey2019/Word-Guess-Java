package com.example.wordgame;

import com.example.wordapi.Word;
import com.example.wordapi.WordPool;

import java.util.ArrayList;
import java.util.stream.Collectors;


// class for game logic
// this contains the core letter guessing logic, tracks game score, and draws down the word pool
public class GameLogic {
    // REMOVE* private ArrayList<String> puzzleWordList;
    //private WordPool wordPool;
    public WordPool wordPool;  // temporally made public
    public Word currentWord;
    private int guesses;
    public GameState state;
    private String savedDisplayableWord;
    public int wordsWon;
    public int wordLost;
    private ArrayList<Character> lettersGuessed = new ArrayList<Character>();
    public boolean hasWordToPlay; // a word has been retrieved by method getWordFromPool and is ready for use


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

        nextWord();
        //currentWord = wordPool.getWordFromPool(); // Word object
        //if (currentWord != null) {
        //if (currentWord.isPresent()) {
        //    savedDisplayableWord = currentWord.getDisplayableWord();
        //}

        System.out.println("\nWelcome to Word Guess - US Presidential Edition");
        System.out.println("Solve each of the 44 president name puzzles, use keyboard A through Z");
        System.out.println("You lose the word if you accumulate 6 missed guesses, lets begin.");
        System.out.println("\nThe first name is [" +  savedDisplayableWord + "]");
    }

    // reset guess count, clear used letter array, get next word object from pool
    public void nextWord() {
        guesses = 6;
        lettersGuessed.clear();
        currentWord = wordPool.getWordFromPool();
        hasWordToPlay = true;
        savedDisplayableWord = currentWord.getDisplayableWord();
    }

    public void diagnosticSummary() {
        System.out.println("============");
        System.out.println("Current word is " + currentWord.getDisplayableWord());
        System.out.println("Guess Remaining: " + guesses + " words won: "
            + wordsWon + " words lost: " + wordLost);
        System.out.println("Letters guessed: " + guessedLetterString());
    }

    private String guessedLetterString() {
        return lettersGuessed.stream()
                .map(letter -> letter.toString())
                .collect(Collectors.joining());
    }

    private ValidateGuessResult validateGuess(char letter) {
        boolean valid = true;
        String errorMsg = "";

        if (Character.toString(letter).matches("[a-zA-Z]")) {
            valid = true;
            errorMsg = "You typed '" + letter + "'";
            if(lettersGuessed.contains(Character.toUpperCase(letter))) {
                valid = false;
                errorMsg = "'" + letter + "' has already been used.  Letters used: " + guessedLetterString();
            }
        } else {
            valid = false;
            errorMsg = "You typed '" + letter + "' please type 'a' through 'z'";
        }
        return new ValidateGuessResult(valid,errorMsg);
    }

    private void printGuessResult(boolean isHit, boolean roundOver) {}
    private void printWordEndResult(boolean isSolved, boolean gameOver) {}

    public void processGuess(char letterGuess) {
        ValidateGuessResult results = validateGuess(letterGuess);
        boolean validGuess = results.getIsValid();
        String guessErrorMsg = results.getMessage();

        if (validGuess) {
            lettersGuessed.add(Character.toUpperCase(letterGuess));
        }
        System.out.println(validGuess + " : " + guessErrorMsg);


        //lettersGuessed.add(letterGuess);
        // main logic of processGuess goes here and needs to utilize the GuessHelper methods
    }



    // placeholder method
    public void summary() {
        System.out.println("in com.example.wordgame.GuessLogic class object summary method");
    }
}
