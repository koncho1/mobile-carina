package com.zebrunner.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.demo.mobile.gui.pages.common.ProductListPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.components.ProductListItemComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductListPageBase.class)
public class ProductListPage extends ProductListPageBase implements IMobileUtils {

    private static final int TIMEOUT_TIME=1;

    @AndroidFindBy(accessibility = "test-Menu")
    private ExtendedWebElement sideMenuButton;

    @AndroidFindBy(accessibility = "test-Item")
    private List<ProductListItemComponent> productListItemComponentList;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']/following-sibling::android.widget.ImageView")
    private ExtendedWebElement logoIcon;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"test-Cart\").childSelector(new UiSelector().classNameMatches(\".*Text.*\"))")
    private ExtendedWebElement cartItemCount;

    @AndroidFindBy(accessibility = "test-Cart")
    private ExtendedWebElement goToCartButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Price (low to high)']")
    private ExtendedWebElement sortLowToHighButton;

    @AndroidFindBy(accessibility = "test-Modal Selector Button")
    private ExtendedWebElement sortingButton;

    public ProductsDetailPage openProductsDetailPage(){
       return productListItemComponentList.get(0).openItemPage();
    }

    public boolean isCartEmpty(){
        return isElementNotPresent(cartItemCount,TIMEOUT_TIME);
    }

    public boolean isNumberOfItemsInCartCorrect(Integer enteredNumber){
        return enteredNumber.equals(Integer.parseInt(cartItemCount.getText()));
    }

    private ArrayList<Float> getPrices() {
        ArrayList<Float> priceArray = new ArrayList<Float>();
        for (ProductListItemComponent item : productListItemComponentList) {
            Float price = Float.parseFloat(item.getPrice().substring(1));
            priceArray.add(price);
        }
        return priceArray;
    }

    public MenuPage openSideMenu(){
        sideMenuButton.click();
        return new MenuPage(driver);
    }

    public boolean arePricesLowToHigh() {
        ArrayList<Float> arrayListOfPrices = getPrices();
        ArrayList<Float> copy = new ArrayList<Float>(arrayListOfPrices);
        Collections.sort(copy);
        return copy.equals(arrayListOfPrices);
    }

    public CartPage goToCart() {
        goToCartButton.click();
        return new CartPage(driver);
    }

    public ProductListPage sortLowToHigh() {
        sortingButton.click();
        sortLowToHighButton.click();
        return new ProductListPage(driver);
    }



    public void addItemsToCart(int numberOfItems){
        for(int i=0; i<numberOfItems; i++){
            ProductListItemComponent item = productListItemComponentList.get(i);
            if(i>0 && i%2==0){
                swipe(item.getAddToCartButton());
            }
            if (!item.isItemAddedToCart()){
                item.addItemToCart();
            }
        }
    }

    public void removeItemsFromCart(int numberOfItems){
        for(int i=0; i<numberOfItems; i++){
            ProductListItemComponent item = productListItemComponentList.get(i);
            if(i>0 && i%2==0){
                swipe(item.getRemoveButton());
            }
            if (item.isItemAddedToCart()){
                item.removeItemFromCart();
            }
        }
    }

    public ProductListPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logoIcon);
    }
}
