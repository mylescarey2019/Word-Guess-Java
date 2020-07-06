package com.example.wordapi;
import java.util.ArrayList;

// class for a president name in the puzzle
// takes string parameter and creates property array of Letter objects
public class Word {
    private ArrayList<Letter> letters = new ArrayList<Letter>();

    public Word(String word) {
        // building a character array of parameter word string
        // iterating over array adding a Letter Class object for each character
        char[] wordChars = word.toCharArray();
        for (char ch : wordChars) {
            letters.add(new Letter(ch));
        }
    }


    // return formatted string ready for use on the terminal
    // has 2 spaces between letters and 4 spaces between words or initials
    // example: 'G  E  O  R  G  E    W    B  U  S  H'
    // example: '_  _  _  _  _  _    _    _  _  _  _'
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

    // placeholder method
    public void summary() {
        System.out.println("in com.example.wordapi.Word class object summary method");
        Letter letter = new Letter('Q');
        letter.summary();
        Letter letter2 = new Letter(' ');
        letter2.summary();
    }
}