package com.zebrunner.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.demo.mobile.gui.pages.common.CheckoutCompletePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends CheckoutCompletePageBase {

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.ImageView")
    private ExtendedWebElement checkoutCompleteLogo;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(checkoutCompleteLogo);
    }
}
