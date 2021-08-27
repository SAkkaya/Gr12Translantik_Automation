package com.translantik.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddEventPage extends BasePage {

    @FindBy (xpath = "//label[@aria-required='true']")
    public List<WebElement> actualCompulsoryFields;

    @FindBy (xpath = "(//input[@placeholder='Choose a date'])[1]")
    public WebElement startTextBox;

    @FindBy (xpath = "(//input[@placeholder='Choose a date'])[2]")
    public WebElement endTextBox;

    @FindBy (css = ".btn.btn-primary")
    public WebElement saveBtn;

    @FindBy (xpath = "//span[text()='This value should not be blank.']")
    public List<WebElement> ucluAppearedCompulsoryBlankText;

    @FindBy (xpath = "//span[@class='color']")
    public List<WebElement> colorsUrgencyLevel;

    @FindBy (xpath = "oro_calendar_event_form[allDay]")
    public WebElement allDayEventCheckBox;

    @FindBy (xpath = "//input[@placeholder='time']")
    public List<WebElement> startEndTime;

    @FindBy (xpath = " //input[@data-name='recurrence-repeat']")
    public WebElement repeatCheckBox;

    @FindBy (xpath = "//select[@class='recurrence-repeats__select']")
    public WebElement selectRepeats;

    @FindBy (xpath = "//div[@class='controls recurrence-subview-control recurrence-subview-control__items']/div[3]")
    public List<WebElement> endsOccurance;


}
