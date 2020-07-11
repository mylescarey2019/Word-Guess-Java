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

        gameLogic.processGuess('A');
        gameLogic.diagnosticSummary();
        gameLogic.processGuess('X');
        gameLogic.diagnosticSummary();
        gameLogic.processGuess('C');
        gameLogic.diagnosticSummary();
        gameLogic.processGuess('K');
        gameLogic.diagnosticSummary();

        while (gameLogic.currentWord != null)  {
            System.out.println("Word remaining: " + gameLogic.wordPool.isWordRemaining());
            gameLogic.wordPool.showWords();
            gameLogic.diagnosticSummary();
            gameLogic.nextWord();
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
