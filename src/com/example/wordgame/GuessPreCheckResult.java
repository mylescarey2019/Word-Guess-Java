package com.example.wordgame;

// Container Class for guess key-stroke validation
public class GuessPreCheckResult {
    private boolean isValid;
    private String message;

    public GuessPreCheckResult(boolean isValid, String message) {
        this.isValid = isValid;
        this.message = message;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public String getMessage() {
        return message;
    }
 }
