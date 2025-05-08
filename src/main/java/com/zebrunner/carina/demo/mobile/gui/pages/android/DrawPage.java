package com.zebrunner.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.demo.mobile.gui.pages.common.DrawPageBase;
import com.zebrunner.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DrawPageBase.class)
public class DrawPage extends DrawPageBase implements IMobileUtils {

    @AndroidFindBy(accessibility = "test-DRAWING-SCREEN")
    private ExtendedWebElement drawScreenContainer;

    @ExtendedFindBy(image = "src/main/resources/drawing.png")
    private ExtendedWebElement img;


    public boolean isDrawingPresent(){
        return img.isElementPresent();
    }

    public void draw(){
        tap(311, 875);
        tap(788, 875);
        tap(270, 1324);
        tap(279, 1337);
        tap(307, 1356);
        tap(325, 1365);
        tap(357, 1369);
        tap(380, 1374);
        tap(431, 1374);
        tap(476, 1379);
        tap(522, 1388);
        tap(577, 1379);
        tap(655, 1369);
        tap(705, 1360);
        tap(760, 1324);
        tap(824, 1287);
        tap(540, 1090);
        tap(522, 1122);
        tap(504, 1173);
        tap(563, 1182);
        tap(646, 1191);
    }

    public DrawPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(drawScreenContainer);
    }
}
