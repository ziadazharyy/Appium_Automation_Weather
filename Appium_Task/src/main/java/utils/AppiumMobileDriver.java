package utils;

import io.appium.java_client.AppiumDriver;


public class AppiumMobileDriver<D extends AppiumDriver> {

    private AppiumDriver driver;

    // Constructor to set driver
    public AppiumMobileDriver(AppiumDriver driver) {
        this.driver = driver;
    }

    public AppiumDriver getDriver() {
        return driver;
    }
}
