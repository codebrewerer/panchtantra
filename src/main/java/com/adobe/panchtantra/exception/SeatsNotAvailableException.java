package com.adobe.panchtantra.exception;

public class SeatsNotAvailableException extends RuntimeException {

    private String message;

    public SeatsNotAvailableException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
