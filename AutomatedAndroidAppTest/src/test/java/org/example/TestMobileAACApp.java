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

    @Test
    public void testSymbolSelection() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        MobileElement appBar = (MobileElement) driver.findElement(MobileBy.xpath("//*[@content-desc='Toggle drawer']"));
        appBar.click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//*[@content-desc='Go to home screen']")));
        MobileElement homeMenuItem = (MobileElement) driver.findElement(MobileBy.xpath("//*[@content-desc='Go to home screen']"));
        homeMenuItem.click();

        driver.findElement(MobileBy.AccessibilityId("Most used")).click();

        MobileElement symbol = (MobileElement) driver.findElement(MobileBy.AccessibilityId("device"));
        symbol.click();

        MobileElement selectedSymbol = (MobileElement) driver.findElement(MobileBy.AccessibilityId("chosen"));
        Assert.assertTrue(selectedSymbol.isDisplayed(), "Selected symbol is not displayed on the top.");
    }

    @Test
    public void testSymbolDeletionByChosenSymbolClick() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        MobileElement appBar = (MobileElement) driver.findElement(MobileBy.xpath("//*[@content-desc='Toggle drawer']"));
        appBar.click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//*[@content-desc='Go to home screen']")));
        MobileElement homeMenuItem = (MobileElement) driver.findElement(MobileBy.xpath("//*[@content-desc='Go to home screen']"));
        homeMenuItem.click();

        driver.findElement(MobileBy.AccessibilityId("Most used")).click();

        MobileElement symbol = (MobileElement) driver.findElement(MobileBy.AccessibilityId("device"));
        symbol.click();

        MobileElement selectedSymbol = (MobileElement) driver.findElement(MobileBy.AccessibilityId("chosen"));
        Assert.assertTrue(selectedSymbol.isDisplayed(), "Selected symbol is not displayed on the top.");

        selectedSymbol.click();

        boolean isSymbolPresent = driver.findElements(MobileBy.AccessibilityId("chosen")).isEmpty();
        Assert.assertTrue(isSymbolPresent, "Selected symbol is still present after deletion.");
    }

    @Test
    public void testSymbolDeletionButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        MobileElement appBar = (MobileElement) driver.findElement(MobileBy.xpath("//*[@content-desc='Toggle drawer']"));
        appBar.click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//*[@content-desc='Go to home screen']")));
        MobileElement homeMenuItem = (MobileElement) driver.findElement(MobileBy.xpath("//*[@content-desc='Go to home screen']"));
        homeMenuItem.click();

        driver.findElement(MobileBy.AccessibilityId("Most used")).click();

        MobileElement symbol = (MobileElement) driver.findElement(MobileBy.AccessibilityId("device"));
        symbol.click();

        MobileElement selectedSymbol = (MobileElement) driver.findElement(MobileBy.AccessibilityId("chosen"));
        Assert.assertTrue(selectedSymbol.isDisplayed(), "Selected symbol is not displayed on the top.");

        MobileElement delete = (MobileElement) driver.findElement(MobileBy.AccessibilityId("delete"));
        delete.click();

        boolean isSymbolPresent = driver.findElements(MobileBy.AccessibilityId("chosen")).isEmpty();
        Assert.assertTrue(isSymbolPresent, "Selected symbol is still present after deletion.");
    }

    @Test
    public void testSentenceInput() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        MobileElement appBar = (MobileElement) driver.findElement(MobileBy.xpath("//*[@content-desc='Toggle drawer']"));
        appBar.click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//*[@content-desc='Go to custom sentences screen']")));
        MobileElement customSentenceMenuItem = (MobileElement) driver.findElement(MobileBy.xpath("//*[@content-desc='Go to custom sentences screen']"));
        customSentenceMenuItem.click();

        MobileElement add = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Add sentence"));
        add.click();

        MobileElement textField = (MobileElement) driver.findElement(MobileBy.xpath("//android.widget.EditText"));
        textField.sendKeys("Hello");

        // Save the sentence
        MobileElement saveButton = (MobileElement) driver.findElement(MobileBy.xpath("//*[@content-desc='Save']"));
        saveButton.click();

        MobileElement sentence = (MobileElement) driver.findElement(MobileBy.xpath("//*[@content-desc='sentence']"));
        String actualText = sentence.getText();

        boolean isTextPresent = actualText.equals("Hello");

        Assert.assertTrue(isTextPresent);
    }

    @Test
    public void testSentenceInputDeletion() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        MobileElement appBar = (MobileElement) driver.findElement(MobileBy.xpath("//*[@content-desc='Toggle drawer']"));
        appBar.click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//*[@content-desc='Go to custom sentences screen']")));
        MobileElement customSentenceMenuItem = (MobileElement) driver.findElement(MobileBy.xpath("//*[@content-desc='Go to custom sentences screen']"));
        customSentenceMenuItem.click();

        MobileElement add = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Add sentence"));
        add.click();

        MobileElement textField = (MobileElement) driver.findElement(MobileBy.xpath("//android.widget.EditText"));
        textField.sendKeys("Hello");

        // Save the sentence
        MobileElement saveButton = (MobileElement) driver.findElement(MobileBy.xpath("//*[@content-desc='Save']"));
        saveButton.click();

        MobileElement delete = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Delete sentence"));
        delete.click();

        boolean isSymbolPresent = driver.findElement(MobileBy.xpath("//*[@content-desc='sentence']")).isDisplayed();
        Assert.assertTrue(isSymbolPresent, "Selected symbol is still present after deletion.");
    }

    @Test
    public void testInfoPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        MobileElement appBar = (MobileElement) driver.findElement(MobileBy.xpath("//*[@content-desc='Toggle drawer']"));
        appBar.click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//*[@content-desc='Learn about AAC screen']")));
        MobileElement infoMenuItem = (MobileElement) driver.findElement(MobileBy.xpath("//*[@content-desc='Learn about AAC screen']"));
        infoMenuItem.click();

        MobileElement infoText = (MobileElement) driver.findElement(MobileBy.xpath("//*[@content-desc='InfoText']"));

        String actualText = infoText.getText();

        boolean isTextPresent = actualText.equals("Do you want to know more about AAC? Click on the links below to learn more.");

        Assert.assertTrue(isTextPresent);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
