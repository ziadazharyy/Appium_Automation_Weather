package pages.Settings;

import org.openqa.selenium.By;
import utils.ActionsHelper;
import utils.AppiumMobileDriver;
import utils.WaitHelper;


public class SettingsLogic extends SettingsAbstract {

    public SettingsLogic(AppiumMobileDriver appiumMobileDriver) {
        super(appiumMobileDriver);
        TEMP_MENU_BUTTON = By.xpath("//android.widget.ImageView[@resource-id=\"com.info.weather.forecast:id/iv_temp_dropdown\"]");
//        TEMP_DROPDOWN_MENU_OPTIONS = By.xpath("(//android.widget.TextView[@text=\""+tempUnit+"\"])["+index+"]");
        TEMP_TEXT = By.xpath("//android.widget.TextView[@resource-id=\"com.info.weather.forecast:id/tv_temp_setting\"]");
        TIME_FORMAT_MENU_BUTTON = By.xpath("//android.widget.ImageView[@resource-id=\"com.info.weather.forecast:id/iv_timeformat_dropdown\"]");
//        TIME_FORMAT_DROPDOWN_MENU_OPTIONS = By.xpath("//android.widget.TextView[@text=\"24 Hour\"]");
        TIME_FORMAT_TEXT = By.xpath("//android.widget.TextView[@resource-id=\"com.info.weather.forecast:id/tv_timeformat_setting\"]");
        DONE_BUTTON = By.xpath("//android.widget.TextView[@resource-id=\"com.info.weather.forecast:id/tv_button_done\"]");
        GOT_IT_BUTTON = By.xpath("//android.widget.LinearLayout[@resource-id=\"com.info.weather.forecast:id/ll_got_it\"]");
        ACCESS_LOCATION_BUTTON = By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]");

    }

    private By buildTempOptionXpath(String tempUnit, int index) {
        return By.xpath("(//android.widget.TextView[@text=\"" + tempUnit + "\"])[" + index + "]");
    }

    private By buildTimeOptionXpath(String timeFormat) {
        return By.xpath("//android.widget.TextView[@text=\""+timeFormat+"\"]");
    }


    @Override
    public void tapOnTempMenu() {

        WaitHelper.waitSpecificTimeForElementToBeClickable(appiumMobileDriver, TEMP_MENU_BUTTON, 10);
        ActionsHelper.clickWhileVisible(appiumMobileDriver, TEMP_MENU_BUTTON);
        System.out.println("Tap On Temp Menu");

    }

    @Override
    public void tapOnOptionInTempDropDownMenu(String tempUnit, int index) {

        WaitHelper.waitSpecificTimeForElementToBeClickable(appiumMobileDriver, buildTempOptionXpath(tempUnit, index), 10);
        ActionsHelper.clickWhileVisible(appiumMobileDriver, buildTempOptionXpath(tempUnit, index));
        System.out.println("Tap On option in temp menu");
    }
    @Override
    public void tapOnOptionInTimeFormatDropDownMenu(String timeFormat) {

        WaitHelper.waitSpecificTimeForElementToBeClickable(appiumMobileDriver, buildTimeOptionXpath(timeFormat), 10);
        ActionsHelper.clickWhileVisible(appiumMobileDriver, buildTimeOptionXpath(timeFormat));
        System.out.println("Tap On option in time format menu");
    }

    @Override
    public String getTempUnit() {
        WaitHelper.waitSpecificTimeForElementToBeClickable(appiumMobileDriver, TEMP_TEXT, 10);
        System.out.println("Temp Unit : " + ActionsHelper.getTextWhileVisible(appiumMobileDriver, TEMP_TEXT));
        return ActionsHelper.getTextWhileVisible(appiumMobileDriver, TEMP_TEXT);
    }

    @Override
    public void tapOnTimeFormatMenu() {

        WaitHelper.waitSpecificTimeForElementToBeClickable(appiumMobileDriver, TIME_FORMAT_MENU_BUTTON, 10);
        ActionsHelper.clickWhileVisible(appiumMobileDriver, TIME_FORMAT_MENU_BUTTON);
        System.out.println("Tap On Time Format Menu");

    }

    @Override
    public String getTimeFormat() {
        WaitHelper.waitSpecificTimeForElementToBeClickable(appiumMobileDriver, TIME_FORMAT_TEXT, 10);
        System.out.println("Temp Format : " + ActionsHelper.getTextWhileVisible(appiumMobileDriver, TIME_FORMAT_TEXT));
        return ActionsHelper.getTextWhileVisible(appiumMobileDriver, TIME_FORMAT_TEXT);
    }

    @Override
    public void tapOnDone() {

        WaitHelper.waitSpecificTimeForElementToBeClickable(appiumMobileDriver, DONE_BUTTON, 10);
        ActionsHelper.clickWhileVisible(appiumMobileDriver, DONE_BUTTON);
        System.out.println("Tap On Done Button");

    }

    @Override
    public void tapOnGotIt() {

        WaitHelper.waitSpecificTimeForElementToBeClickable(appiumMobileDriver, GOT_IT_BUTTON, 10);
        ActionsHelper.clickWhileVisible(appiumMobileDriver, GOT_IT_BUTTON);
        System.out.println("Tap On Got It Button");

    }

    @Override
    public void tapOnAccessLocation() {

        WaitHelper.waitSpecificTimeForElementToBeClickable(appiumMobileDriver, ACCESS_LOCATION_BUTTON, 10);
        ActionsHelper.clickWhileVisible(appiumMobileDriver, ACCESS_LOCATION_BUTTON);
        WaitHelper.setImplicitWait(appiumMobileDriver,3);
        System.out.println("Tap On Access Location Button");

    }

}
