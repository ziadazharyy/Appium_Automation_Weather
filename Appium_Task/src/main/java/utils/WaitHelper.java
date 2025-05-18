package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitHelper {

    public static boolean waitVisibility(AppiumMobileDriver appiumMobileDriver, By locator) {
        boolean isElementPresent = false;
        WebDriver driver = appiumMobileDriver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Updated to use Duration

        // Wait for the element to be visible
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        if (element != null) {
            isElementPresent = true;
        }

        return isElementPresent;
    }

    public static void setImplicitWait(AppiumMobileDriver appiumMobileDriver, int seconds) {
        appiumMobileDriver.getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static void waitSpecificTimeForElementToBeClickable(AppiumMobileDriver appiumMobileDriver, By locator, int seconds) {

        WebDriverWait wait = new WebDriverWait(appiumMobileDriver.getDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));

    }

}
