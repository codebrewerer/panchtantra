package com.adobe.panchtantra.api;

@javax.annotation.Generated(value = "io.panchtantra.codegen.languages.SpringCodegen", date = "2020-09-24T08:39:55.612Z")

public class ApiException extends Exception{
    private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
