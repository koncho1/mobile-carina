package com.zebrunner.carina.demo.mobile.gui.pages.common;

import com.zebrunner.carina.demo.mobile.gui.pages.android.ProductListPage;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    public abstract ProductListPageBase logIn(String login,String password);

    public abstract boolean isInvalidCredentialsErrorMessagePresent();

    public abstract boolean isLockedOutUserErrorMessagePresent();


    public LoginPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }
}
