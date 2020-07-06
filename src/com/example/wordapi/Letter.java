package com.example.wordapi;

// class for letter in the puzzle's word
// letter starts unknown to player unless it is a space between names or initials
public class Letter {
    private char _letter;
    private boolean _isKnown;

    public Letter(char letter) {
        this._letter = letter;
        this._isKnown = letter == ' ';
    }

    // getter - if letter is not known display an underscore
    public char getLetter() {
        return _isKnown ? _letter : '-';
    }

    // temporary helper method
    public char peakLetter() {
        return _letter;
    }

    // a method acting as a 'setter' for _isKnown property
    public void guessLetter(char letter) {
        _isKnown = Character.toUpperCase(letter) == Character.toUpperCase(_letter) || getIsKnown();
    }

    public boolean getIsKnown() {
        return _isKnown;
    }

    // force the letter to known state without guessing
    public void forceReveal() {
        _isKnown = true;
    }

    // placeholder method
    public void summary() {
        System.out.println("in com.example.wordapi.Letter class object summary method");
        System.out.println("in com.example.wordapi.Letter is: " + getLetter() + " is known is: " + getIsKnown() +
                " revealed value is: " + peakLetter());
    }
}
