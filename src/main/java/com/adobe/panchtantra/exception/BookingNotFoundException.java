package com.adobe.panchtantra.exception;

public class BookingNotFoundException extends RuntimeException {

    private String message;

    public BookingNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
