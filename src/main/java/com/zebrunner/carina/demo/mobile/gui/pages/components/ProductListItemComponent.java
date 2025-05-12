package com.zebrunner.carina.demo.mobile.gui.pages.components;

import com.zebrunner.carina.demo.mobile.gui.pages.android.ProductsDetailPage;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class ProductListItemComponent extends AbstractUIObject implements IMobileUtils {

    private static final int WAIT_TIMEOUT = 1;

    @AndroidFindBy(xpath = ".//android.widget.ImageView")
    private ExtendedWebElement itemPicture;

    @AndroidFindBy(xpath = ".//android.widget.TextView[@content-desc='test-Item title']")
    private ExtendedWebElement itemNameText;

    @AndroidFindBy(xpath = ".//android.widget.TextView[@text='ADD TO CART']")
    private ExtendedWebElement addToCartButton;

    @AndroidFindBy(xpath = ".//android.widget.TextView[@content-desc='test-Price']")
    private ExtendedWebElement itemPriceText;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-REMOVE']")
    private ExtendedWebElement removeButton;


    private static Integer numberOfItemsInCart = 0;

    public static List<BigDecimal> getPrices(List<ProductListItemComponent> itemComponentList) {
        List<BigDecimal> priceArray = new ArrayList<>();
        for (ProductListItemComponent item : itemComponentList) {
            BigDecimal price = new BigDecimal(item.getPrice().substring(1));
            priceArray.add(price);
        }
        return priceArray;
    }

    public String getItemName() {
        return itemNameText.getText();
    }

    public boolean isItemAddedToCart() {
        return !isElementNotPresent(removeButton, WAIT_TIMEOUT);
    }

    public String getPrice() {
        swipe(itemPriceText);
        return itemPriceText.getText();
    }


    public static Integer getNumberOfItemsInCart() {
        return numberOfItemsInCart;
    }

    public ProductsDetailPage openItemPage() {
        itemPicture.click();
        return new ProductsDetailPage(driver);
    }

    public void addItemToCart() {
        swipe(addToCartButton);
        addToCartButton.click();
        numberOfItemsInCart += 1;
    }

    public void removeItemFromCart() {
        swipe(removeButton);
        removeButton.click();
        numberOfItemsInCart -= 1;
    }


    public ProductListItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
