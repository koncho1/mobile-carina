package com.zebrunner.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends LoginPageBase {

    Wait<WebDriver> wait;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Username']")
    private ExtendedWebElement loginInput;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGIN']")
    private ExtendedWebElement logInButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Username and password do not match any user in this service.']")
    private ExtendedWebElement invalidCredentialsError;

    @FindBy(xpath = "//android.widget.TextView[@text='Sorry, this user has been locked out.']")
    private ExtendedWebElement lockedOutUserError;

    private void EnterLogin(String login){
        loginInput.type(login);
    }

    private void EnterPassword(String password){
        passwordInput.type(password);
    }

    public void logIn(String login, String password){
        EnterLogin(login);
        EnterPassword(password);
        logInButton.click();
    }

    public HomePage standardUserLogin(){
        EnterLogin("standard_user");
        EnterPassword("secret_sauce");
        logInButton.click();
        return new HomePage(driver);
    }

    public boolean isInvalidCredentialsErrorMessagePresent(){
        wait.until(ExpectedConditions.visibilityOf(invalidCredentialsError));
        return invalidCredentialsError.isPresent();
    }

    public boolean isLockedOutUserErrorMessagePresent(){
        wait.until(ExpectedConditions.visibilityOf(lockedOutUserError));
        return lockedOutUserError.isPresent();
    }


    public LoginPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(loginInput);
    }
}
