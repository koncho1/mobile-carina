package com.zebrunner.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.demo.mobile.gui.pages.common.CheckoutCompletePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends CheckoutCompletePageBase {

    @AndroidFindBy(accessibility = "test-CHECKOUT: COMPLETE!")
    private ExtendedWebElement pageTitle;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(pageTitle);
    }
}
