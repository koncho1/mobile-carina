package com.zebrunner.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.demo.mobile.gui.pages.common.ProductListPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.components.ProductListItemComponent;
import com.zebrunner.carina.demo.mobile.gui.pages.components.SortComponent;
import com.zebrunner.carina.demo.mobile.gui.pages.components.TopMainMenuComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductListPageBase.class)
public class ProductListPage extends ProductListPageBase implements IMobileUtils {

    private static final int TIMEOUT_TIME = 1;

    @AndroidFindBy(accessibility = "test-Menu")
    private ExtendedWebElement sideMenuButton;

    @AndroidFindBy(accessibility = "test-Item")
    private List<ProductListItemComponent> productListItemComponentList;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']/following-sibling::android.widget.ImageView")
    private ExtendedWebElement logoIcon;

    @AndroidFindBy(uiAutomator = "//*[@content-desc='test-Menu']/..")
    private TopMainMenuComponent topMainMenuComponent;

    @AndroidFindBy(accessibility = "test-Modal Selector Button")
    private SortComponent sortingButton;

    public ProductsDetailPage openProductsDetailPage() {
        return productListItemComponentList.get(0).openItemPage();
    }

    public boolean isCartEmpty() {
        return topMainMenuComponent.isCartEmpty();
    }

    public boolean isNumberOfItemsInCartCorrect(Integer enteredNumber) {
        return enteredNumber.equals(Integer.parseInt(topMainMenuComponent.getCartItemCount()));
    }


    public MenuPage openSideMenu() {
        sideMenuButton.click();
        return new MenuPage(driver);
    }

    public boolean areItemPricesSortedLowToHigh() {
        List<BigDecimal> listOfPrices = ProductListItemComponent.getPrices(productListItemComponentList);
        List<BigDecimal> copy = new ArrayList<>(listOfPrices);
        Collections.sort(copy);
        return copy.equals(listOfPrices);
    }

    public CartPage goToCart() {
        topMainMenuComponent.goToCart();
        return new CartPage(driver);
    }

    public ProductListPage sortItemsByPriceLowToHigh() {
        sortingButton.click();
        sortingButton.sortLowToHigh();
        return new ProductListPage(driver);
    }


    public void addItemsToCart(int numberOfItems) {
        for (int i = 0; i < numberOfItems; i++) {
            ProductListItemComponent item = productListItemComponentList.get(i);
            if (!item.isItemAddedToCart()) {
                item.addItemToCart();
            }
        }
    }

    public void removeItemsFromCart(int numberOfItems) {
        for (int i = 0; i < numberOfItems; i++) {
            ProductListItemComponent item = productListItemComponentList.get(i);
            if (item.isItemAddedToCart()) {
                item.removeItemFromCart();
            }
        }
    }

    public ProductListPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logoIcon);
    }
}
