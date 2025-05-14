package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.mobile.gui.pages.android.LoginPage;
import com.zebrunner.carina.demo.mobile.gui.pages.android.ProductListPage;
import com.zebrunner.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.ProductListPageBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public abstract class BaseTest implements IAbstractTest {

    protected final String LOGIN="standard_user";

    protected final String PASSWORD="secret_sauce";

    public ProductListPageBase logInAsStandardUser(){
        LoginPageBase loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isPageOpened(),"There was a problem opening the login page");
        ProductListPageBase productListPage=loginPage.logIn(LOGIN,PASSWORD);
        Assert.assertTrue(productListPage.isPageOpened(),"There was a problem opening the product list page");
        return productListPage;
    }

}
