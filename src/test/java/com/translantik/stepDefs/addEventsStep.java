package com.translantik.stepDefs;

import com.translantik.pages.DashboardPage;
import com.translantik.pages.FleetVehiclePage;
import com.translantik.pages.GeneralInformationPage;
import com.translantik.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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





}
