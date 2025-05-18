package pages.Home;

import org.openqa.selenium.By;
import pages.Settings.SettingsAbstract;
import utils.ActionsHelper;
import utils.AppiumMobileDriver;
import utils.WaitHelper;


public class HomeLogic extends HomeAbstract {

    public HomeLogic(AppiumMobileDriver appiumMobileDriver) {
        super(appiumMobileDriver);
        TEMP_UNIT_TEXT = By.xpath("//android.widget.TextView[@resource-id=\"com.info.weather.forecast:id/tv_current_temper_unit\"]");
        TIME_FORMAT_TEXT = By.xpath("//android.widget.TextView[@resource-id=\"com.info.weather.forecast:id/tv_date\"]");
        BURGER_MENU_BUTTON = By.xpath("//android.widget.ImageView[@resource-id=\"com.info.weather.forecast:id/iv_bt_navigation_setting\"]");
        UNIT_SETTINGS_BUTTON = By.xpath("//android.widget.LinearLayout[@resource-id=\"com.info.weather.forecast:id/ll_item_unit_setting\"]");
    }

    private By buildRainIconXpath(int index) {
//        return By.xpath("(//android.widget.TextView[@resource-id=\"com.info.weather.forecast:id/tv_rain_chance\"])["+index+"]");
        return By.xpath("(//android.widget.ImageView[@resource-id=\"com.info.weather.forecast:id/iv_rain_chance\"])["+index+"]");
    }

    private By buildHumidityIconXpath(int index) {
//        return By.xpath("(//android.widget.TextView[@resource-id=\"com.info.weather.forecast:id/tv_humidity\"])["+index+"]");
        return By.xpath("(//android.widget.LinearLayout[@resource-id=\"com.info.weather.forecast:id/ll_humidity\"])["+index+"]/android.widget.ImageView");
    }

    private By buildHourlyTimeXpath(String hour) {
        return By.xpath("//android.widget.TextView[@resource-id=\"com.info.weather.forecast:id/tv_hour_item\" and @text=\""+hour+"\"]");
    }


    @Override
    public void tapOnUnitSettings() {

        WaitHelper.waitSpecificTimeForElementToBeClickable(appiumMobileDriver, UNIT_SETTINGS_BUTTON, 10);
        ActionsHelper.clickWhileVisible(appiumMobileDriver, UNIT_SETTINGS_BUTTON);

    }

    @Override
    public String getTempUnit() {
        WaitHelper.waitSpecificTimeForElementToBeClickable(appiumMobileDriver, TEMP_UNIT_TEXT, 10);
        System.out.println("Temp Unit : " + ActionsHelper.getTextWhileVisible(appiumMobileDriver, TEMP_UNIT_TEXT));
        return ActionsHelper.getTextWhileVisible(appiumMobileDriver, TEMP_UNIT_TEXT);
    }

    @Override
    public void tapOnBurgerMenu() {

        WaitHelper.waitSpecificTimeForElementToBeClickable(appiumMobileDriver, BURGER_MENU_BUTTON, 10);
        ActionsHelper.clickWhileVisible(appiumMobileDriver, BURGER_MENU_BUTTON);

    }

    @Override
    public boolean checkRainIconVisiblity(int index) {
        boolean isDisplayed;
        WaitHelper.waitVisibility(appiumMobileDriver, buildRainIconXpath(index));
        if (ActionsHelper.isElementDisplayed(appiumMobileDriver, buildRainIconXpath(index))) {
            isDisplayed = true;
            return isDisplayed;
        } else return false;

    }

    @Override
    public boolean checkHumidityIconVisiblity(int index) {
        boolean isDisplayed;
        WaitHelper.waitVisibility(appiumMobileDriver, buildHumidityIconXpath(index));
        if (ActionsHelper.isElementDisplayed(appiumMobileDriver, buildHumidityIconXpath(index))) {
            isDisplayed = true;
            return isDisplayed;
        } else return false;
    }

    @Override
    public String getTimeFormat() {
        WaitHelper.waitSpecificTimeForElementToBeClickable(appiumMobileDriver, TIME_FORMAT_TEXT, 10);
        System.out.println("Temp Format : " + ActionsHelper.getTextWhileVisible(appiumMobileDriver, TIME_FORMAT_TEXT));
        return ActionsHelper.getTextWhileVisible(appiumMobileDriver, TIME_FORMAT_TEXT);
    }

    @Override
    public boolean checkHourlyTime(String hour) {
        boolean isDisplayed;
        WaitHelper.waitVisibility(appiumMobileDriver, buildHourlyTimeXpath(hour));
        if (ActionsHelper.isElementDisplayed(appiumMobileDriver, buildHourlyTimeXpath(hour))) {
            isDisplayed = true;
            return isDisplayed;
        } else return false;
    }


}
