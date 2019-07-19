package com.enlightenment.appiumsupport;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.Getter;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class AppiumController {

    public static AppiumController instance = new AppiumController();

    @Getter
    private static AppiumDriver driver;

    public void start(String platformName, String platformVersion, String deviceName) throws MalformedURLException {
        if (driver != null) {
            System.out.println("Driver is already started and no new capabilities are loaded");
            return;
        }

        File androidApp = new File("resources/app/android/Android-NativeDemoApp-0.2.1.apk");
        String absoluteAndroidAppPath = androidApp.getAbsolutePath();

        File iOSApp = new File("resources/app/ios/iOS-Simulator-NativeDemoApp-0.2.1.app");
        String absoluteIOSAppPath = iOSApp.getAbsolutePath();

        String userName = "menci1";
        String accessKey = "ecjduXoawNerwz8xfKbA";

        DesiredCapabilities capabilities = new DesiredCapabilities();


        /**
         * This set up is used when you run your appium server locally. Remember that only one appium driver can be run on one appium server
         * driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
         *
         * This set up is used when you run your tests against Selenium Grid
         * driver = new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
         *
         * This set up us used when you run your tests against Browser Stack
         * driver = new IOSDriver(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), capabilities);
         */
        switch (platformName.toLowerCase()) {
            case "android":

                capabilities.setCapability("platformName", platformName);
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
                capabilities.setCapability(MobileCapabilityType.APP, absoluteAndroidAppPath);
                capabilities.setCapability("appPackage", "com.wdiodemoapp");
                capabilities.setCapability("appActivity", "com.wdiodemoapp.MainActivity");
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                capabilities.setCapability("autoDismissAlerts", true);
                capabilities.setCapability("fullReset", true);
                capabilities.setCapability("noReset", false);

                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//                driver = new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
                break;
            case "ios":

                capabilities.setCapability("platformName", platformName);
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
                capabilities.setCapability(MobileCapabilityType.APP, absoluteIOSAppPath);
                capabilities.setCapability("bundleId", "com.wdiodemoapp");
//                capabilities.setCapability("udid", "E52560B2-59DD-4167-80FB-055CA21C7215");
                capabilities.setCapability("udid", "391D33FD-4EAA-413E-8829-47F77DFAE7B7");


                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                capabilities.setCapability("useNewWDA", true);
                capabilities.setCapability("waitForQuiescence", false);
                capabilities.setCapability("autoDismissAlerts", true);
                capabilities.setCapability("fullReset", true);
                capabilities.setCapability("noReset", false);

                driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//                driver = new IOSDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
                break;

            case "ios_real_device":

                capabilities.setCapability("platformName", platformName);
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
                capabilities.setCapability(MobileCapabilityType.APP, "/Users/Desktop/Dev.ipa");
                capabilities.setCapability("bundleId", "com.wdiodemoapp");
                capabilities.setCapability("udid", "4a25e27c87e588bd02fe9f10d52e557db8886fbe");
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");

                capabilities.setCapability("waitForQuiescence", false);
                capabilities.setCapability("xcodeOrgId", "QVNZ8GDYUN");
                capabilities.setCapability("xcodeSigningId", "iPhone Developer");
                capabilities.setCapability("updatedWDABundleId", "com.facebook.wda.lib");

                driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;

            /**
             * Before each run, you would need to upload your latest .apk or .ipa (because we test against real device on Browser Stack) to browser stack
             * Also you need to enter in you Android Driver URL you username and access key
             * Upload your .apk or .ipa
             * curl -u "${userName}:${accessKey}" -X POST https://api-cloud.browserstack.com/app-live/upload -F "file=@/path/to/app/file/Application-debug.apk"
             * Then whatever is returned by the curl command you use it as MobileCapabilityType.APP
             */
            case "browser_stack_android":

                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
                capabilities.setCapability(MobileCapabilityType.APP, "bs://75eef9eedb1b3796b5c360f560369a7439f4f004");
                capabilities.setCapability("appPackage", "com.wdiodemoapp");
                capabilities.setCapability("appActivity", "com.wdiodemoapp.MainActivity");
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                capabilities.setCapability("autoDismissAlerts", true);
                capabilities.setCapability("fullReset", true);
                capabilities.setCapability("noReset", false);

                driver = new AndroidDriver(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), capabilities);
                break;

            case "browser_stack_ios":
                capabilities.setCapability("browserName", "iPhone");
                capabilities.setCapability("device", deviceName);
                capabilities.setCapability("realMobile", "true");
                capabilities.setCapability("os_version", platformVersion);
                capabilities.setCapability(MobileCapabilityType.APP, "bs://a0e690d33d965d4dd3dfc5a9fa576035c19fa736");
                capabilities.setCapability("bundleId", "com.wdiodemoapp");
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                capabilities.setCapability("useNewWDA", true);
                capabilities.setCapability("waitForQuiescence", false);
                capabilities.setCapability("autoDismissAlerts", true);
                capabilities.setCapability("fullReset", true);
                capabilities.setCapability("noReset", false);
                capabilities.setCapability("browserstack.debug", true);
                capabilities.setCapability("browserstack.networkLogs", true);


                driver = new IOSDriver(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), capabilities);
                break;
            default:
                throw new IllegalArgumentException("The platform name " + platformName + " was not found");
        }
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("Stopping Driver");
        }
    }
}
