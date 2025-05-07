package com.zebrunner.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.demo.mobile.gui.pages.common.CheckoutInformationPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.ProductListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutInformationPageBase.class)
public class CheckoutInformationPage extends CheckoutInformationPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='CHECKOUT: INFORMATION']")
    private ExtendedWebElement checkoutInformationText;

    @AndroidFindBy(accessibility = "test-First Name")
    private ExtendedWebElement firstNameField;

    @AndroidFindBy(accessibility = "test-Last Name")
    private ExtendedWebElement lastNameField;

    @AndroidFindBy(accessibility = "test-Zip/Postal Code")
    private ExtendedWebElement zipCodeField;

    @AndroidFindBy(accessibility = "test-CONTINUE")
    private ExtendedWebElement submitFormButton;

    private void enterFirstName(String firstName){
        firstNameField.type(firstName);
    }

    private void enterLastName(String lastName){
        lastNameField.type(lastName);
    }

    private void enterZipCode(String zipCode){
        zipCodeField.type(zipCode);
    }

    public CheckoutOverviewPage fillOutInformationForm(String firstName, String lastName, String zipCode){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterZipCode(zipCode);
        submitFormButton.click();
        return new CheckoutOverviewPage(driver);
    }

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(checkoutInformationText);
    }
}
