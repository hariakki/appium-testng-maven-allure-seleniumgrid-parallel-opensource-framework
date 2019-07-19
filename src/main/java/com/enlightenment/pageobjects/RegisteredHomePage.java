package com.enlightenment.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;

import static com.enlightenment.utils.CommonActions.getByFromElement;

public class RegisteredHomePage extends BasePage {

    public RegisteredHomePage(AppiumDriver driver) {
        super(driver);
        onPage();
    }

    @AndroidFindBy(xpath = "????//android.widget.TextView[@text='Your switch to Glow has begun']")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Home']")
    private MobileElement homeRegisteredScreenSign;

    @iOSFindBy(xpath = "(//XCUIElementTypeButton[@name='SECOND_TAB_BAR_BUTTON'])[2]")
    private MobileElement meterReadingNavigationButton;

    @iOSFindBy(xpath = "(//XCUIElementTypeButton[@name='SECOND_TAB_BAR_BUTTON'])[1]")
    private MobileElement homeScreenNavigationButton;


    private void onPage() {
//        homeRegisteredScreenSign.isDisplayed();
    }

    public void clickOnReadingButton() {

        By locator = getByFromElement(meterReadingNavigationButton);
        System.out.println(locator.toString());
        meterReadingNavigationButton.click();
    }
}
