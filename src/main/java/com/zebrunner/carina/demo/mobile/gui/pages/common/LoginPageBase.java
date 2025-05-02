package com.zebrunner.carina.demo.mobile.gui.pages.common;

import com.zebrunner.carina.demo.mobile.gui.pages.android.HomePage;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    public abstract void logIn(String login,String password);

    public abstract boolean isInvalidCredentialsErrorMessagePresent();

    public abstract boolean isLockedOutUserErrorMessagePresent();

    public abstract HomePage standardUserLogin();

    @Override
    public void open() {
        super.open();
    }

    public LoginPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }
}
