package com.example.wordgame;

import com.example.wordapi.WordPool;

public class Game {
    // placeholder method
    public void summary() {
        System.out.println("in com.example.wordgame.Game class object summary method");
        WordPool wordPool = new WordPool();
        wordPool.summary();
        GuessLogic guess = new GuessLogic();
        guess.summary();
    }
}
