package com.adobe.panchtantra.exception;

public class InventoryNotFoundException extends RuntimeException {

    private String message;

    public InventoryNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
