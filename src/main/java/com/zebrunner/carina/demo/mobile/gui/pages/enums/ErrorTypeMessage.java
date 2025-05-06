package com.zebrunner.carina.demo.mobile.gui.pages.enums;

public enum ErrorTypeMessage {
    INVALID("Username and password do not match any user in this service."),
    LOCKED_OUT("Sorry, this user has been locked out.");

    public final String message;

    private ErrorTypeMessage(String message){
        this.message=message;
    }
}