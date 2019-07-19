package com.enlightenment.utils;

import com.enlightenment.appiumsupport.AppiumController;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class WaitMethods {

    private WaitMethods() {

    }

    public static MobileElement waitForElementToBeClickable(final By locator, int timeout) {

        System.out.println(String.format("Explicitly waiting %d seconds for %s element to be clickable", timeout, locator));

        try {
            WebDriverWait wait = new WebDriverWait(AppiumController.getDriver(), timeout);
            return (MobileElement) wait.until(elementToBeClickable(locator));
        } catch (TimeoutException ex) {
            System.out.println(String.format("Timed out for %s to be clickable with following exception %s", locator, ex.toString()));
            throw ex;
        }
    }
}
