package com.zebrunner.carina.demo.mobile.gui.pages.common;

import com.zebrunner.carina.demo.mobile.gui.pages.android.CheckoutInformationPage;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends AbstractPage {

    public abstract boolean isNumberOfItemsSameAsAdded(Integer expectedNumberOfItems);

    public abstract CheckoutInformationPage goToCheckout();

    public CartPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }
}
