package com.zebrunner.carina.demo.mobile.gui.pages.common;

import com.zebrunner.carina.demo.mobile.gui.pages.android.CartPage;
import com.zebrunner.carina.demo.mobile.gui.pages.android.MenuPage;
import com.zebrunner.carina.demo.mobile.gui.pages.android.ProductListPage;
import com.zebrunner.carina.demo.mobile.gui.pages.android.ProductsDetailPage;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductListPageBase extends AbstractPage {

    public abstract ProductsDetailPage openProductsDetailPage();

    public abstract void addItemsToCart(int numberOfItems);

    public abstract boolean isNumberOfItemsInCartCorrect(Integer enteredNumber);

    public abstract boolean isCartEmpty();

    public abstract void removeItemsFromCart(int enteredNumber);

    public abstract CartPage goToCart();

    public abstract MenuPage openSideMenu();

    public abstract ProductListPage sortItemsByPriceLowToHigh();

    public abstract boolean areItemPricesSortedLowToHigh();

    public ProductListPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }
}
