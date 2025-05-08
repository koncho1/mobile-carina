package com.zebrunner.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.demo.mobile.gui.pages.common.MenuPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.ProductListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MenuPageBase.class)
public class MenuPage extends MenuPageBase {

    @FindBy(id="android:id/content")
    private ExtendedWebElement menuContainer;

    @AndroidFindBy(accessibility = "test-LOGOUT")
    private ExtendedWebElement logOutButton;

    @AndroidFindBy(accessibility = "test-DRAWING")
    private ExtendedWebElement drawButton;

    public LoginPage logOut(){
        logOutButton.click();
        return new LoginPage(driver);
    }

    public DrawPage openDrawFunctionality(){
        drawButton.click();
        return  new DrawPage(driver);
    }

    public MenuPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(menuContainer);
    }
}
