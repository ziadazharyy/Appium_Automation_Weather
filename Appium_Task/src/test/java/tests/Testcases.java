package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Home.HomeAbstract;
import pages.Home.HomeLogic;
import pages.Settings.SettingsAbstract;
import pages.Settings.SettingsLogic;
import utils.AppiumMobileDriver;
import utils.Methods;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Testcases extends BaseTest {

    AppiumMobileDriver appiumMobileDriver;
    SettingsAbstract settingsAbstract;
    HomeAbstract homeAbstract;
    Methods methods;

    @BeforeMethod
    public void setup() {
        methods = new Methods();
        appiumMobileDriver = new AppiumMobileDriver(driver);
        settingsAbstract = new SettingsLogic(appiumMobileDriver);
        homeAbstract = new HomeLogic(appiumMobileDriver);

        settingsAbstract.tapOnDone();
        settingsAbstract.tapOnGotIt();
        settingsAbstract.tapOnAccessLocation();
    }

    @Test
    public void verifyTemperatureUnitChange() {

        homeAbstract.tapOnBurgerMenu();
        homeAbstract.tapOnUnitSettings();
        settingsAbstract.tapOnTempMenu();

        if (settingsAbstract.getTempUnit().equals("F")) {
            settingsAbstract.tapOnOptionInTempDropDownMenu("C", 1);
            settingsAbstract.tapOnDone();
            Assert.assertTrue(homeAbstract.getTempUnit().contains("C"));
        } else if (settingsAbstract.getTempUnit().equals("C")) {
            settingsAbstract.tapOnOptionInTempDropDownMenu("F", 2);
            settingsAbstract.tapOnDone();
            Assert.assertTrue(homeAbstract.getTempUnit().contains("F"));
        }
    }

    @Test
    public void verifyTimeFormatChange() {

        homeAbstract.tapOnBurgerMenu();
        homeAbstract.tapOnUnitSettings();
        settingsAbstract.tapOnTimeFormatMenu();

        if (settingsAbstract.getTimeFormat().equals("12 Hour")) {
            settingsAbstract.tapOnOptionInTimeFormatDropDownMenu("24 Hour");
            settingsAbstract.tapOnDone();
            Assert.assertFalse(homeAbstract.getTimeFormat().contains("PM,") || homeAbstract.getTimeFormat().contains("AM,"));
        } else if (settingsAbstract.getTimeFormat().equals("24 Hour")) {
            settingsAbstract.tapOnOptionInTimeFormatDropDownMenu("12 Hour");
            settingsAbstract.tapOnDone();
            Assert.assertTrue(homeAbstract.getTimeFormat().contains("PM,") || homeAbstract.getTimeFormat().contains("AM,"));
        }
    }

    @Test
    public void verifyRainAndHumidityForNext6Hours() {

        DateTimeFormatter FORMATTER_12H = DateTimeFormatter.ofPattern("hh:mm a");
        DateTimeFormatter FORMATTER_24H = DateTimeFormatter.ofPattern("HH:mm");

        if (homeAbstract.getTimeFormat().contains("PM,") || homeAbstract.getTimeFormat().contains("AM,")) {

            String time = methods.getNowTimeFormat12();

            for (int i = 0; i < 6; i++) {

                // Assert on hours, raining icon and humidity icon in homepage
                Assert.assertTrue(homeAbstract.checkHourlyTime(time.toString().toLowerCase()));
                Assert.assertTrue(homeAbstract.checkRainIconVisiblity(i + 1), "Rain icon is not displayed for hour " + (i + 1));
                Assert.assertTrue(homeAbstract.checkHumidityIconVisiblity(i + 1), "Humidity icon is not displayed for hour " + (i + 1));

                LocalTime.parse(time, FORMATTER_12H).plusHours(1);

                System.out.println("End of Iteration : " + (i + 1));
            }

        } else {

            String time = methods.getNowTimeFormat24();

            for (int i = 0; i < 6; i++) {

                // Assert on hours in homepage
                Assert.assertTrue(homeAbstract.checkHourlyTime(time.toString().toLowerCase()));
                Assert.assertTrue(homeAbstract.checkRainIconVisiblity(i + 1), "Rain icon is not displayed for hour " + (i + 1));
                Assert.assertTrue(homeAbstract.checkHumidityIconVisiblity(i + 1), "Humidity icon is not displayed for hour " + (i + 1));

                LocalTime.parse(time, FORMATTER_24H);

                System.out.println("End of Iteration : " + (i + 1));
            }
        }
    }

    @AfterMethod
    public void tearDown() {
        if (appiumMobileDriver.getDriver() != null) appiumMobileDriver.getDriver().quit();
        driver = null;
    }

}
