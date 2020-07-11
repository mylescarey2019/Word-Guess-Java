package com.example.wordgame;

import com.example.wordapi.Word;
import com.example.wordapi.WordPool;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    // placeholder method
    public void playGame() {
        System.out.println("in com.example.wordgame.Game class object summary method");
        ArrayList<String> puzzleList = new ArrayList<String>(Arrays.asList("JAMES POLK",
                "FRANKLIN D ROOSEVELT", "BARACK OBAMA"));
        GameLogic gameLogic = new GameLogic(puzzleList);

        //WordPool wordPool = new WordPool(puzzleList);
        gameLogic.processGuess('a');
        gameLogic.diagnosticSummary();
        gameLogic.processGuess('x');
        gameLogic.diagnosticSummary();
        gameLogic.processGuess('a');
        gameLogic.diagnosticSummary();
        gameLogic.processGuess('k');
        gameLogic.diagnosticSummary();

        while (gameLogic.hasWordToPlay) {
            gameLogic.wordPool.showWords();
            gameLogic.diagnosticSummary();
            gameLogic.hasWordToPlay = false;  // don't know if game has any words left yet
            if (gameLogic.wordPool.isWordRemaining()) {
                gameLogic.nextWord();
            }
        }

        System.out.println("no more words left ");

//        //Word word1 = gameLogic.wordPool.getWordFromPool();
//        System.out.println("Word remaining: " + gameLogic.wordPool.isWordRemaining());
//        gameLogic.wordPool.showWords();
//        Word word2 = gameLogic.wordPool.getWordFromPool();
//        System.out.println("Word remaining: " + gameLogic.wordPool.isWordRemaining());
//        gameLogic.wordPool.showWords();
//        Word word3 = gameLogic.wordPool.getWordFromPool();
//        System.out.println("Word remaining: " + gameLogic.wordPool.isWordRemaining());
//        gameLogic.wordPool.showWords();
//        Word word4 = gameLogic.wordPool.getWordFromPool();
//        if (word4 == null) {
//            System.out.println("no more words left ");
//        }
    }
}
