package com.translantik.stepDefs;

import com.translantik.pages.DashboardPage;
import com.translantik.utils.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class addEventsStep {

    @When("the user navigates to {string}, {string}")
    public void the_user_navigates_to(String tabName, String moduleName) {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule(tabName, moduleName);
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);

    }


    @When("the user click on any car information row")
    public void the_user_click_on_any_car_information_row() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user should be able to see the {string} page")
    public void the_user_should_be_able_to_see_the_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }





}
