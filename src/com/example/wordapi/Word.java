package com.example.wordapi;

public class Word {
    // placeholder method
    public void summary() {
        System.out.println("in com.example.wordapi.Word class object summary method");
        Letter letter = new Letter('Q');
        letter.summary();
        Letter letter2 = new Letter(' ');
        letter2.summary();
    }
}