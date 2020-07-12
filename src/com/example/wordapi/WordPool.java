package com.example.wordapi;

import com.example.wordgame.Game;

import java.util.ArrayList;

// class for pool of word objects that are the game's president names
// takes an array of names, uses them to create array of word objects in this pool object
public class WordPool {
    private ArrayList<Word> words = new ArrayList<Word>();

    public WordPool(ArrayList<String> puzzleWordList) {
        // for user chosen number of names to guess:
        // randomly pull name from the puzzle list parameter, instantiate new word object, push into words array
        // remove name from puzzle list parameter - continue until all names created as word objects

        for (int i = 0; i < Game.nameCount; i++) {
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
    public Word getWordFromPool() {
        return words.remove(words.size() - 1);
    }

    // diagnostic word pool dump - show word string from each word object in pool
    // REMOVE* after all testing
    public void showWords() {
        int endIndex = (words.size() > 0) ? words.size() : -1;
        for (int i = 0; i < endIndex; i++) {
            System.out.println("word " + i + " is " + words.get(i).showOriginalWordString());
        }
    }
}
