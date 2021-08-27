package com.translantik.stepDefs;

import com.translantik.pages.AddEventPage;
import com.translantik.pages.DashboardPage;
import com.translantik.pages.FleetVehiclePage;
import com.translantik.pages.GeneralInformationPage;
import com.translantik.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class addEventsStep {

    AddEventPage addEventPage = new AddEventPage();

    @When("the user navigates to {string}, {string}")
    public void the_user_navigates_to(String tabName, String moduleName) {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(5);

        try{
            System.out.println("Did not open the add event");
            dashboardPage.navigateToModule(tabName, moduleName);
            new FleetVehiclePage().waitUntilLoaderScreenDisappear();
        }catch(NoSuchElementException exception){
            dashboardPage.addEventClose.click();
            dashboardPage.navigateToModule(tabName, moduleName);
            new FleetVehiclePage().waitUntilLoaderScreenDisappear();
        }

//        try{
//            dashboardPage.addEventClose.click();
//            dashboardPage.navigateToModule(tabName, moduleName);
//            new FleetVehiclePage().waitUntilLoaderScreenDisappear();
//        }catch(NoSuchElementException exception){
//            System.out.println("Did not open the add event");
//            dashboardPage.navigateToModule(tabName, moduleName);
//            new FleetVehiclePage().waitUntilLoaderScreenDisappear();
//        }

    }


    @When("the user click on any car information row")
    public void the_user_click_on_any_car_information_row() {

         FleetVehiclePage fleetVehiclePage = new FleetVehiclePage();
         BrowserUtils.waitFor(10);
         fleetVehiclePage.firstRowCar.click();


    }

    @Then("the user should be able to see the {string} page")
    public void the_user_should_be_able_to_see_the_page(String expectedTitle) {

        BrowserUtils.waitForVisibility(new GeneralInformationPage().titleGenInforPage,3);
        Assert.assertEquals(expectedTitle, new GeneralInformationPage().titleGenInforPage.getText());

    }


    @Then("Driver should not able to click on AddEvent button")
    public void driver_should_not_able_to_click_on_AddEvent_button() {
        Assert.assertFalse("Add Event is enabled", new GeneralInformationPage().addEventButton.isEnabled());

    }

    @When("the user click on AddEvent button")
    public void the_user_click_on_AddEvent_button() {
        GeneralInformationPage generalInformationPage = new GeneralInformationPage();
        BrowserUtils.waitForClickablility(generalInformationPage.addEventButton, 5);
        generalInformationPage.addEventButton.click();
    }

    @Then("compulsory fields are as below")
    public void compulsory_fields_are_as_below(List<String> expectedCompulsoryFields) {

        BrowserUtils.waitFor(10);
        AddEventPage addEventPage = new AddEventPage();
        List<String> actualCompulsoryFieldsText =  BrowserUtils.getElementsText(addEventPage.actualCompulsoryFields);
        System.out.println("actualCompulsoryFieldsText = " + actualCompulsoryFieldsText);

        List<String> newActualFields = new ArrayList<>();
        for (String each : actualCompulsoryFieldsText) {
            each= each.substring(0,each.length()-1);
//            each=each.replace("*", "");
            newActualFields.add(each);
            System.out.println("each = " + each);
        }

        System.out.println("expectedCompulsoryFields = " + expectedCompulsoryFields);
        System.out.println("newActualFields = " + newActualFields);

        Assert.assertEquals(expectedCompulsoryFields,newActualFields);
    }

    @When("the user send empty text to compulsory fields")
    public void the_user_send_empty_text_to_compulsory_fields() {

        addEventPage.startTextBox.clear();
        addEventPage.endTextBox.clear();

    }

    @When("the user click on save button.")
    public void the_user_click_on_save_button() {
        BrowserUtils.waitForClickablility(addEventPage.saveBtn, 3);
        BrowserUtils.clickWithJS( addEventPage.saveBtn);
        BrowserUtils.waitFor(3);
    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String expectedMessage) {

        for (WebElement each : addEventPage.ucluAppearedCompulsoryBlankText ) {
            Assert.assertEquals(expectedMessage,each.getText());
        }

        Assert.assertEquals(6, addEventPage.ucluAppearedCompulsoryBlankText.size());

    }

    @Then("User should be able to click on the event colored marks to determine urgency level")
    public void user_should_be_able_to_click_on_the_event_colored_marks_to_determine_urgency_level() {

        for (WebElement each :addEventPage.colorsUrgencyLevel ) {
            each.click();
            BrowserUtils.waitFor(1);
            Assert.assertTrue(each.isSelected());

        }

    }


    @Then("User should able to mark on on All-day event\" button")
    public void user_should_able_to_mark_on_on_All_day_event_button() {

        addEventPage.allDayEventCheckBox.click();

        for (WebElement each : addEventPage.startEndTime ) {
            Assert.assertFalse(each.isDisplayed());
        }

    }


    @Then("Occurrence interval options listed below are available")
    public void occurrence_interval_options_listed_below_are_available(List<String> expectedRepeatsOptions) {

        BrowserUtils.waitForPageToLoad(7);
        Select select = new Select(addEventPage.selectRepeats);
        List<WebElement> actual = select.getOptions();
        List<String> actualString = new ArrayList<>();

        for (WebElement each : actual) {
           actualString.add(each.getText());
        }
        Assert.assertEquals(expectedRepeatsOptions, actualString);

    }

    @Then("Ending options below are available")
    public void ending_options_below_are_available(List<String> expectedEndsOccurance) {

        List<String> actualList = BrowserUtils.getElementsText(addEventPage.endsOccurance);
        Assert.assertEquals(expectedEndsOccurance, actualList);

    }


    @Then("All Users should be able to see all events in the General information page")
    public void all_Users_should_be_able_to_see_all_events_in_the_General_information_page() {

        for (WebElement each : new GeneralInformationPage().generalIfoPageEvents) {
           Assert.assertTrue(each.isDisplayed());
        }

    }






}
