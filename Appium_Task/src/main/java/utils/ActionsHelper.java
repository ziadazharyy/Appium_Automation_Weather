package utils;

import org.openqa.selenium.By;

public class ActionsHelper {


    /*Click on single element */
    public static void clickWhileVisible(AppiumMobileDriver appiumMobileDriver, By locator) {
        WaitHelper.waitVisibility(appiumMobileDriver, locator);
        appiumMobileDriver.getDriver().findElement(locator).click();
    }

    public static boolean isElementDisplayed(AppiumMobileDriver appiumMobileDriver, By locator) {
        WaitHelper.waitVisibility(appiumMobileDriver, locator);
        return appiumMobileDriver.getDriver().findElement(locator).isDisplayed();
    }

    /*Send keys to element*/
    public static void setTextWhileVisible(AppiumMobileDriver appiumMobileDriver, By locator, String text) {
        WaitHelper.waitVisibility(appiumMobileDriver, locator);
        appiumMobileDriver.getDriver().findElement(locator).sendKeys(text);

    }

    /*Get Text from element */
    public static String getTextWhileVisible(AppiumMobileDriver appiumMobileDriver, By locator) {
        WaitHelper.waitVisibility(appiumMobileDriver, locator);
        return appiumMobileDriver.getDriver().findElement(locator).getText();

    }

    public static void clearTextWhileVisible(AppiumMobileDriver appiumMobileDriver, By locator) {
        WaitHelper.waitVisibility(appiumMobileDriver, locator);
        appiumMobileDriver.getDriver().findElement(locator).clear();
    }
}
