package pages.Home;

import org.openqa.selenium.By;
import utils.AppiumMobileDriver;

public abstract class HomeAbstract {
    public HomeAbstract(AppiumMobileDriver appiumMobileDriver) {
        super();
        this.appiumMobileDriver = appiumMobileDriver;

    }

    //Actions
    public abstract void tapOnUnitSettings();

    public abstract String getTempUnit();

    public abstract void tapOnBurgerMenu();

    public abstract boolean checkRainIconVisiblity(int index);

    public abstract boolean checkHumidityIconVisiblity(int index);

    public abstract String getTimeFormat();

    public abstract boolean checkHourlyTime(String hour);


    //Variables
    AppiumMobileDriver appiumMobileDriver;

    public By TEMP_UNIT_TEXT;
    public By TIME_FORMAT_TEXT;
    public By BURGER_MENU_BUTTON;
    public By UNIT_SETTINGS_BUTTON;
    public By RAIN_ICON;
    public By HUMIDITY_ICON;

}
