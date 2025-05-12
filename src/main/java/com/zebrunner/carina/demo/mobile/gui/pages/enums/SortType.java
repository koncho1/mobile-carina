package com.zebrunner.carina.demo.mobile.gui.pages.enums;

public enum SortType {
    LOWHIGH("Price (low to high)"),
    HIGHLOW("Price (high to low)"),
    ATOZ("Name (A to Z)"),
    ZTOA("Name (Z to A)");

    public final String type;

    private SortType(String type) {
        this.type = type;
    }
}
