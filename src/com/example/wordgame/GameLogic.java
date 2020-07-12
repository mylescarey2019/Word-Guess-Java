package com.example.wordgame;

import com.example.wordapi.Word;
import com.example.wordapi.WordPool;

import java.util.ArrayList;
import java.util.stream.Collectors;


// class for game logic
// this contains the core letter guessing logic, tracks game score, and draws down the word pool
public class GameLogic {
    //private WordPool wordPool; // temporally made public - revert to private when ready
    public WordPool wordPool;  // temporally made public - revert to private when ready
    public Word currentWord;
    private int guesses;
    public GameState state;
    private String savedDisplayableWord;
    public int wordsWon;
    public int wordsLost;
    private ArrayList<Character> lettersGuessed = new ArrayList<Character>();
    public boolean hasWordToPlay; // a word has been retrieved by method getWordFromPool and is ready for use

    public GameLogic(ArrayList<String> puzzleWordList ) {
        wordPool = new WordPool(puzzleWordList);
        guesses = 6;
        wordsWon = 0;
        wordsLost = 0;
        state = GameState.GOTONEXTWORD;
        savedDisplayableWord = "";

        // temp debug output REMOVE* - when all testing done
//            System.out.println("Word remaining: " + wordPool.isWordRemaining());
//            wordPool.showWords();

        nextWord();  // gets next word from wordpool, sets savedDisplayableWord, guesses, etc.

        //System.out.println("\nWelcome to Word Guess - US Presidential Edition");
        System.out.println("Solve each of the " + Game.nameCount + " US president name puzzles, use keyboard A through Z");
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

    // String version of the guessed char list
    private String guessedLetterString() {
        return lettersGuessed.stream()
                .map(letter -> letter.toString())
                .collect(Collectors.joining());
    }

    // helper function to check to if guess key pressed is valid letter or not
    private GuessPreCheckResult validateGuess(char letter) {
        boolean isGuessValid = true;
        String errorMsg = "";

        if (Character.toString(letter).matches("[a-zA-Z]")) {
            if(lettersGuessed.contains(Character.toUpperCase(letter))) {
                isGuessValid = false;
                errorMsg = "'" + letter + "' has already been used.  Letters used: " + guessedLetterString();
            }
        } else {
            isGuessValid = false;
            errorMsg = "You typed '" + letter + "' please type 'a' through 'z'";
        }
        return new GuessPreCheckResult(isGuessValid,errorMsg);
    }

    // helper function to display first line of guess result on console: whether hit or miss
    private void printGuessResult(boolean isHit, boolean roundOver, char letter, String displayWord) {
        String message = "'" + Character.toUpperCase(letter) + "'";
        message += (isHit) ? " is a Hit." :  " is a Miss.";
        message += (roundOver)
                ? ""
                : "  Name is [ " +  displayWord + "]  Guesses remaining: " + guesses
                + "   Letters used: " + guessedLetterString();
        System.out.println(message);
    }

    // helper function to, if applicable, display 2nd line of guess result on console : word solved or out of guesses
    private void printWordEndResult(boolean isSolved, boolean gameOver) {
        String message = "";
        message += (isSolved) ? "You solved it. Name was [ " : "Out of guesses.  The name was [ ";
        message += currentWord.getSolvedDisplayableWord();
        message += (gameOver) ? " ]" : " ]  Your score is, Wins: " +  wordsWon + " Losses: " +  wordsLost;
        System.out.println(message);
    }

    // core logic for handling letter guess and puzzle state
    public void processGuess(char letterGuess) {
        // initial check on the guessed key pressed
        GuessPreCheckResult results = validateGuess(letterGuess);
        boolean validGuess = results.isValid();
        String guessErrorMsg = results.getMessage();

        if (validGuess) {
            //guess is a valid A-Z  - update the word object and used letter array
            currentWord.updateWord(letterGuess);
            lettersGuessed.add(Character.toUpperCase(letterGuess));
        } else {
            state = GameState.KEEPGUESSING;
            System.out.println(guessErrorMsg);
            return;
        }

        // check for hit or miss : compare saved displayable word vs its new state; different = hit
        boolean isWordSolved = false;
        String newDisplayableWord;
        newDisplayableWord = currentWord.getDisplayableWord();
        boolean isHit = !(savedDisplayableWord.equals(newDisplayableWord));  // guess is a hit
        if (isHit) {
            // reset saved displayable word to the new word state, then capture whether it was solved
            savedDisplayableWord = newDisplayableWord;
            isWordSolved = currentWord.isSolved();
            printGuessResult(isHit, isWordSolved, letterGuess, newDisplayableWord);
        } else { // guess is a miss
            guesses--;
            printGuessResult(isHit, guesses == 0, letterGuess, newDisplayableWord);
        }

        // check to see if 2nd line of guess result needs to be displayed:  word solved or out of guesses
        boolean isGameOver = !wordPool.isWordRemaining();
        if (isWordSolved) {
            wordsWon++;
            state = GameState.GOTONEXTWORD;
            printWordEndResult(isWordSolved,isGameOver);
        } else { // not solved - see if out of guesses
            if (guesses == 0) {
                wordsLost++;
                state = GameState.GOTONEXTWORD;
                printWordEndResult(isWordSolved,isGameOver);
            }
            else { // still have guesses remaining
                state = GameState.KEEPGUESSING;
            }
        }
    }
}
