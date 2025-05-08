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
import com.zebrunner.carina.demo.mobile.gui.pages.android.ProductListPage;
import com.zebrunner.carina.demo.mobile.gui.pages.common.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductListPageTest extends BaseTest {

    private static final int THREE_ITEMS_ENTERED = 3;

    private static final int THREE_ITEMS_EXPECTED = 3;

    private static final int ONE_ITEM = 1;

    @Test
    public void openItemPageTest() {
        ProductListPageBase productListPage = logInAsStandardUser();
        ProductsDetailPageBase itemPage = productListPage.openProductsDetailPage();
        Assert.assertTrue(itemPage.isPageOpened(), "There was a problem opening the products detail page");
    }

    @Test(dataProvider = "numberOfItemsProvider")
    public void addItemsToCartTest(int enteredNumberOfItemsInCart, int expectedNumberOfItemsInCart) {
        ProductListPageBase productListPage = logInAsStandardUser();
        productListPage.addItemsToCart(enteredNumberOfItemsInCart);
        Assert.assertTrue(productListPage.isNumberOfItemsInCartCorrect(expectedNumberOfItemsInCart), "The number of items in the cart does not match the expected number of items");
    }

    @Test(dataProvider = "numberOfItemsProvider")
    public void removeItemsFromCartTest(int enteredNumberOfItemsInCart, int expectedNumberOfItemsInCart) {
        ProductListPageBase productListPage = logInAsStandardUser();
        productListPage.addItemsToCart(enteredNumberOfItemsInCart);
        Assert.assertTrue(productListPage.isNumberOfItemsInCartCorrect(expectedNumberOfItemsInCart), "The number of items in the cart does not match the expected number of items");
        productListPage.removeItemsFromCart(enteredNumberOfItemsInCart);
        Assert.assertTrue(productListPage.isCartEmpty(), "The cart is not empty");

    }

    @Test(dataProvider = "numberOfItemsProvider")
    public void checkItemsInCartTest(int enteredNumberOfItemsInCart, int expectedNumberOfItemsInCart) {
        ProductListPageBase productListPage = logInAsStandardUser();
        productListPage.addItemsToCart(enteredNumberOfItemsInCart);
        CartPageBase cartPage = productListPage.goToCart();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart Page didn't open");
        Assert.assertTrue(cartPage.isNumberOfItemsSameAsAdded(expectedNumberOfItemsInCart), "The number of items in cart is not the same as the number of added items");
    }

    @Test
    public void lowToHighSortTest() {
        ProductListPageBase productListPage = logInAsStandardUser();
        productListPage = productListPage.sortLowToHigh();
        Assert.assertTrue(productListPage.arePricesLowToHigh(), "Prices are not sorted low to high");
    }

    @Test
    public void checkoutFunctionalityTest() {
        ProductListPageBase productListPage = logInAsStandardUser();
        CartPageBase cartPage = productListPage.goToCart();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart Page didn't open");
        CheckoutInformationPageBase checkoutInformationPage = cartPage.goToCheckout();
        Assert.assertTrue(checkoutInformationPage.isPageOpened(), "Checkout information page didn't open");
        CheckoutOverviewPageBase checkoutOverviewPage = checkoutInformationPage.fillOutInformationForm("adssad", "bbbb", "dsad");
        Assert.assertTrue(checkoutOverviewPage.isPageOpened(), "Checkout overview page didn't open");
        CheckoutCompletePageBase checkoutCompletePage = checkoutOverviewPage.finalizeCheckout();
        Assert.assertTrue(checkoutCompletePage.isPageOpened(), "Checkout complete page didn't open");
    }

    @Test
    public void logoutFunctionalityTest() {
        ProductListPageBase productListPage = logInAsStandardUser();
        MenuPageBase menuPage = productListPage.openSideMenu();
        Assert.assertTrue(menuPage.isPageOpened(), "Menu page didn't open");
        LoginPageBase loginPage = menuPage.logOut();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page didn't open");
    }

    @Test
    public void findByImageStrategyTest() {
        ProductListPageBase productListPage = logInAsStandardUser();
        MenuPageBase menuPage = productListPage.openSideMenu();
        DrawPageBase drawPage = menuPage.openDrawFunctionality();
        Assert.assertTrue(drawPage.isPageOpened(), "Drawing page didn't open");
        drawPage.draw();
        Assert.assertTrue(drawPage.isDrawingPresent(), "The drawing was not found");
    }

    @DataProvider(name = "numberOfItemsProvider")
    public Object[][] numberOfItemsDataProvider() {
        return new Object[][]{
                {THREE_ITEMS_ENTERED, THREE_ITEMS_EXPECTED}
        };
    }


}
