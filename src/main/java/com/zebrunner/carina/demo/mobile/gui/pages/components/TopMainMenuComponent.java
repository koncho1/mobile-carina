package com.zebrunner.carina.demo.mobile.gui.pages.components;

import com.zebrunner.carina.demo.mobile.gui.pages.android.CartPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class TopMainMenuComponent extends AbstractUIObject {

    private static final int TIMEOUT_TIME = 1;

    @AndroidFindBy(accessibility = "test-Cart")
    private ExtendedWebElement cartIcon;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"test-Cart\").childSelector(new UiSelector().classNameMatches(\".*Text.*\"))")
    private ExtendedWebElement cartItemCount;

    public boolean isCartEmpty() {
        return isElementNotPresent(cartItemCount, TIMEOUT_TIME);
    }

    public String getCartItemCount() {
        return cartItemCount.getText();
    }

    public void goToCart() {
        cartIcon.click();
    }

    public TopMainMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
