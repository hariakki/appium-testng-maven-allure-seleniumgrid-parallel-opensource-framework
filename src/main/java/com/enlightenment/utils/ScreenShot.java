package com.enlightenment.utils;

import com.enlightenment.appiumsupport.AppiumController;
import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileOutputStream;

import static com.enlightenment.utils.FileHelpers.createPath;
import static com.enlightenment.utils.FileHelpers.fileExists;
import static org.testng.Reporter.getCurrentTestResult;

/**
 * The type Screen shot.
 */
class ScreenShot {

    /**
     * Take screen shot.
     *
     * @param successEvidence the success evidence
     * @param count           the count
     */
    public static void takeScreenShot(Boolean successEvidence, int count) {

        try {
            FileOutputStream fileOutputStream;
            String screenshotFileName;
            String successScreenShotLocation = System.getProperty("user.dir") + "/target/screenshots/success/";
            String failedScreenShotLocation = System.getProperty("user.dir") + "/target/screenshots/fail/";
            String methodName = getCurrentTestResult().getMethod().getMethodName();
            String platformName = getCurrentTestResult().getMethod().getXmlTest().getAllParameters().get("platformName");
            String platformVersion = getCurrentTestResult().getMethod().getXmlTest().getAllParameters().get("platformVersion");
            String deviceName = getCurrentTestResult().getMethod().getXmlTest().getAllParameters().get("deviceName");

            if (successEvidence) {
                screenshotFileName = successScreenShotLocation + File.separator + methodName + "_"
                        + platformName + "_" + platformVersion + "_" + deviceName + ".png";
                createPath(successScreenShotLocation);
            } else {
                screenshotFileName = failedScreenShotLocation + File.separator + methodName + "_"
                        + platformName + "_" + platformVersion + "_" + deviceName + ".png";
                createPath(failedScreenShotLocation);
            }

            if (!fileExists(screenshotFileName)) {
                byte[] screenshot = getScreenshot(screenshotFileName);

                if (screenshot.length > 0) {
                    // Write byte array to file
                    System.out.println("Saving screenshot to " + screenshotFileName);
                    fileOutputStream = new FileOutputStream(screenshotFileName);
                    fileOutputStream.write(screenshot);
                    fileOutputStream.close();
                } else {
                    System.out.println("Following screenshot was empty: " + screenshotFileName);
                }
            }


        } catch (Exception ex) {
            System.out.println("Unable to take screenshot: " + ex.getMessage());
        }
    }


    //    @Attachment(value = "{0}", type = "image/png")
    private static byte[] getScreenshot(String name) {
        try {
            return ((TakesScreenshot) AppiumController.getDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (Exception ex) {
            System.out.println("Driver does not support taking screenshots!");
            return ArrayUtils.EMPTY_BYTE_ARRAY;
        }
    }
}
