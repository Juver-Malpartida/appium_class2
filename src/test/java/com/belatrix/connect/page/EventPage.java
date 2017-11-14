package com.belatrix.connect.page;

import com.belatrix.connect.framework.ParentPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class EventPage extends ParentPage {

    public EventPage(AppiumDriver driver) {
        super(driver);
    }

    By BTN_REGISTER = By.id("com.belatrixsf.connect:id/btn_register");

    public void Register() {
        handlingWaitToElement(BTN_REGISTER);
        click(BTN_REGISTER);
    }

    public String getRegistrationStatus() {
        return getElementValue(BTN_REGISTER);
    }
}
