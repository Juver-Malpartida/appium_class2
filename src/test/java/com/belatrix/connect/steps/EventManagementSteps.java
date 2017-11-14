package com.belatrix.connect.steps;

import com.belatrix.connect.framework.ParentScenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class EventManagementSteps extends ParentScenario {

    @Given("^the user has not confirmed his attendance to the event '(.*?)'$")
    public void the_user_is_logged_into_the_application(String eventName) throws Throwable {
        startAndroid();
        loginPage.takingSessionActivity();
        System.out.println("La aplicacion se inicio correctamente");
        loginPage.loginOnApp("jmalpartida", "CONtrol1");
        mainProfilePage.clickEventsTab();
        eventsPage.enterEventByName(eventName);
        SetInitialStateToUnRegistered();
    }

    @Given("^the user has already confirm his attendance to the event '(.*?)'$")
    public void the_user_has_already_confirm_his_attendace(String eventName) throws Throwable {
        startAndroid();
        loginPage.takingSessionActivity();
        System.out.println("La aplicacion se inicio correctamente");
        loginPage.loginOnApp("jmalpartida", "CONtrol1");
        mainProfilePage.clickEventsTab();
        eventsPage.enterEventByName(eventName);
        SetInitialStateToRegistered();
    }

    @When("^the user try to confirm his attendance$")
    public void the_user_try_to_confirm_his_attendance_to_Halloween_event() throws Throwable {
        eventPage.Register();
        alertMessageTwoOptions.waitForAlertMessage("Do you want register this event?");
        alertMessageTwoOptions.answerYes();
        alertConfirmation.waitAndClickOnGotIt();
    }

    @When("^the user try undo his attendance$")
    public void the_user_try_undo_his_attendance() throws Throwable {
        eventPage.Register();
        alertMessageTwoOptions.waitForAlertMessage("Do you want unregister this event?");
        alertMessageTwoOptions.answerYes();
        alertConfirmation.waitAndClickOnGotIt();
    }

    @Then("^the user will be get a confirmation message '(.*?)' about it$")
    public void the_user_will_be_get_a_confirmation_about_it(String message) throws Throwable {
        String status = eventPage.getRegistrationStatus();
        Assert.assertEquals(status, message);
    }

    private void SetInitialStateToRegistered() {
        if (eventPage.getRegistrationStatus() == "Register") {
            eventPage.Register();
            alertMessageTwoOptions.waitForAlertMessage("Do you want register this event?");
            alertMessageTwoOptions.answerYes();
            alertConfirmation.waitAndClickOnGotIt();
        }
    }

    private void SetInitialStateToUnRegistered() {
        if (eventPage.getRegistrationStatus() == "Registered") {
            eventPage.Register();
            alertMessageTwoOptions.waitForAlertMessage("Do you want unregister this event?");
            alertMessageTwoOptions.answerYes();
            alertConfirmation.waitAndClickOnGotIt();
        }
    }
}
