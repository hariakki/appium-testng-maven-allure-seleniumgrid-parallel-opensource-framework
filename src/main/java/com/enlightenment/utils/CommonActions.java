package com.enlightenment.utils;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class CommonActions {

    private CommonActions() {

    }

    /**
     * Pause test.
     * Avoid using this as much as possible. Tests should be robust and repeatable and not rely
     * on introducing arbitrary waits.
     *
     * @param secs the number of seconds to pause
     */
    public static void pauseTest(int secs) {
        try {
            Thread.sleep(1000L * secs);
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        }
    }

    private static String[] getLocatorFromWebElement(MobileElement element) {

        return (element.toString().split("->")[1].replaceFirst("(?s)(.*)\\]", "$1" + "")).split(":");
    }

    public static By getByFromElement(MobileElement element) {

        By by = null;
        String[] pathVariables = getLocatorFromWebElement(element);

        String selector = pathVariables[0].trim();
        String value = pathVariables[1].trim();

        switch (selector) {
            case "id":
                by = By.id(value);
                break;
            case "className":
                by = By.className(value);
                break;
            case "tagName":
                by = By.tagName(value);
                break;
            case "xpath":
                by = By.xpath(value);
                break;
            case "cssSelector":
                by = By.cssSelector(value);
                break;
            case "linkText":
                by = By.linkText(value);
                break;
            case "name":
                by = By.name(value);
                break;
            case "partialLinkText":
                by = By.partialLinkText(value);
                break;
            default:
                throw new IllegalStateException("locator : " + selector + " not found!!!");
        }
        return by;
    }
}
