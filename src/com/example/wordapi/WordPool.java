package com.example.wordapi;

public class WordPool {
    // placeholder method
    public void summary() {
        System.out.println("in com.example.wordapi.WordPool class object summary method");

        // placeholder puzzle word :
        String puzzleName = "HARRY S TRUMAN";
        Word word = new Word(puzzleName);
        System.out.println(".......Puzzle Word is: " + word.getDisplayableWord());
        System.out.println("Solved Puzzle Word is: " + word.getSolvedDisplayableWord());

        //word.summary();
    }
}
