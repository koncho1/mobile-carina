package com.zebrunner.carina.demo.mobile.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import javax.swing.text.AbstractDocument;

public class ItemPageBase extends AbstractPage {
    @Override
    public void open() {
        super.open();
    }


    public ItemPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }
}
