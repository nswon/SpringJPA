package com.example.exception.dto;

public class Error {

    private String field;
    private String message;
    private String invalidVale;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInvalidVale() {
        return invalidVale;
    }

    public void setInvalidVale(String invalidVale) {
        this.invalidVale = invalidVale;
    }


}
