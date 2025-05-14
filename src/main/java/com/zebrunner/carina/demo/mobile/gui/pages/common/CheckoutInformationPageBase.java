package com.zebrunner.carina.demo.mobile.gui.pages.common;

import com.zebrunner.carina.demo.mobile.gui.pages.android.CheckoutOverviewPage;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutInformationPageBase extends AbstractPage {

    public abstract CheckoutOverviewPage fillOutInformationForm(String firstName, String lastName, String zipCode);

    public CheckoutInformationPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }
}
