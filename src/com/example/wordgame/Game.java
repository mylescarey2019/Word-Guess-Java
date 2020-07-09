package com.example.wordgame;

import com.example.wordapi.Word;
import com.example.wordapi.WordPool;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    // placeholder method
    public void summary() {
        System.out.println("in com.example.wordgame.Game class object summary method");
        ArrayList<String> puzzleList = new ArrayList<String>(Arrays.asList("JAMES POLK",
                "BARACK OBAMA","RONALD REAGAN"));
        WordPool wordPool = new WordPool(puzzleList);
        System.out.println("Word remaining: " + wordPool.isWordRemaining());
        wordPool.showWords();
        Word word1 = wordPool.getWordFromPool();
        System.out.println("Word remaining: " + wordPool.isWordRemaining());
        wordPool.showWords();
        Word word2 = wordPool.getWordFromPool();
        System.out.println("Word remaining: " + wordPool.isWordRemaining());
        wordPool.showWords();
        Word word3 = wordPool.getWordFromPool();
        System.out.println("Word remaining: " + wordPool.isWordRemaining());
        wordPool.showWords();
        Word word4 = wordPool.getWordFromPool();
        if (word4 == null) {
            System.out.println("no more words left ");
        }


//        wordPool.summary();
        GuessLogic guess = new GuessLogic();
        guess.summary();
    }
}
