package com.zebrunner.carina.demo.mobile.gui.pages.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ShopItem extends AbstractUIObject {

    @FindBy(xpath = "//android.view.ViewGroup")
    private ExtendedWebElement itemTitleText;

    public void openItemPage(){
        itemTitleText.click();
    }

    public ShopItem(WebDriver driver) {
        super(driver);
    }
}
