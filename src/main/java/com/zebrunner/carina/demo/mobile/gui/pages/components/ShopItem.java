package com.zebrunner.carina.demo.mobile.gui.pages.components;

import com.zebrunner.carina.demo.mobile.gui.pages.android.ItemPage;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Wait;


public class ShopItem extends AbstractUIObject {

    Wait<WebDriver> wait;

    @AndroidFindBy (xpath = ".//android.widget.ImageView")
    private ExtendedWebElement itemPicture;

    @AndroidFindBy (xpath = ".//android.widget.TextView[@content-desc='test-Item title']")
    private ExtendedWebElement itemNameText;

    @AndroidFindBy (xpath = ".//android.widget.TextView[@text='ADD TO CART']")
    private ExtendedWebElement addToCartButton;

    @AndroidFindBy (xpath = ".//android.widget.TextView[@content-desc='test-Price']")
    private ExtendedWebElement itemPriceText;

    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc='test-REMOVE']")
    private ExtendedWebElement removeButton;

    public String getItemName(){
        return itemNameText.getText();
    }

    public boolean isItemAddedToCart(){
        return isElementNotPresent(removeButton,1);
    }

    public String getPrice(){
        return itemPriceText.getText();
    }

    public ExtendedWebElement getAddToCartButton(){
        return this.addToCartButton;
    }

    public ItemPage openItemPage(){
        itemPicture.click();
        return new ItemPage(driver);
    }

    public void addItemToCart(){
        addToCartButton.click();
    }

    public void removeItemFromCart(){
        removeButton.click();
    }

    public ExtendedWebElement getRemoveButton(){
        return this.removeButton;
    }



    public ShopItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
