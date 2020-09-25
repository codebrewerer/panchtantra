package com.adobe.panchtantra.exception;

public class PackageNotFoundException extends RuntimeException {
    private String message;

    public PackageNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
