package com.translantik.stepDefs;

import com.translantik.pages.DashboardPage;
import com.translantik.pages.FleetVehiclePage;
import com.translantik.pages.GeneralInformationPage;
import com.translantik.pages.LoginPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class TRANS_537stepDefs {

    GeneralInformationPage generalInformationPage = new GeneralInformationPage ();


    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        //go to login page
        Driver.get ().get (ConfigurationReader.get ("url"));

    }

    @And("the user logged in as a {string}")
    public void the_user_logged_in_as(String userType) {

        //based on input enter that user information
        String username = null;
        String password = null;

        if (userType.equals ("driver")) {
            username = ConfigurationReader.get ("driver_username");
            password = ConfigurationReader.get ("driver_password");
        } else if (userType.equals ("sales manager")) {
            username = ConfigurationReader.get ("sales_manager_username");
            password = ConfigurationReader.get ("sales_manager_password");
        } else if (userType.equals ("store manager")) {
            username = ConfigurationReader.get ("store_manager_username");
            password = ConfigurationReader.get ("store_manager_password");
        } else if (userType.equals ("Sales Manager")) {
            username = "salesmanager101";
            password = "UserUser123";
        }

        //send username and password and login
        BrowserUtils.waitForPageToLoad(20);
        new LoginPage ().login (username, password);
    }




    @When("the user navigates to {string} {string}")
    public void the_user_navigates_to(String tab, String module) {

        BrowserUtils.waitFor (2);
        new DashboardPage().navigateToModule(tab, module);
    }

    @When("the user click manage filters and  select Driver checkbox")
    public void the_user_click_manage_filters_and_select_Driver_checkbox() {
        FleetVehiclePage fleetVehiclePage = new FleetVehiclePage ();
        BrowserUtils.waitForClickablility (fleetVehiclePage.filterButton,10);
        fleetVehiclePage.filterButton.click ();
        BrowserUtils.waitFor (2);
        fleetVehiclePage.manageFilters.click ();
        BrowserUtils.waitFor (2);
        new GeneralInformationPage().driverCheckbox.click ();


    }

    @When("the user click Driver dropdown button")
    public void the_user_click_driver_and_dropdown_button() {
        FleetVehiclePage fleetVehiclePage = new FleetVehiclePage ();
        new GeneralInformationPage().filterAllButton.click ();

    }
    @When("the user click Location dropdown button")
    public void the_user_click_location_dropdown_button() {
        FleetVehiclePage fleetVehiclePage = new FleetVehiclePage ();
        new GeneralInformationPage().filterAllButton.click ();

    }

    @Then("the user can see at least following methods")
    public void theUserCanSeeAtLeastFollowingMethods(List<String> expectedMethods) {
        FleetVehiclePage fleetVehiclePage = new FleetVehiclePage ();
        BrowserUtils.waitFor (3);
        System.out.println ("fleetVehiclePage.filterTypes.get (0).getText () = " + fleetVehiclePage.filterTypes.get (0).getText ());
        System.out.println ("fleetVehiclePage.filterTypes.size () = " + fleetVehiclePage.filterTypes.size ());

        List<String> actualMethods = BrowserUtils.getElementsText (fleetVehiclePage.filterTypes);
        Assert.assertEquals (expectedMethods, actualMethods);
    }


    @Given("The user is on the Vehicles Pages")
    public void the_user_is_on_the_Vehicles_Pages(String tab, String module) {
        BrowserUtils.waitFor(20);
        new DashboardPage ().navigateToModule (tab, module);
    }

    @When("{string} filters with at least below {string}")
    public void filters_with_at_least_below(String userType, String methods) {
        //based on input enter that user information
        String username = null;
        String password = null;

        if (userType.equals ("driver")) {
            username = ConfigurationReader.get ("driver_username");
            password = ConfigurationReader.get ("driver_password");
        } else if (userType.equals ("sales manager")) {
            username = ConfigurationReader.get ("sales_manager_username");
            password = ConfigurationReader.get ("sales_manager_password");
        } else if (userType.equals ("store manager")) {
            username = ConfigurationReader.get ("store_manager_username");
            password = ConfigurationReader.get ("store_manager_password");
        } else if (userType.equals ("Sales Manager")) {
            username = "salesmanager101";
            password = "UserUser123";
        }
        //buraya usertype göre methodlar görünüp görünmediğinin kodları yazılacak
    }



    @When("write {string} into input box")
    public void write_into_input_box(String name) {
        generalInformationPage.filterValue.sendKeys(name);
    }

    @When("click on update button")
    public void click_on_update_button() {
        generalInformationPage.updateButton.click ();
    }

    @Then("table should displays corresponding {string} related to selected method")
    public void table_should_displays_corresponding_related_to_selected_method(List<String> expectedMethods) {
        Select select = new Select(generalInformationPage.DropDownMenu);
        generalInformationPage.filterAllButton.click();
        BrowserUtils.waitFor (3);
        System.out.println ("generalInformationPage.filterTypes.get (0).getText () = " + generalInformationPage.filterTypes.get (0).getText ());
        System.out.println ("generalInformationPage.filterTypes.size () = " + generalInformationPage.filterTypes.size ());

        List<String> actualMethods = BrowserUtils.getElementsText (generalInformationPage.filterTypes);
        Assert.assertEquals (expectedMethods, actualMethods);
    }


    @Then("table should displays corresponding {string} related to selected {string}")
    public void table_should_displays_corresponding_data_related_to_selected_method(String value, String method) {
        generalInformationPage.sendValueAndFilter (value, method);
    }


    @When("the user select filter <method>")
    public void theUserSelectFilterMethod() {
    }


    @And("the user click manage filters and  select Location checkbox")
    public void theUserClickManageFiltersAndSelectLocationCheckbox() {

        FleetVehiclePage fleetVehiclePage = new FleetVehiclePage ();
        fleetVehiclePage.filterButton.click ();
        fleetVehiclePage.manageFilters.click ();
        new GeneralInformationPage().locationCheckbox.click ();

    }
    @And("the user click manage filters and select Driver checkbox")
    public void theUserClickManageFiltersAndSelectDriverCheckbox() {

        FleetVehiclePage fleetVehiclePage = new FleetVehiclePage ();
        fleetVehiclePage.filterButton.click ();
        fleetVehiclePage.manageFilters.click ();
        new GeneralInformationPage().driverCheckbox.click ();

    }

    @When("the user select filter {string}")
    public void theUserSelectFilter(String method) {
        switch (method) {
            case "Contains":
                generalInformationPage.DropDownMenu.click();
                break;
            case "Does Not Contain":
                generalInformationPage.doesNotContain.click();
                break;
            case "Starts With":
                generalInformationPage.startsWith.click();
                break;
            case "Ends With":
                generalInformationPage.EndsWith.click();
                break;
            case "Is Equal":
                generalInformationPage.isEqualTo.click();
                break;
            default:
                generalInformationPage.methodSelect(method);
        }
    }




    @And("write <search text> into input box")
    public void writeSearchTextIntoInputBox() {
    }
}