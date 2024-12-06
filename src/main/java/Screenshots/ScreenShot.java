package Screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot implements ITestListener {

   static String screenshotsDirectory = System.getProperty("user.dir") + "/screenshots/";

    public static void captureScreenshot(WebDriver driver, String testName) {
        File dir = new File(screenshotsDirectory);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String filename = screenshotsDirectory + testName + "_" + getTimestamp() + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(filename));
            System.out.println("Screenshot captured for failed test: " + filename);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }


    @BeforeSuite
    public void cleanScreenshotsDirectory() {
        File screenshotDir = new File(screenshotsDirectory);
        if (screenshotDir.exists()) {
            try {
                FileUtils.cleanDirectory(screenshotDir);
                System.out.println("Screenshot directory cleaned.");
            } catch (IOException e) {
                System.out.println("Failed to clean screenshot directory: " + e.getMessage());
            }
        } else {
            screenshotDir.mkdirs(); // If the directory doesn't exist, create it
        }
    }


    private static String getTimestamp() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }

}
