package com.translantik.stepDefs;

import com.translantik.pages.FleetVehiclePage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TRANS_535stepDefs {

    @Then("the user should be able to filtering {string}")
    public void the_user_should_be_able_to_filtering(String filter1) {
        FleetVehiclePage fleetVehiclePage = new FleetVehiclePage();

        BrowserUtils.waitForClickablility(fleetVehiclePage.filterButton, 20);
        fleetVehiclePage.filterButton.click();
        BrowserUtils.waitForClickablility(fleetVehiclePage.manageFilters, 10);

        fleetVehiclePage.manageFilters.click();
        BrowserUtils.waitForClickablility(fleetVehiclePage.manageFilters, 10);
        String column1Xpath = "//input[@title='" + filter1 + "']";
        WebElement column1Loc = Driver.get().findElement(By.xpath(column1Xpath));
        column1Loc.click();
    }

    @Then("the user should be able to another filtering {string}")
    public void the_user_should_be_able_to_another_filtering(String filter2) {
        FleetVehiclePage fleetVehiclePage = new FleetVehiclePage();
        String column1Xpath = "//input[@title='" + filter2 + "']";
        WebElement column1Loc = Driver.get().findElement(By.xpath(column1Xpath));
        column1Loc.click();
    }

    @Then("the {string} should provide following methods")
    public void the_should_provide_following_methods(String column, List<String> expectedMethods) {
        FleetVehiclePage fleetVehiclePage = new FleetVehiclePage();

        String columnPath = "//div[contains(text(),'" + column + "')]";
        WebElement columnButton = Driver.get().findElement(By.xpath(columnPath));
        columnButton.click();

        String dropdownName = column.replace(" ", "");
        WebElement dropdownMethods = Driver.get().findElement(By.name(dropdownName));
        BrowserUtils.waitForVisibility(dropdownMethods, 10);

        Select optionMethods = new Select(dropdownMethods);

        List<WebElement> options = optionMethods.getOptions();
        List<String> actualMethods = new ArrayList<>();

        for (WebElement method : options) {
            actualMethods.add(method.getText());
        }

        Assert.assertEquals(expectedMethods, actualMethods);
    }

    @Then("after the filter {string} {string} method user should see the filtered data on the table")
    public void after_the_filter_method_user_should_see_the_filtered_data_on_the_table(String column, String method) throws ParseException {
        BrowserUtils.waitFor(2);
        FleetVehiclePage fleetVehiclePage = new FleetVehiclePage();
        String columnPath = "//div[contains(text(),'" + column + "')]";
        WebElement columnButton = Driver.get().findElement(By.xpath(columnPath));
        columnButton.click();

        BrowserUtils.waitFor(1);

        String dropdownName = column.replace(" ", "");
        String dropdownPath = "//select[@name='" + dropdownName + "']";
        WebElement dropdownMethods = Driver.get().findElement(By.xpath(dropdownPath));
        BrowserUtils.waitForClickablility(dropdownMethods, 10);
        dropdownMethods.click();

        Select optionMethods = new Select(dropdownMethods);
        optionMethods.selectByVisibleText(method);

        fleetVehiclePage.checkFilteredDate(column, method);
    }

}
