package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.mobile.gui.pages.android.LoginPage;
import com.zebrunner.carina.demo.mobile.gui.pages.common.ProductListPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.enums.UserType;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.zebrunner.carina.demo.mobile.gui.pages.enums.UserType.INVALID;
import static com.zebrunner.carina.demo.mobile.gui.pages.enums.UserType.LOCKED_OUT;

public class LoginTest extends BaseTest {
    @Test
    public void invalidCredentialsErrorMessageTest() {
        LoginPageBase loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isPageOpened(),"There was a problem opening the login page");
        loginPage.logIn(INVALID.login, "bbb");
        Assert.assertTrue(loginPage.isInvalidCredentialsErrorMessagePresent(),"The error message in not present");
    }

    @Test
    public void lockedOutUserErrorMessageTest() {
        LoginPageBase loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isPageOpened(),"There was a problem opening the login page");
        loginPage.logIn(LOCKED_OUT.login, PASSWORD);
        Assert.assertTrue(loginPage.isLockedOutUserErrorMessagePresent(),"The error message in not present");
    }

    @Test
    public void successfulLoginTest() {
        LoginPageBase loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isPageOpened(),"There was a problem opening the login page");
        ProductListPageBase homePage = loginPage.logIn(LOGIN,PASSWORD);
        Assert.assertTrue(homePage.isPageOpened(),"There was a problem opening the product list page");
    }

}
