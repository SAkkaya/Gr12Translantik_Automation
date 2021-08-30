package com.translantik.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

@FindBy(css = ".ui-button")
    public WebElement addEventClose;

    @FindBy(className = "oro-subtitle")
    public WebElement dashboardTitle;

}