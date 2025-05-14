package com.zebrunner.carina.demo.mobile.gui.pages.enums;

public enum UserType {
    INVALID("dsadsa"),
    LOCKED_OUT("locked_out_user");

    public final String login;

    private UserType(String login){
        this.login=login;
    }
}
