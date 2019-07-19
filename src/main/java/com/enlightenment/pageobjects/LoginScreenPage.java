package com.enlightenment.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

public class LoginScreenPage extends BasePage {

    public LoginScreenPage(AppiumDriver driver) {
        super(driver);
        onPage();
    }

    @AndroidFindBy(className = "android.widget.EditText")
    @iOSFindBy(xpath = "//XCUIElementTypeOther[@name='Email address']/XCUIElementTypeOther/XCUIElementTypeTextField")
    private MobileElement emailField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign in']")
    @iOSFindBy(xpath = "//XCUIElementTypeOther[@name='Sign in']")
    private MobileElement signInButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Welcome to Glow, sign in to continue']")
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Welcome to Glow, sign in to continue']")
    private MobileElement welcomeText;

    private void enterEmail(String email) {
        System.out.println("Entering email with value: " + email);
        emailField.clear();
        System.out.println("Cleared the email field");
        emailField.sendKeys(email);
        System.out.println("Entered the email");
    }

    private void clickSignInButton() {
        signInButton.click();
        System.out.println("Clicked on Sign In Button");
    }

    @Step("Login step for user with email {0}")
    public void logInWithEmail(String email) {
        enterEmail(email);
        clickSignInButton();
    }

    private void onPage() {
//        welcomeText.isDisplayed();
    }
}
