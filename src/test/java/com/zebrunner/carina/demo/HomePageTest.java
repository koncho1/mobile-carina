/*******************************************************************************
 * Copyright 2020-2023 Zebrunner Inc (https://www.zebrunner.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.mobile.gui.pages.android.LoginPage;
import com.zebrunner.carina.demo.mobile.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.ItemPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.LoginPageBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest implements IAbstractTest{

    @Test
    public void OpenItemPageTest(){
        LoginPageBase loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isPageOpened());
        HomePageBase homePage=loginPage.standardUserLogin();
        Assert.assertTrue(homePage.isPageOpened());
        ItemPageBase itemPage = homePage.getItemPage();
        Assert.assertTrue(itemPage.isPageOpened());
    }

    @Test(dataProvider = "numberOfItemsProvider")
    public void AddItemsToCartTest(int enteredNumberOfItemsInCart, int expectedNumberOfItemsInCart){
        LoginPageBase loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isPageOpened());
        HomePageBase homePage=loginPage.standardUserLogin();
        Assert.assertTrue(homePage.isPageOpened());
        homePage.addItemsToCart(enteredNumberOfItemsInCart);
        Assert.assertTrue(homePage.isNumberOfItemsInCartCorrect(expectedNumberOfItemsInCart));
    }

    @Test(dataProvider = "numberOfItemsProvider")
    public void RemoveItemsFromCartTest(int enteredNumberOfItemsInCart, int expectedNumberOfItemsInCart){
        LoginPageBase loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isPageOpened());
        HomePageBase homePage=loginPage.standardUserLogin();
        Assert.assertTrue(homePage.isPageOpened());
        homePage.addItemsToCart(enteredNumberOfItemsInCart);
        Assert.assertTrue(homePage.isNumberOfItemsInCartCorrect(expectedNumberOfItemsInCart));
        homePage.removeItemsFromCart(enteredNumberOfItemsInCart);
        Assert.assertTrue(homePage.isCartEmpty());

    }

    @DataProvider(name = "numberOfItemsProvider")
    public Object[][] numberOfItemsDataProvider(){
        return new Object[][]{
                {3,3},
                {2,2}
        };
    }



}
