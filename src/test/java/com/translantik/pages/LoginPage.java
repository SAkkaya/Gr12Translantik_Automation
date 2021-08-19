package com.translantik.pages;

import com.translantik.utils.BrowserUtils;
import com.translantik.utils.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="prependedInput")
    public WebElement userName;

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(name = "_submit")
    public WebElement submit;

    @FindBy(xpath = "//div[@class='alert alert-error']/div")
    public WebElement invalidLoginMessage;

    public static String emptyMessage;

    @FindBy(xpath = "//h2[@class='title']")
    public WebElement loginName;

    public void login(String userNameStr, String passwordStr) {

        userName.sendKeys(userNameStr);
        BrowserUtils.waitForVisibility(password, 2);
        password.sendKeys(passwordStr);
        submit.click();

        if (userName.getText().isEmpty() && password.getText().isEmpty()){
            String  message1=password.getAttribute("validationMessage");
            String  message2=userName.getAttribute("validationMessage");
            if (message1.isEmpty()){
                emptyMessage=message2;
            }else{
                emptyMessage=message1;
            }

        }

    }

    public void login(String userNameStr, String passwordStr, String submitType) {

        if(submitType.equals("submitButton")){
            BrowserUtils.waitForVisibility(userName, 10);
            userName.sendKeys(userNameStr);
            BrowserUtils.waitForVisibility(password, 10);
            password.sendKeys(passwordStr);
            submit.click();
        }else{
            BrowserUtils.waitForVisibility(userName, 10);
            userName.sendKeys(userNameStr);
            BrowserUtils.waitForVisibility(password, 10);
            password.sendKeys(passwordStr+Keys.ENTER);

        }

    }


    public void logout(){

        BrowserUtils.waitFor(2);

        new DashboardPage().logOutLink.click();
        BrowserUtils.waitFor(2);


    }




}
