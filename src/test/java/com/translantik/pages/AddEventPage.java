package com.translantik.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddEventPage extends BasePage {

    @FindBy (xpath = "//label[@aria-required='true']")
    public List<WebElement> actualCompulsoryFields;


}
