

package com.translantik.pages;

import com.translantik.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GeneralInformationPage extends BasePage{

    public WebDriver driver;

    @FindBy(css = "[title='Add an event to this record']")
    public WebElement addEventButton;

    @FindBy (xpath = "//span[text()='General Information']")
    public WebElement titleGenInforPage;


    @FindBy(xpath = "//div[@class='pull-left btn-group icons-holder']/a")
    public List<WebElement>buttons;

    @FindBy(xpath = "//a[.='Activity']")
    public WebElement activityButton;

    @FindBy(xpath = "//div[@class='details']")
    public List<WebElement> events;

    @FindBy(xpath = "//div[@class='control-group attribute-row']/div/div")
    public List<WebElement> carInfo;

    @FindBy(xpath = "//h5/span")
    public WebElement pageHeader;

    @FindBy(xpath = "//a[@class=\"add-filter-button\"]")
    public WebElement addFilterButton;

    @FindBy(id = "ui-multiselect-0-0-option-2")
    public WebElement driverCheckbox;

    @FindBy(id = "ui-multiselect-0-0-option-3")
    public WebElement locationCheckbox;

    @FindBy(xpath = "//*[@id=\"grid-custom-entity-grid-1584742414\"]/div[1]/div/span/div[3]/div[2]/div/div[1]/ul")
    public List<WebElement> DriverDropDownMenuList;

    @FindBy(css = ".filter-criteria-selector")
    public WebElement DropDownMenu;

    @FindBy(css = ".btn-block > .btn")
    public WebElement DropDownButton;

    @FindBy(css = ".filter-update")
    public WebElement updateButton;

    @FindBy(css = "[name='value']")
    public WebElement filterValue;

    @FindBy(xpath = "//div[@class='control-group attribute-row']")
    public List<WebElement> generalIfoPageEvents;

    @FindBy(css = "[data-value='1']")
    public WebElement contains;

    @FindBy(css = "[data-value='2']")
    public WebElement doesNotContain;

    @FindBy(css = "[data-value='3']")
    public WebElement isEqualTo;

    @FindBy(css = "[data-value='4']")
    public WebElement startsWith;

    @FindBy(css = "[data-value='5']")
    public WebElement EndsWith;

    @FindBy(css = "[data-value='6']")
    public WebElement isAnyOf;

    @FindBy(css = "[data-value='7']")
    public WebElement isNotAnyOf;

    @FindBy(css = "[data-value='8']")
    public WebElement isEmpty;

    @FindBy(css = "[data-value='9']")
    public WebElement isNotEmpty;

    @FindBy(xpath = "//div[@class='filter-item oro-drop']/div[1]")
    public WebElement filterAllButton;

    @FindBy(xpath = "//a[@class='dropdown-item choice-value']")
    public List<WebElement> filterTypes;


    public void DriverDropDownSet(){
        addFilterButton.click();
        driverCheckbox.click();
    }

    public void LocationDropDownSet(){
        addFilterButton.click();
        locationCheckbox.click();
    }

    public void sendValueAndFilter(String value, String method){
        DropDownMenu.click();
        DropDownButton.click();
        driver.findElement(By.cssSelector("[data-value='"+method+"']")).click();
        filterValue.sendKeys(value);
    }

    public void methodSelect(String method){
        DropDownMenu.click();
        driver.findElement(By.cssSelector("[data-value='"+method+"']")).click();
    }

    public WebElement getdataColumns(String dataColumns){
        String css = "[data-value='"+dataColumns+"']";
        return Driver.get().findElement(By.cssSelector(css));
    }

    // something

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