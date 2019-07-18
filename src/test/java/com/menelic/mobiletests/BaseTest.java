package com.menelic.mobiletests;

import com.menelic.appiumsupport.AppiumBaseClass;
import com.menelic.appiumsupport.AppiumController;
import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import lombok.Setter;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest extends AppiumBaseClass {

    public AppiumDriver driver;

    @Getter
    @Setter
    private String platformName;

    @Getter
    @Setter
    private String platformVersion;

    @Getter
    @Setter
    private String deviceName;

    @Parameters({"platformName", "platformVersion", "deviceName"})
    @BeforeMethod(description = "Starting appium driver and passing all desired capabilities")
    public void setUp(@Optional("Android") String _platformName, @Optional("9") String _platformVersion, @Optional("Pixel_3_API_28_Android_9.0") String _deviceName, ITestContext context) throws Exception {
        System.out.println("Starting test: " + context.getName());

        AppiumController.instance.start(_platformName, _platformVersion, _deviceName);
        this.driver = AppiumController.getDriver();
        setPlatformName(_platformName);
        setPlatformVersion(_platformVersion);
        setDeviceName(_deviceName);
    }

    @AfterMethod(description = "Stopping appium driver")
    public void tearDown(ITestResult testResult) {

        try {
            AppiumController.instance.stop();
        } catch (Exception ex) {
            System.out.println("This is the exception: " + ex.toString());
        }

        System.out.println("Did the test pass true/false:  " + testResult.isSuccess());
    }
}
