package com.belatrix.connect.page;

import com.belatrix.connect.framework.ParentPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class EventsPage extends ParentPage{
    public EventsPage(AppiumDriver driver) {
        super(driver);
    }
    By LBL_UPCOMING_EVENTS = By.xpath("//android.widget.TextView[@text='My upcoming events']");


    public void enterEventByName(String eventName) {
        handlingWaitToElement(LBL_UPCOMING_EVENTS);
        String eventXpath = String.format("//android.widget.TextView[@text='%1$s']", eventName);
        click(By.xpath(eventXpath));
    }
}
