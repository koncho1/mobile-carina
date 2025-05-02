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
import com.zebrunner.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileSampleTest implements IAbstractTest, IMobileUtils {

    @Test
    public void TestInvalidCredentialsLogin(){
        LoginPageBase loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isPageOpened());
        loginPage.logIn("aaa","bbb");
        Assert.assertTrue(loginPage.isInvalidCredentialsErrorMessagePresent());
    }

    @Test
    public void TestLockedOutUserLogin(){
        LoginPageBase loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isPageOpened());
        loginPage.logIn("locked_out_user","secret_sauce");
        Assert.assertTrue(loginPage.isLockedOutUserErrorMessagePresent());
    }

    @Test
    public void TestSuccessfulLogin(){
        LoginPageBase loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isPageOpened());
        HomePageBase homePage=loginPage.standardUserLogin();
        Assert.assertTrue(homePage.isPageOpened());
    }

    @Test
    public void test(){
        LoginPageBase loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isPageOpened());
        HomePageBase homePage=loginPage.standardUserLogin();
        Assert.assertTrue(homePage.isPageOpened());
        homePage.click();
    }



}
