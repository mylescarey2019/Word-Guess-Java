package com.example.wordgame;

public class ValidateGuessResult {
    private boolean isValid;
    private String message;

    public ValidateGuessResult(boolean isValid, String message) {
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
