package com.translantik.stepDefs;

import com.translantik.pages.DashboardPage;
import com.translantik.pages.GeneralInformationPage;
import com.translantik.pages.LoginPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TRANS_537stepDefs {

    GeneralInformationPage generalInformationPage = new GeneralInformationPage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        //go to login page
        Driver.get().get(ConfigurationReader.get("url"));
    }

//    @Given("the user logged in as {string}")
//    public void the_user_logged_in_as(String userType) {
//
//        //based on input enter that user information
//        String username = null;
//        String password = null;
//
//        if (userType.equals("driver")) {
//            username = ConfigurationReader.get("driver_username");
//            password = ConfigurationReader.get("driver_password");
//        } else if (userType.equals("sales manager")) {
//            username = ConfigurationReader.get("sales_manager_username");
//            password = ConfigurationReader.get("sales_manager_password");
//        } else if (userType.equals("store manager")) {
//            username = ConfigurationReader.get("store_manager_username");
//            password = ConfigurationReader.get("store_manager_password");
//        } else if (userType.equals("Sales Manager")) {
//            username = "salesmanager101";
//            password = "UserUser123";
//        }
//        //send username and password and login
//        new LoginPage().login(username, password);
//    }

//    @When("the user navigates to {string} {string}")
//    public void the_user_navigates_to(String tab, String module) {
//
//        new DashboardPage().navigateToModule(tab, module);
//    }

    @When("the user click manage {string} and {string} checkbox")
    public void the_user_click_manage_and_checkbox(String string, String string2) {
        BrowserUtils.waitFor(2);
        generalInformationPage.DriverDropDownSet();
    }

    @When("the user click {string} dropdown button")
    public void the_user_click_dropdown_and_dropdown_button(String string) {

        generalInformationPage.DriverDropDownMenu.click();
    }


    @Given("The user is on the Vehicles Pages")
    public void the_user_is_on_the_Vehicles_Pages(String tab, String module) {
        new DashboardPage().navigateToModule(tab, module);
    }

    @When("{string} filters with at least below {string}")
    public void filters_with_at_least_below(String userType, String methods) {
        //based on input enter that user information
        String username = null;
        String password = null;

        if (userType.equals("driver")) {
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
        } else if (userType.equals("sales manager")) {
            username = ConfigurationReader.get("sales_manager_username");
            password = ConfigurationReader.get("sales_manager_password");
        } else if (userType.equals("store manager")) {
            username = ConfigurationReader.get("store_manager_username");
            password = ConfigurationReader.get("store_manager_password");
        } else if (userType.equals("Sales Manager")) {
            username = "salesmanager101";
            password = "UserUser123";
        }
        //buraya usertype göre methodlar görünüp görünmediğinin kodları yazılacak
    }

    @Then("table should displays corresponding {string} related to selected {string}")
    public void table_should_displays_corresponding_data_related_to_selected_method(String value,String method) {
        generalInformationPage.sendValueAndFilter(value,method);
    }


    @Then("the user can see at least following methods")
    public void theUserCanSeeAtLeastFollowingMethods() {
    }
}
