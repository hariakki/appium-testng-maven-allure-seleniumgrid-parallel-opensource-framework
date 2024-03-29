package com.enlightenment.teststeps;

import com.enlightenment.appiumsupport.AppiumController;
import com.enlightenment.data.User;
import com.enlightenment.pageobjects.LoginScreenPage;
import com.enlightenment.pageobjects.RegisteredHomePage;
import com.enlightenment.utils.CommonActions;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.util.HashMap;

import static org.testng.Reporter.getCurrentTestResult;

public class LoginSteps {


    public static void given_user_logs_in_as(User user) {
        LoginScreenPage loginScreen = new LoginScreenPage(AppiumController.getDriver());
        loginScreen.logInWithEmail(user.email);
    }

    public static void and_user_clicks_on_emailed_magic_link() {

        final AppiumDriver driver = AppiumController.getDriver();

        String platform = getCurrentTestResult().getMethod().getXmlTest().getParameter("platformName").toLowerCase();


        if (platform.equals("ios")) {
//            driver.runAppInBackground(30);
//            driver.closeApp();


            JavascriptExecutor js = (driver);
            HashMap<String, String> safariBundledId = new HashMap<>();
            safariBundledId.put("bundleId", "com.apple.mobilesafari");
            js.executeScript("mobile: launchApp", safariBundledId);


            driver.get("https://www.google.com/gmail/about/#");

            CommonActions.pauseTest(12);


            HashMap<String, String> appBundleId = new HashMap<>();
            appBundleId.put("bundleId", "com.wdiodemoapp");
            js.executeScript("mobile: launchApp", appBundleId);

            RegisteredHomePage registeredHomePage = new RegisteredHomePage(driver);
            registeredHomePage.clickOnReadingButton();
            CommonActions.pauseTest(4);

        }
    }
}
