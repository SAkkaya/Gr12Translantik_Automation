package com.translantik.stepDefs;

import com.translantik.pages.DashboardPage;
import com.translantik.pages.FleetVehiclePage;
import com.translantik.pages.LoginPage;
import com.translantik.pages.TableArrangementPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TableArrangementsDefs {

    @Given("{string} should be login")
    public void should_be_login(String string) {
        new TableArrangementPage().login2(string);
        switch (string) {
            case "driver":
                Assert.assertEquals("Verify Login", "Quick Launchpad", new DashboardPage().dashboardTitle.getText());
                break;
            case "sales_manager":
                Assert.assertEquals("Verify Login", "Dashboard", new DashboardPage().dashboardTitle.getText());
                break;
            case "store_manager":
                Assert.assertEquals("Verify Login", "Dashboard", new DashboardPage().dashboardTitle.getText());
                break;
            default:
                System.out.println("INVALID CRIDENTIALS");
        }
    }

    @When("user should navigates to Cars page")
    public void user_should_navigates_to_Cars_page() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(15);
        try {
            dashboardPage.addEventClose.click();
        } catch (NoSuchElementException exception) {
            System.out.println("Did not open the add event");
        }
        dashboardPage.navigateToModule("Fleet", "Vehicles");
        new FleetVehiclePage().waitUntilLoaderScreenDisappear();
    }

    @Given("user clicks the select all button which belongs to grid settings")
    public void userClicksTheSelectAllButtonWhichBelongsToGridSettings() {
        TableArrangementPage carsPage = new TableArrangementPage();
        carsPage.selectAllMethod();
//        System.out.println(carsPage.getTableHeadersText().toString());
        //Assert.assertEquals("Verify al headers selected",(carsPage.showList.size()+1), (carsPage.getTableHeadersText().size()/2));
        //Assert.assertFalse("Verify al headers selected", new CarsPage().selectAll.isEnabled());
        //Assert.assertTrue("Verify al headers selected", new CarsPage().showList.get(0).isSelected());
        Assert.assertTrue(new TableArrangementPage().getTableHeadersText().contains("id"));

    }

    @Given("all selected options should be seen, all not selected options shouldn't be seen")
    public void all_selected_options_should_be_seen_all_not_selected_options_shouldn_t_be_seen() {
        new TableArrangementPage().checkGridSettings();
    }

    @When("drag and drop any element, needs to be changed it's order")
    public void dragAndDropAnyElementNeedsToBeChangedItSOrder() {
        String dummy;
        Actions actions = new Actions(Driver.get());
        TableArrangementPage carsPage = new TableArrangementPage();
        for (int i = 0; i < 5; i++) {
            dummy = carsPage.gridTableList.get(0).getText();
            BrowserUtils.waitForPageToLoad(10);
            actions.moveToElement(carsPage.sortList.get(0)).clickAndHold().pause(100).moveToElement(carsPage.tableRowList.get(10)).pause(100).release().build().perform();
            BrowserUtils.waitForPageToLoad(10);
            //BrowserUtils.waitFor(1);
//            System.out.println("dummy = " + dummy);
//            System.out.println("carsPage.gridTableList.get(0).getText() = " + carsPage.gridTableList.get(0).getText());
            Assert.assertFalse(dummy == carsPage.gridTableList.get(0).getText());
            carsPage.gridSettings.click();
        }

    }


    @Given("user select for view page number as {int}")
    public void user_select_for_view_page_number_as(Integer int1) {
        BrowserUtils.waitFor(2);
        new TableArrangementPage().pageDropdown.click();
        new TableArrangementPage().selectPageRow(int1).click();

    }
    @Then("there should be {int} row in the page")
    public void there_should_be_row_in_the_page(Integer int1) {
        String expected = Integer.toString(int1);
        String actual = new TableArrangementPage().pageDropdown.getAttribute("innerHTML").split("<")[0].trim();
        Assert.assertEquals("Verify selected row number-" + int1 ,expected,actual);
//        System.out.println("Actual-" + actual + "    Expected-" + expected );
    }


    @And("user clicks reset button")
    public void userClicksResetButton() {
        new TableArrangementPage().resetButton.click();
    }


    @When("user clicks {int}")
    public void user_clicks(Integer int1) {
        new TableArrangementPage().carsTitle.click();
        new TableArrangementPage().getTableHeaderElement(int1).click();
    }

    @Then("first data row needs to be same")
    public void first_data_row_needs_to_be_same() {
        BrowserUtils.waitForPageToLoad(10);
        Assert.assertEquals("Verify reset button with headers" , dummy , new TableArrangementPage().getFirstRowTextList());
    }

    List<String> dummy;
    @When("user take the first row text")
    public void userTakeTheFirstRowText() {
        BrowserUtils.waitForPageToLoad(10);
        dummy = new TableArrangementPage().getFirstRowTextList();
    }

    @And("user clicks the next page button")
    public void userClicksTheNextPageButton() {
        new TableArrangementPage().nextPage.click();
    }

    @When("user clicks the {int} header")
    public void user_clicks_the_header(Integer int1) {
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.waitFor(2);
        new TableArrangementPage().gridTableList.get(int1).click();
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.waitFor(1);
    }

    @Then("sort needs to be ascending order by {int}")
    public void sort_needs_to_be_ascending_order_by(Integer int1) {
        new TableArrangementPage().checkAscending(int1);
    }

    @Then("sort needs to be descending order by {int}")
    public void sort_needs_to_be_descending_order_by(Integer int1) {
        new TableArrangementPage().checkDescending(int1);
    }



}