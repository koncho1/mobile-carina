package com.zebrunner.carina.demo.mobile.gui.pages.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;


import java.time.Duration;

public class SortComponent extends AbstractUIObject {

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='Selector container']//android.widget.TextView[@text='Price (low to high)']")
    private ExtendedWebElement sortLowToHighButton;

    @AndroidFindBy(accessibility = "test-Modal Selector Button")
    private ExtendedWebElement sortingButton;

    public void sortLowToHigh() {
        sortingButton.click();
        sortLowToHighButton.click();
    }

    public SortComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
