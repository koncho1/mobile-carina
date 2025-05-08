package com.zebrunner.carina.demo.mobile.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DrawPageBase extends AbstractPage {

    public abstract void draw();

    public abstract boolean isDrawingPresent();

    public DrawPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }
}
