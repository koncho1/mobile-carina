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
import com.zebrunner.carina.demo.mobile.gui.pages.common.ProductListPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.ProductsDetailPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.LoginPageBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductListPageTest extends BaseTest{

    private static final int THREE_ITEMS_ENTERED=3;

    private static final int THREE_ITEMS_EXPECTED=3;

    @Test
    public void openItemPageTest(){
        ProductListPageBase productListPage= logInAsStandardUser();
        ProductsDetailPageBase itemPage = productListPage.openProductsDetailPage();
        Assert.assertTrue(itemPage.isPageOpened(),"There was a problem opening the products detail page");
    }

    @Test(dataProvider = "numberOfItemsProvider")
    public void addItemsToCartTest(int enteredNumberOfItemsInCart, int expectedNumberOfItemsInCart){
        ProductListPageBase productListPage= logInAsStandardUser();
        productListPage.addItemsToCart(enteredNumberOfItemsInCart);
        Assert.assertTrue(productListPage.isNumberOfItemsInCartCorrect(expectedNumberOfItemsInCart),"The number of items in the cart does not match the expected number of items");
    }

    @Test(dataProvider = "numberOfItemsProvider")
    public void removeItemsFromCartTest(int enteredNumberOfItemsInCart, int expectedNumberOfItemsInCart){
        ProductListPageBase productListPage= logInAsStandardUser();
        productListPage.addItemsToCart(enteredNumberOfItemsInCart);
        Assert.assertTrue(productListPage.isNumberOfItemsInCartCorrect(expectedNumberOfItemsInCart),"The number of items in the cart does not match the expected number of items");
        productListPage.removeItemsFromCart(enteredNumberOfItemsInCart);
        Assert.assertTrue(productListPage.isCartEmpty(),"The cart is not empty");

    }

    @DataProvider(name = "numberOfItemsProvider")
    public Object[][] numberOfItemsDataProvider(){
        return new Object[][]{
                {THREE_ITEMS_ENTERED,THREE_ITEMS_EXPECTED}
        };
    }



}
