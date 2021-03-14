package com.uiautomation.framework.uiElements;

import com.uiautomation.framework.driverContext.ScenarioContext;
import com.uiautomation.framework.utils.PropertiesUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BaseUIActions {
    WebDriver driver;
    WebDriverWait webDriverWait;
    public long webElementWaitTime;

    public BaseUIActions(ScenarioContext scenarioContext){
        this.driver=scenarioContext.driver;
        this.webElementWaitTime = Long.parseLong(PropertiesUtil.getPropertiesUtil().getApplication("WebElementWaitTime"));
        this.webDriverWait = new WebDriverWait(this.driver,this.webElementWaitTime);
    }
    public synchronized void sendKeys(WebElement element,String value){
        this.waitForElementToBeClickable(element);
        this.scrollIntoView(element);
        element.sendKeys(value);
    }

    public synchronized void scrollIntoView(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor)this.driver;
        jse.executeScript("arguments[0].scrollIntoView();",new Object[]{element});
    }
    public synchronized void jseClick(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor)this.driver;
        jse.executeScript("arguments[0].click();",new Object[]{element});
    }
    public synchronized void click(WebElement element){
        this.waitForElementToBeClickable(element);
        this.scrollIntoView(element);
        element.click();
    }

    public synchronized void waitForElementToBeClickable(WebElement element){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public synchronized void waitForElementToBeVisible(WebElement element){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public synchronized String getTextValue(WebElement element) {
        this.waitForElementToBeVisible(element);
        this.scrollIntoView(element);
        return element.getText().trim();
    }

    public void switchToOpenedTab() {
        String currentTab = driver.getWindowHandle();
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs){
            if (!currentTab.equalsIgnoreCase(tab)){
                driver.switchTo().window(tab);
            }
        }
    }
}
