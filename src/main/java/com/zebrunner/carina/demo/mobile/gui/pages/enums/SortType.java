package com.zebrunner.carina.demo.mobile.gui.pages.enums;

public enum SortType {
    PRICELOWHIGH("Price (low to high)"),
    PRICEHIGHLOW("Price (high to low)"),
    ATOZ("Name (A to Z)"),
    ZTOA("Name (Z to A)");

    public String getSortType() {
        return sortType;
    }

    public final String sortType;

    private SortType(String type) {
        this.sortType = type;
    }
}
