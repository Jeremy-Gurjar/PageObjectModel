package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class Utils extends BasePage {


    static String email = "test20231104110345@gmail.com";

    //    static String email = "test" + timeStamp() + "@gmail.com";
    static String password = "jacksmith@1278";

    public static String timeStamp() {

        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        return timeStamp;


    }

    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public static void typeText(By by, String name) {
        driver.findElement(by).sendKeys(name);
    }

    public static String getTextFromElement(By by) {

        return driver.findElement(by).getText();
    }

    //it use for element to be cliable with time
    public static void waitForClickable(By by, int time) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //
    public static void waitForElementToDisappear(By by, int time) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOf((WebElement) by));
    }

    public static void urlToBe(String by, int time) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlToBe(by));
    }

    public static void selectByText(By by, String text) {
        Select selectDay = new Select(driver.findElement(by));
        selectDay.selectByVisibleText(text);

    }

    //it will take screenshot & save at specfied loaction
    public static void captureScreenshot(String screenShotName)
    {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File("ScreenshotsTS\\" + screenShotName +timeStamp()+ ".png"));
            System.out.println("Screenshot taken");
        } catch (
                IOException e) {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
    }

    public static void takeFullScreenshot(String screenshotName)
    {

    }

}
