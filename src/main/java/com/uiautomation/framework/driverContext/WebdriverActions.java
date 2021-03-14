package com.uiautomation.framework.driverContext;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebdriverActions {
    private WebDriver driver;
    public WebDriver getWebDriver(String browser){
        switch (browser.toUpperCase()){
            case "CHROME":
                this.driver=this.setUpChromeBrowser();
                break;
            case "IE":
                this.driver = this.setUpIEBrowser();
                break;
            case "FIREFOX":
                this.driver = this.setUpFirefoxBrowser();
                break;
        }
        this.driver.manage().window().maximize();
        System.out.println("");
        return this.driver;
    }

    private WebDriver setUpFirefoxBrowser(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private WebDriver setUpChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private WebDriver setUpIEBrowser(){
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }
    public void closeBrowser(WebDriver driver,String scenarioName){
        if (driver!=null){
            driver.quit();
        }
    }
}
