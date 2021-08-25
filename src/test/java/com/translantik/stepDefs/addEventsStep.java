package com.translantik.stepDefs;

import com.translantik.pages.AddEventPage;
import com.translantik.pages.DashboardPage;
import com.translantik.pages.FleetVehiclePage;
import com.translantik.pages.GeneralInformationPage;
import com.translantik.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class addEventsStep {

    @When("the user navigates to {string}, {string}")
    public void the_user_navigates_to(String tabName, String moduleName) {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule(tabName, moduleName);
        new FleetVehiclePage().waitUntilLoaderScreenDisappear();

    }


    @When("the user click on any car information row")
    public void the_user_click_on_any_car_information_row() {

         FleetVehiclePage fleetVehiclePage = new FleetVehiclePage();
        BrowserUtils.waitFor(5);
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

        List<String> actualCompulsoryFieldsText =  BrowserUtils.getElementsText(new AddEventPage().actualCompulsoryFields);
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




}
