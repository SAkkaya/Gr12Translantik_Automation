
package com.translantik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

    public class GeneralInformationPage extends BasePage{


        @FindBy(xpath = "//div[@class='pull-left btn-group icons-holder']/a/i")
        public WebElement addEventButton;

        @FindBy (xpath = "//span[text()='General Information']")
        public WebElement titleGenInforPage;





}
