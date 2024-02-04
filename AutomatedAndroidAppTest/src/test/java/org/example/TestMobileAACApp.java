package org.example;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestMobileAACApp {
    AndroidDriver driver;

    @BeforeClass()
    public void setUp() throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // Set the path to your APK file
        capabilities.setCapability("app", "C:\\Users\\Ivona Perko\\Desktop\\Automated-Testing-Project-AAC-aplication\\app-debug.apk");
        capabilities.setCapability("VERSION", "9.0");
        capabilities.setCapability("deviceName", "Pixel_5_API_33:5554"); // Set the correct emulator device name
        capabilities.setCapability("platformName", "Android");

        // Update the Appium server URL based on your setup
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
