package com.menelic.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class CoolingOffHomePage extends BasePage{

    public CoolingOffHomePage(AppiumDriver driver) {
        super(driver);
        onPage();
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Your switch to Glow has begun']")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Your switch to Glow has begun']")
    private MobileElement homeCoolingOffPeriodScreenSign;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Logout']")
    @iOSFindBy(xpath = "//XCUIElementTypeOther[@name='Logout']")
    private MobileElement logOutButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dismiss All']")
    @iOSFindBy(xpath = "(//XCUIElementTypeOther[@name='Dismiss All'])[2]")
    private MobileElement dismissElement;



    private void onPage(){
        homeCoolingOffPeriodScreenSign.isDisplayed();
    }

    public void logOut(){

        if(dismissElement.isDisplayed()){
            dismissElement.click();
            System.out.println("Clicked on dismiss element");
            System.out.println("There are possible error messages");

        }

        swipeToBottom();
        logOutButton.click();
        System.out.println("Clicked on logout button");
    }
}
