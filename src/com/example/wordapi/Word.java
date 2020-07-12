package com.example.wordapi;
import java.util.ArrayList;

// class for a president name in the puzzle
// takes string parameter and creates property array of Letter objects
public class Word {
    private ArrayList<Letter> letters = new ArrayList<Letter>();
    private String originalWord;  // REMOVE* after all testing - diagnostic only

    public Word(String word) {
        originalWord = word;
        // add a Letter Class object to letters array list
        // for each character in parameter puzzle word string
        char[] wordChars = originalWord.toCharArray();
        for (char ch : wordChars) {
            letters.add(new Letter(ch));
        }
    }

    // update the word's letters following a guess attempt
    // iterate over this.letters array list and call guessLetter() for each letter
    // this will set Letter object property 'known' to true if the letter == guessedLetter
    public void updateWord(char guessedLetter) {
        for (Letter letter : this.letters) {
            letter.guessLetter(guessedLetter);
        }
    }

    // return formatted string ready for use in the terminal
    // has 2 spaces between letters and 4 spaces between words or initials
    // example: 'H  A  R  R  R  Y    S    T  R  U  M  A  N'
    // example: '_  _  _  _  _  _    _    _  _  _  _  _  _'
    public String getDisplayableWord() {
        // 1.  iterate over letters object array list
        // 2.  if character is space then add 4 spaces to the return
        // 3.  if not last non-space character add it and 2 spaces to the return
        // 4.  if last non-space character add it to the return
        // 5.  return the built string
        String displayableWord = "";
        int i = 0;
        for (Letter letter : this.letters) {
            i++;
            if (letter.getLetter() == ' ') {
                displayableWord += "    ";
            } else {
                displayableWord += (i < letters.size()) ? letter.getLetter() + "  " : letter.getLetter();
            }
        }
        return displayableWord;
    }

    // solve the word and return displayable version
    // needed for when user has exhausted all guesses for a word
    public String getSolvedDisplayableWord() {
        // force the known property to true for all letters
        for (Letter letter : this.letters) {
            letter.forceReveal();
        }
        return this.getDisplayableWord();
    }

    // is the word solved
    public boolean isSolved() {
        for (Letter letter : this.letters) {
            if (!letter.isKnown()) {
                return false;
            }
        }
        return true;
    }

    // diagnostic return original word string  - REMOVE* after all testing
    public String showOriginalWordString() {
        return originalWord;
    }

    // diagnostic display of word's letters array - REMOVE* after all testing
    public void showWordLetters() {
        for (Letter letter : this.letters) {
            System.out.println("Original word is: " +  originalWord + "...Letter is: "
                    + letter.getLetter() + " is known: " + letter.isKnown());
        }
    }
}