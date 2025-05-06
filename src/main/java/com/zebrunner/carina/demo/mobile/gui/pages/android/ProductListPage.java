package com.zebrunner.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.demo.mobile.gui.pages.common.ProductListPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.components.ProductListItemComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductListPageBase.class)
public class ProductListPage extends ProductListPageBase implements IMobileUtils {

    private static final int TIMEOUT_TIME=1;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    private List<ProductListItemComponent> productListItemComponentList;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']/following-sibling::android.widget.ImageView")
    private ExtendedWebElement logoIcon;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"test-Cart\").childSelector(new UiSelector().classNameMatches(\".*Text.*\"))")
    private ExtendedWebElement cartItemCount;

    public ProductsDetailPage openProductsDetailPage(){
       return productListItemComponentList.get(0).openItemPage();
    }

    public boolean isCartEmpty(){
        return isElementNotPresent(cartItemCount,TIMEOUT_TIME);
    }

    public boolean isNumberOfItemsInCartCorrect(Integer enteredNumber){
        return enteredNumber.equals(Integer.parseInt(cartItemCount.getText()));
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
