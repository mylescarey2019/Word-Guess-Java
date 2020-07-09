package com.example.wordapi;

import java.util.ArrayList;
import java.util.Arrays;

// class for pool of word objects that are the game's president names
// takes a array of names, uses them to create array of word objects in this pool object
public class WordPool {
    private ArrayList<Word> words = new ArrayList<Word>();

    public WordPool(ArrayList<String> puzzleWordList) {
        // randomly pull name from the puzzle list parameter, instantiate new word object, push into words array
        // remove name from puzzle list parameter - continue until all names created as word objects
        int listLength = puzzleWordList.size();
        for (int i = 0; i < listLength; i++) {
            int nextNameIndex = (int) (Math.floor(Math.random() * puzzleWordList.size()));
            words.add(new Word(puzzleWordList.get(nextNameIndex)));
            puzzleWordList.remove(nextNameIndex);
        }
    }

    // returns whether any words objects remain in the word pool
    public boolean isWordRemaining() {
        return (words.size() > 0) ? true : false;
    }

    // remove and return next word object from pool,
    // return undefined if empty - pop works in javascript - will need to see
    // if out-of-bounds handling is necessary
    public Word getWordFromPool() {
        return (words.size() > 0) ? words.remove(words.size() - 1) : null ;
    }

    // diagnostic word pool dump - show word string from each word object in pool
    public void showWords() {
        int endIndex = (words.size() > 0) ? words.size() : -1;
        for (int i = 0; i < endIndex; i++) {
            System.out.println("word " + i + " is " + words.get(i).showOriginalWordString());
        }
    }

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
