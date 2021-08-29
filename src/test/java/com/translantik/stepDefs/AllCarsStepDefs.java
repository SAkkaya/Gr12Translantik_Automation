package com.translantik.stepDefs;


import com.translantik.pages.DashboardPage;
import com.translantik.pages.FleetVehiclePage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;



public class AllCarsStepDefs {
//    @When("the user navigates to {string} {string}")
//    public void the_user_navigates_to(String tab, String module) {
//        BrowserUtils.waitFor(7);
//        new DashboardPage().navigateToModule(tab,module);
//        BrowserUtils.waitFor(5);
//    }

    @Then("User should see the table  of vehicle information")
    public void user_should_see_the_table_of_vehicle_information() {
        BrowserUtils.waitForPageToLoad(10);
        FleetVehiclePage allCarsPage = new FleetVehiclePage();
        String title = Driver.get().getTitle();
        Assert.assertTrue(title.contains("Car"));

    }
    @Then("user should see total recordings")
    public void user_should_see_total_recordings() {
        WebElement element = new FleetVehiclePage().totalRecordings;
        Assert.assertTrue(element.isDisplayed());
    }
    @When("user selects the format XLS or CSV under ExportGrid dropdown")
    public void user_selects_the_format_XLS_or_CSV_under_ExportGrid_dropdown() {
        BrowserUtils.waitForPageToLoad(10);
        FleetVehiclePage allCarsPage = new FleetVehiclePage();
        BrowserUtils.waitFor(10);
        allCarsPage.exportGrid.click();
        BrowserUtils.waitFor(2);
        allCarsPage.csv.click();

    }
    /*  @When("user selects the format XLS or CSV under ExportGrid dropdown")
      public void user_selects_the_format_XLS_or_CSV_under_ExportGrid_dropdown() {
          BrowserUtils.waitForClickablility(By.xpath("//div/a/i[@class='fa-upload']"),30);
          Driver.get().findElement(By.xpath("//div/a/i[@class='fa-upload']")).click();
          Driver.get().findElement(By.xpath("//li/a[@title='CSV']")).click();

      }*/
    @Then("user succesfully downloaded the table")
    public void user_succesfully_downloaded_the_table() {
        BrowserUtils.waitForPresenceOfElement(By.xpath("//div[@class='message']"),15);
        WebElement element = new FleetVehiclePage().message;
        Assert.assertTrue(element.isDisplayed());
    }
    @When("user selects different page")
    public void user_selects_different_page() {
        FleetVehiclePage allCarsPage = new FleetVehiclePage();
        allCarsPage.waitUntilLoaderScreenDisappear();
        allCarsPage.pageNum.sendKeys("2");
        allCarsPage.pageNum.sendKeys(Keys.ENTER);


    }

    @Then("user is on selected page and can see total pages")
    public void user_is_on_selected_page_and_can_see_total_pages() {
        FleetVehiclePage allCarsPage = new FleetVehiclePage();
        String expected = "2";
        String actual = allCarsPage.pageNum.getAttribute("value");
        Assert.assertEquals(expected,actual);
        Assert.assertTrue(allCarsPage.totalPages.isDisplayed());
    }

    @Then("the user select the {string} {string} filtering type")
    public void theUserSelectTheFilteringType(String arg0, String arg1) {
        new FleetVehiclePage().selectFilterType(arg0, arg1);
    }
    @Then("the user enters the informations {int} and {int}")
    public void the_user_enters_the_informations_and(Integer int1, Integer int2) {
        new FleetVehiclePage().subFilterBox1.sendKeys(String.valueOf(int1));
        new FleetVehiclePage().subFilterBox2.sendKeys(String.valueOf(int2));
        new FleetVehiclePage().updateButton.click();
        new FleetVehiclePage().waitUntilLoaderScreenDisappear();
    }
    @Then("the user should see the correct results from {string} {string} {int} {int}")
    public void the_user_should_see_the_correct_results_from(String string, String string2, Integer int1, Integer int2) {
        new FleetVehiclePage().checkFilteringResults(string,string2,int1,int2);
    }
    @When("the user navigates2 to {string}, {string}")
    public void the_user_navigates2_to(String tabName, String moduleName) {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(15);
        try{
            dashboardPage.addEventClose.click();
        }catch (NoSuchElementException exception){
            System.out.println("Did not open the add event");
        }
        dashboardPage.navigateToModule(tabName, moduleName);
        new FleetVehiclePage().waitUntilLoaderScreenDisappear();
    }
}
