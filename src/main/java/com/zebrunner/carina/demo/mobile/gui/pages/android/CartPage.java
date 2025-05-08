package com.zebrunner.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.demo.mobile.gui.pages.common.CartPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.ProductListPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.components.ProductListItemComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='YOUR CART']")
    private ExtendedWebElement yourCartLabel;

    @AndroidFindBy(accessibility = "test-Item")
    private List<ProductListItemComponent> cartItemList;

    @AndroidFindBy(accessibility = "test-CHECKOUT")
    private ExtendedWebElement checkoutButton;

    public boolean isNumberOfItemsSameAsAdded(int expectedNumberOfItems) {
        return cartItemList.size() == expectedNumberOfItems;
    }

    public CheckoutInformationPage goToCheckout() {
        checkoutButton.click();
        return new CheckoutInformationPage(driver);
    }

    public CartPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(yourCartLabel);
    }
}
