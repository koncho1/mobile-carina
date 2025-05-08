package com.zebrunner.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.ProductsDetailPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductsDetailPageBase.class)
public class ProductsDetailPage extends ProductsDetailPageBase {

    @AndroidFindBy(accessibility = "test-Inventory item page")
    private ExtendedWebElement pageItem;

    public ProductsDetailPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(pageItem);
    }
}
