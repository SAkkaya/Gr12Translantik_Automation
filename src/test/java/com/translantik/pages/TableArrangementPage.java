package com.translantik.pages;

import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class TableArrangementPage extends BasePage{

    @FindBy(id = "prependedInput")
    public WebElement usernameTextBox;

    @FindBy(id = "prependedInput2")
    public  WebElement passwordTextBox;

    @FindBy(id = "_submit")
    public WebElement loginButton;

    public void login2(String userType){
        Driver.get().get(ConfigurationReader.get("url"));
        usernameTextBox.sendKeys(ConfigurationReader.get(userType + "_username"));
        passwordTextBox.sendKeys(ConfigurationReader.get(userType + "_password"));
        loginButton.click();
    }
    @FindBy(css = ".visibility-cell")
    public List<WebElement> showList;

    @FindBy(css = ".title-cell")
    public List<WebElement> nameList;

    @FindBy(css = ".sort-cell>span>i")
    public List<WebElement> sortList;

    @FindBy(css = ".grid-header>tr>th")
    public List<WebElement> gridTableList;

    @FindBy(css = ".grid-row>td:nth-of-type(3)")
    public List<WebElement> tableRowList;

    public void checkAscending(int k){
        List<WebElement> columns = Driver.get().findElements(By.cssSelector(".grid-row>td:nth-of-type(" + (k+1) + ")"));
        char c1,c2;
        String s1,s2;
        for(int i=0; i<columns.size()-1; i++){
            c1=','; c2=','; s1=","; s2=",";
            s1=columns.get(i+1).getText().toLowerCase();
            s2=columns.get(i).getText().toLowerCase();
            if(s1.length()>0){
                c1=s1.charAt(0);
            }
            if(s2.length()>0){
                c2=s2.charAt(0);
            }
            if(c1!=',' && c2!=','){
                Assert.assertTrue("Verify ascending order - "+new TableArrangementPage().getTableHeadersText().get(k) ,c1 >= c2 );
            }
        }
    }

    public void checkDescending(int k){
        List<WebElement> columns = Driver.get().findElements(By.cssSelector(".grid-row>td:nth-of-type(" + (k+1) + ")"));
        char c1,c2;
        String s1,s2;
        for(int i=0; i<columns.size()-1; i++){
            c1=','; c2=','; s1=","; s2=",";
            s1=columns.get(i+1).getText().toLowerCase();
            s2=columns.get(i).getText().toLowerCase();
            if(s1.length()>0){
                c1=s1.charAt(0);
            }
            if(s2.length()>0){
                c2=s2.charAt(0);
            }
            if(c1!=',' && c2!=','){
                Assert.assertTrue("Verify descending order - "+new TableArrangementPage().getTableHeadersText().get(k) ,c1 <= c2 );
            }
        }
    }


    public List<String> getTableHeadersText(){
        List<String> tableHeadersText = new ArrayList<>();
        for(WebElement each : gridTableList){
            tableHeadersText.add(each.getText().toLowerCase());
        }
        return tableHeadersText;
    }

    public void selectAllMethod(){
        BrowserUtils.waitForClickablility(gridSettings,15);
        BrowserUtils.waitFor(1);
        gridSettings.click();
//        BrowserUtils.waitForClickablility(selectAll,10);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].click();", selectAll);
        BrowserUtils.waitForPageToLoad(10);
    }

    @FindBy(css = ".fa-chevron-right.hide-text")
    public WebElement nextPage;

    @FindBy(className = "oro-subtitle")
    public WebElement carsTitle;

    @FindBy(css = "a[title='Grid Settings']")
    public WebElement gridSettings;

    @FindBy(css = "a[data-role='column-manager-select-all']")
    public WebElement selectAll;

    @FindBy(css = "input[placeholder='Quick Search']")
    public  WebElement gridSearchBox;

    public void checkGridSettings(){
        String dummy;
        for(int i=0; i<10; i++){
            gridSearchBox.clear();
            dummy = nameList.get(i).getText().toLowerCase();
            gridSearchBox.sendKeys(nameList.get(i).getText());
            Assert.assertTrue("Verify gridTableList displayed - " + nameList.get(i).getText(), getTableHeadersText().contains(dummy));
            showList.get(i).click();
            Assert.assertFalse("Verify gridTableList not displayed - " + nameList.get(i).getText(), getTableHeadersText().contains(dummy));
            showList.get(i).click();
        }
    }

    @FindBy(css = "button[data-toggle='dropdown']")
    public WebElement pageDropdown;

    @FindBy(css = "a[title='Reset']")
    public WebElement resetButton;

    public WebElement selectPageRow(int i){
        WebElement element = Driver.get().findElement(By.cssSelector("a[data-size='" + i + "']"));
        return element;
    }

    public WebElement getTableHeaderElement(int i){
        WebElement element = Driver.get().findElement(By.cssSelector(".grid-header-row>th:nth-of-type("+i+")"));
        return element;
    }

    public WebElement getFirstRowElement(int i){
        WebElement element = Driver.get().findElement(By.cssSelector(".grid-row:nth-of-type(1)>td:nth-of-type("+i+")"));
        return element;
    }

    public List<String> getFirstRowTextList(){
        BrowserUtils.waitFor(5);
        List<WebElement> list = Driver.get().findElements(By.cssSelector(".grid-row:nth-of-type(1)>td"));
        List<String> text = new ArrayList<>();
        for(WebElement element : list){
            text.add(element.getText());
        }
        return text;
    }


}
