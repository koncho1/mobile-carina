package com.zebrunner.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.demo.mobile.gui.pages.common.CheckoutOverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutOverviewPageBase.class)
public class CheckoutOverviewPage extends CheckoutOverviewPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='CHECKOUT: OVERVIEW']")
    private ExtendedWebElement checkoutOverviewText;

    @AndroidFindBy(accessibility = "test-FINISH")
    private ExtendedWebElement finishButton;

    public CheckoutCompletePage clickButtonContinue() {
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(checkoutOverviewText);
    }
}
