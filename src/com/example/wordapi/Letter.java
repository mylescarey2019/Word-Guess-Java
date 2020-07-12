package com.example.wordapi;

// class for letter in the puzzle's word
// letter starts unknown to player unless it is a space between names or initials
public class Letter {
    private char letter;
    private boolean known;

    public Letter(char letter) {
        this.letter = letter;
        this.known = letter == ' ';
    }

    // getter - if letter is not known display an underscore
    public char getLetter() {
        return this.known ? this.letter : '-';
    }

    // a method acting as a 'setter' for isKnown property
    public void guessLetter(char letter) {
        this.known = Character.toUpperCase(letter) == Character.toUpperCase(this.letter) || isKnown();
    }

    // getter
    public boolean isKnown() {
        return this.known;
    }

    // force the letter to known state without guessing
    public void forceReveal() {
        this.known = true;
    }
}
