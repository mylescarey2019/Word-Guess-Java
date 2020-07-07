package com.example.wordapi;

public class WordPool {
    // placeholder method
    public void summary() {
        System.out.println("in com.example.wordapi.WordPool class object summary method");

        // placeholder puzzle word :
        String puzzleName = "HARRY S TRUMAN";
        Word word = new Word(puzzleName);
        System.out.println(".......Puzzle Word is: " + word.getDisplayableWord());
        System.out.println("Is word solved..." + word.isSolved());
        System.out.println("Guessing letter Q");
        word.updateWord('Q');
        System.out.println("Is word solved..." + word.isSolved());
        word.showWordLetters();
        System.out.println("Guessing letter R");
        word.updateWord('R');
        System.out.println("Is word solved..." + word.isSolved());
        word.showWordLetters();
        System.out.println("Force solving the puzzle.  Solved Puzzle Word is: " + word.getSolvedDisplayableWord());
        System.out.println("Is word solved..." + word.isSolved());
        word.showWordLetters();

        //word.summary();
    }
}
