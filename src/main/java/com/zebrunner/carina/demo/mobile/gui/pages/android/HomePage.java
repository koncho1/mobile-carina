package com.zebrunner.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.demo.mobile.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.components.ShopItem;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends HomePageBase implements IMobileUtils {

    Wait<WebDriver> wait;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    private List<ShopItem> shopItemList;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView[2]")
    private ExtendedWebElement homePageImage;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']//android.widget.TextView")
    private ExtendedWebElement cartItemCount;

    public ItemPage getItemPage(){
       return shopItemList.get(0).openItemPage();
    }

    public boolean isCartEmpty(){
        return isElementNotPresent(cartItemCount,1);
    }

    public boolean isNumberOfItemsInCartCorrect(Integer enteredNumber){
        return enteredNumber==Integer.parseInt(cartItemCount.getText());
    }

    public void addItemsToCart(int numberOfItems){
        for(int i=0; i<numberOfItems; i++){
            ShopItem item = shopItemList.get(i);
            if(i>0 && i%2==0){
                swipe(item.getAddToCartButton());
            }
            if (item.isItemAddedToCart()){
                item.addItemToCart();
            }
        }
    }

    public void removeItemsFromCart(int numberOfItems){
        for(int i=0; i<numberOfItems; i++){
            ShopItem item = shopItemList.get(i);
            if(i>0 && i%2==0){
                swipe(item.getRemoveButton());
            }
            if (!item.isItemAddedToCart()){
                item.removeItemFromCart();
            }
        }
    }

    public HomePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(homePageImage);
    }
}
