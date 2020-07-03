package com.example.wordapi;

public class Letter {
    Character letter;
    Boolean isKnown;

    public Letter(char letter) {
        this.letter = letter;
        this.isKnown = (letter == ' ') ? true : false;
    }

    // placeholder method
    public void summary() {
        System.out.println("in com.example.wordapi.Letter class object summary method");
        System.out.println("in com.example.wordapi.Letter is: " + letter + " is known is: " + isKnown);
    }
}
