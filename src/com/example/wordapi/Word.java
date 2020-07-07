package com.example.wordapi;
import java.util.ArrayList;

// class for a president name in the puzzle
// takes string parameter and creates property array of Letter objects
public class Word {
    private ArrayList<Letter> letters = new ArrayList<Letter>();
    private String originalWord;

    public Word(String word) {
        originalWord = word;
        // building a character array of parameter word string
        // iterating over array adding a Letter Class object for each character
        char[] wordChars = originalWord.toCharArray();
        for (char ch : wordChars) {
            letters.add(new Letter(ch));
        }
    }

    // update the word's letters following a guess attempt
    // iterate over this.letters array and call guessLetter() for each letter
    // this will set isKnown to true if the letter == guessedLetter
    public void updateWord(char guessedLetter) {
        for (Letter letter : letters) {
            letter.guessLetter(guessedLetter);
        }
    }

    // return formatted string ready for use on the terminal
    // has 2 spaces between letters and 4 spaces between words or initials
    // example: 'H  A  R  R  R  Y    S    T  R  U  M  A  N'
    // example: '_  _  _  _  _  _    _    _  _  _  _  _  _'
    public String getDisplayableWord() {
        // 1.  iterate over letters object array
        // 2.  if character is space then add 4 spaces to the return
        // 3.  if not last non-space character add it and 2 spaces to the return
        // 4.  if last non-space character add it to the return
        // 5.  return the built string
        String displayableWord = "";
        int i = 0;
        for (Letter letter : letters) {
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
        // force the isKnown property to true for all letters
        for (Letter letter : letters) {
            letter.forceReveal();
        }
        return this.getDisplayableWord();
    }

    // is the word solved
    public boolean isSolved() {
        for (Letter letter : letters) {
            if (!letter.getIsKnown()) {
                return false;
            }
        }
        return true;
    }

    // diagnostic display of word's letters array
    public void showWordLetters() {

        for (Letter letter : letters) {
            System.out.println("Original word is: " +  originalWord + "...Letter is: "
                    + letter.getLetter() + " is known: " + letter.getIsKnown());
        }
    }

    // placeholder method
    public void summary() {
        System.out.println("in com.example.wordapi.Word class object summary method");
        Letter letter = new Letter('Q');
        letter.summary();
        Letter letter2 = new Letter(' ');
        letter2.summary();
    }
}