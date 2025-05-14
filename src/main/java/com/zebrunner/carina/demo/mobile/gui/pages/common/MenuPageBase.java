package com.zebrunner.carina.demo.mobile.gui.pages.common;

import com.zebrunner.carina.demo.mobile.gui.pages.android.DrawPage;
import com.zebrunner.carina.demo.mobile.gui.pages.android.LoginPage;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MenuPageBase extends AbstractPage {

    public abstract LoginPage logOut();

    public abstract DrawPage openDrawFunctionality();

    public MenuPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }
}
