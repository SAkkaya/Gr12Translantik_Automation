package com.translantik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GeneralInformationPage extends BasePage{

    public WebDriver driver;

    @FindBy(xpath = "//div[@class='pull-left btn-group icons-holder']/a")
    public List<WebElement>buttons;

    @FindBy(xpath = "//a[.='Activity']")
    public WebElement activityButton;

    @FindBy(xpath = "//div[@class='details']")
    public List<WebElement> events;

    @FindBy(xpath = "//div[@class='control-group attribute-row']/div/div")
    public List<WebElement> carInfo;

    @FindBy(xpath = "//div[@class='pull-left btn-group icons-holder']/a/i")
    public WebElement addEventButton;

    @FindBy(xpath = "//h5/span")
    public WebElement pageHeader;

    @FindBy(css = ".add-filter-button")
    public WebElement addFilterButton;

    @FindBy(css = "[for='ui-multiselect-0-0-option-2'] > span")
    public WebElement driverFilterButton;

    @FindBy(css = ".filter-item-hint > span")
    public List<WebElement> DriverDropDownMenuList;

    @FindBy(css = ".filter-item-hint > span")
    public WebElement DriverDropDownMenu;

    @FindBy(css = ".btn-block > .btn")
    public WebElement DropDownButton;

    @FindBy(css = ".filter-update")
    public WebElement updateButton;

    @FindBy(css = "[name='value']")
    public WebElement filterValue;



    public void DriverDropDownSet(){
        addFilterButton.click();
        driverFilterButton.click();
    }

    public void sendValueAndFilter(String value, String method){
        DriverDropDownMenu.click();
        DropDownButton.click();
        driver.findElement(By.cssSelector("[data-value='"+method+"']")).click();
        filterValue.sendKeys(value);
    }




    /*
    public String getProperty(String info){

        return Driver.get().findElement(By.xpath("//label[contains(text(),'"+info+"')]")).getText();

    }

    public List<String> getALlInfo(){
        List<String> AllInfo = new ArrayList<>();

        AllInfo.add(getProperty("Model"));
        AllInfo.add(getProperty("Make"));
        AllInfo.add(getProperty("Can"));
        AllInfo.add(getProperty("Catalog"));
        AllInfo.add(getProperty("CO2 Fee"));
        AllInfo.add(getProperty("Cost"));
        AllInfo.add(getProperty("Total Cost"));
        AllInfo.add(getProperty("CO2 Emissions"));
        AllInfo.add(getProperty("Fuel Type"));
        AllInfo.add(getProperty("Vendors"));

        return AllInfo;
    }

     */


}
