package pages.Settings;

import org.openqa.selenium.By;
import utils.AppiumMobileDriver;

public abstract class SettingsAbstract {
    public SettingsAbstract(AppiumMobileDriver appiumMobileDriver) {
        super();
        this.appiumMobileDriver = appiumMobileDriver;

    }

    //Actions
    public abstract void tapOnTempMenu();

    public abstract void tapOnOptionInTempDropDownMenu(String tempUint, int index);

    public abstract String getTempUnit();

    public abstract void tapOnTimeFormatMenu();

    public abstract void tapOnDone();

    public abstract void tapOnGotIt();

    public abstract void tapOnAccessLocation();

    public abstract void tapOnOptionInTimeFormatDropDownMenu(String timeFormat);

    public abstract String getTimeFormat();

    //Variables
    AppiumMobileDriver appiumMobileDriver;

    public By TEMP_MENU_BUTTON;
    public By TEMP_DROPDOWN_MENU_OPTIONS;
    public By TEMP_TEXT;
    public By TIME_FORMAT_MENU_BUTTON;
    public By TIME_FORMAT_DROPDOWN_MENU_OPTIONS;
    public By TIME_FORMAT_TEXT;
    public By DONE_BUTTON;
    public By GOT_IT_BUTTON;
    public By ACCESS_LOCATION_BUTTON;

}
