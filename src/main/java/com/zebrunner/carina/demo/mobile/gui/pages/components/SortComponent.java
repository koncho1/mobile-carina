package com.zebrunner.carina.demo.mobile.gui.pages.components;

import com.zebrunner.carina.demo.mobile.gui.pages.enums.SortType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;


import java.time.Duration;

import static com.zebrunner.carina.demo.mobile.gui.pages.enums.SortType.PRICELOWHIGH;

public class SortComponent extends AbstractUIObject {

    @AndroidFindBy(xpath = ".//android.view.ViewGroup//android.widget.TextView[contains(@text, '%s')]")
    private ExtendedWebElement sortTypeButton;

    public void sortLowToHigh() {
        sortTypeButton.format(PRICELOWHIGH.getSortType()).click();
    }

    public SortComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
