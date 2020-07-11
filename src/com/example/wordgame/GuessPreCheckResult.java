package com.example.wordgame;

public class GuessPreCheckResult {
    private boolean isValid;
    private String message;

    public GuessPreCheckResult(boolean isValid, String message) {
        this.isValid = isValid;
        this.message = message;
    }

    public boolean getIsValid() {
        return isValid;
    }

    public String getMessage() {
        return message;
    }
 }
