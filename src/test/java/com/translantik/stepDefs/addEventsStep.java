package com.translantik.stepDefs;

import com.translantik.pages.DashboardPage;
import com.translantik.utils.BrowserUtils;
import io.cucumber.java.en.When;

public class addEventsStep {

    @When("the user navigates to {string}, {string}")
    public void the_user_navigates_to(String tabName, String moduleName) {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule(tabName, moduleName);
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);

    }






}
