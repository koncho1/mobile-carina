package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.mobile.gui.pages.android.LoginPage;
import com.zebrunner.carina.demo.mobile.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.LoginPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest implements IAbstractTest {
    @Test
    public void InvalidCredentialsLoginTest() {
        LoginPageBase loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isPageOpened());
        loginPage.logIn("aaa", "bbb");
        Assert.assertTrue(loginPage.isInvalidCredentialsErrorMessagePresent());
    }

    @Test
    public void LockedOutUserLoginTest() {
        LoginPageBase loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isPageOpened());
        loginPage.logIn("locked_out_user", "secret_sauce");
        Assert.assertTrue(loginPage.isLockedOutUserErrorMessagePresent());
    }

    @Test
    public void SuccessfulLoginTest() {
        LoginPageBase loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isPageOpened());
        HomePageBase homePage = loginPage.standardUserLogin();
        Assert.assertTrue(homePage.isPageOpened());
    }

}
