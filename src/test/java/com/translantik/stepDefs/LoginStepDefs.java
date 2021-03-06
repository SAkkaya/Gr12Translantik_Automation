package com.translantik.stepDefs;

import com.translantik.pages.LoginPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        String loginUrl = ConfigurationReader.get("url") ;
        Driver.get().get(loginUrl);

    }

    @When("the user enters the driver information")
    public void theUserEntersTheDriverInformation() {

        String username = ConfigurationReader.get("driver_username") ;
        String password = ConfigurationReader.get("driver_password") ;

        LoginPage loginPage = new LoginPage() ;
        loginPage.login(username, password);


    }

    @Then("the user should be able to login")
    public void theUserShouldBeAbleToLogin() {

        BrowserUtils.waitFor(2);
        String actualTitle = Driver.get().getTitle() ;
        Assert.assertEquals("Dashboard",actualTitle);


    }

    @When("the user enters the {string} and {string}")
    public void theUserEntersTheAnd(String username, String password) {


        LoginPage loginPage = new LoginPage() ;
        loginPage.login(username, password);


    }

    @When("the user logged in as {string}")
    public void theUserLoggedInAs(String userType) {
        String username ="", password="" ;

        switch (userType){
            case "sales manager" :
                username = ConfigurationReader.get("sales_manager_username");
                password = ConfigurationReader.get("sales_manager_password");
                break ;
            case "driver" :
                username = ConfigurationReader.get("driver_username");
                password = ConfigurationReader.get("driver_password");
                break;
            case "store manager" :
                username = ConfigurationReader.get("store_manager_username");
                password = ConfigurationReader.get("store_manager_password");
                break;

            default:
                System.out.println("UNKNOWN USER TYPE!!!");
        }

        LoginPage loginPage = new LoginPage() ;
        loginPage.login(username, password);

    }
    @When("The user logged in as {string}")
    public void theUserLoggedinAs(String userType) {
        Driver.get().get(ConfigurationReader.get("url"));
        String username ="", password="" ;

        switch (userType){
            case "sales manager" :
                username = ConfigurationReader.get("sales_manager_username");
                password = ConfigurationReader.get("sales_manager_password");
                break ;
            case "driver" :
                username = ConfigurationReader.get("driver_username");
                password = ConfigurationReader.get("driver_password");
                break;
            case "store manager" :
                username = ConfigurationReader.get("store_manager_username");
                password = ConfigurationReader.get("store_manager_password");
                break;

            default:
                System.out.println("UNKNOWN USER TYPE!!!");
        }

        LoginPage loginPage = new LoginPage() ;
        loginPage.login(username, password);

    }
}
