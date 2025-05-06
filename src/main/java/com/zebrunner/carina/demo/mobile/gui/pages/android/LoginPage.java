package com.zebrunner.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.ProductListPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.enums.ErrorTypeMessage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.zebrunner.carina.demo.mobile.gui.pages.enums.ErrorTypeMessage.INVALID;
import static com.zebrunner.carina.demo.mobile.gui.pages.enums.ErrorTypeMessage.LOCKED_OUT;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {


    private static final int ELEMENT_TIMEOUT=3;

    private static final String TEST =String.format("//android.widget.TextView[@text='%s']", INVALID.message);

    @AndroidFindBy(accessibility = "test-Username")
    private ExtendedWebElement loginInput;

    @AndroidFindBy(accessibility = "test-Password")
    private ExtendedWebElement passwordInput;

    @AndroidFindBy(accessibility = "test-LOGIN")
    private ExtendedWebElement logInButton;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement invalidCredentialsError;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement lockedOutUserError;

    private void enterLogin(String login){
        loginInput.type(login);
    }

    private void enterPassword(String password){
        passwordInput.type(password);
    }

    public ProductListPageBase logIn(String login, String password){
        enterLogin(login);
        enterPassword(password);
        logInButton.click();
        return new ProductListPage(driver);
    }


    public boolean isInvalidCredentialsErrorMessagePresent(){
        return invalidCredentialsError.format(INVALID.message).isElementPresent(ELEMENT_TIMEOUT);
    }

    public boolean isLockedOutUserErrorMessagePresent(){
        return lockedOutUserError.format(LOCKED_OUT.message).isElementPresent(ELEMENT_TIMEOUT);
    }


    public LoginPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginInput);
    }
}
