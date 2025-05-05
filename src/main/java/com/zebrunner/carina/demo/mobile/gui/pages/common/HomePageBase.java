package com.zebrunner.carina.demo.mobile.gui.pages.common;

import com.zebrunner.carina.demo.mobile.gui.pages.android.ItemPage;
import com.zebrunner.carina.demo.mobile.gui.pages.android.LoginPage;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    @Override
    public void open() {
        super.open();
    }

    public abstract ItemPage getItemPage();

    public abstract void addItemsToCart(int numberOfItems);

    public abstract boolean isNumberOfItemsInCartCorrect(Integer enteredNumber);

    public abstract boolean isCartEmpty();

    public abstract void removeItemsFromCart(int enteredNumber);

    public HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }
}
