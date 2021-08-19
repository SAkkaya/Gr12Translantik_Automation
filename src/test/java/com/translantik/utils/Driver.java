package com.translantik.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    private Driver() {
    }

    // private static WebDriver driver; //single
    private static InheritableThreadLocal<WebDriver> driver=new InheritableThreadLocal<>(); //parallel

    public static WebDriver get() {
        if (driver.get() == null) {
            String browser=System.getProperty("browser")!=null? System.getProperty("browser"): ConfigurationReader.get("browser");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    //  driver = new ChromeDriver(); //single
                    driver.set(new ChromeDriver()); //parallel
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    //  driver = new ChromeDriver(new ChromeOptions().setHeadless(true)); //single
                    driver.set(new ChromeDriver(new ChromeOptions().setHeadless(true))); //parallel
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    //  driver = new FirefoxDriver(); //single
                    driver.set( new FirefoxDriver()); //parallel
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    // driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true)); //single
                    driver.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true))); //parallel
                    break;

                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support IE");
                    WebDriverManager.iedriver().setup();
                    // driver = new InternetExplorerDriver(); // single
                    driver.set(new InternetExplorerDriver());
                    break;
                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    WebDriverManager.edgedriver().setup();
                    //  driver = new EdgeDriver(); //single
                    driver.set(new EdgeDriver()); //parallel
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support safari");
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    //  driver = new SafariDriver(); //single
                    driver.set(new SafariDriver()); //parallel
                    break;

                case "remote_chrome":

                    ChromeOptions chromeOptions=new ChromeOptions();
                    chromeOptions.setCapability("platform", Platform.ANY);
                    try {
                        driver.set(new RemoteWebDriver(new URL("http://localhost:7777/wd/hub"),chromeOptions));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

            }


        }
        //  return driver; //single
        return   driver.get(); //parallel
    }
    public static void closeDriver(){
        if (driver!=null){
            //  driver.quit(); //single
            driver.get().quit(); //parallel
            // driver=null; //single
            driver.remove();//parallel
        }
    }
}


