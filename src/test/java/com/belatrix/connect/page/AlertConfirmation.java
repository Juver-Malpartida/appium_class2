package com.belatrix.connect.page;

import com.belatrix.connect.framework.ParentPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class AlertConfirmation extends ParentPage{
    public AlertConfirmation(AppiumDriver driver) {
        super(driver);
    }

    By BTN_OK = By.xpath("//android.widget.Button[@text='Got it!']");

    public void waitAndClickOnGotIt() {
        handlingWaitToElement(BTN_OK);
        click(BTN_OK);
    }
}
