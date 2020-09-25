package com.adobe.panchtantra.exception;

public class InvalidPackageException extends RuntimeException {

    private String message;

    public InvalidPackageException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
