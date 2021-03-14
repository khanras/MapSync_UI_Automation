package com.project.testngCucumber.pages;

import com.uiautomation.framework.driverContext.ScenarioContext;
import com.uiautomation.framework.uiElements.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class GalactioPage extends BasePage {
    ScenarioContext scenarioContext;
    public GalactioPage(ScenarioContext scenarioContext){
        super(scenarioContext);
        this.scenarioContext=scenarioContext;
    }
    @FindBy(how= How.XPATH,using = "//a[contains(text(),'Galactio')]")
    private WebElement Galactio;
    @FindBy(how= How.XPATH,using = "//a[contains(text(),'Register / Login')]")
    private WebElement GalactioLogin;

    public void navigateToGalactioPage(){
        baseUIActions.click(Galactio);
    }

    public void validateGalactioPage(String pageTitle) {
        baseUIActions.switchToOpenedTab();
        baseUIActions.waitForElementToBeClickable(GalactioLogin);
        String title = scenarioContext.driver.getTitle();
        System.out.println("Page Title: "+title);
        Assert.assertEquals(title,pageTitle,"Expected: "+pageTitle+". Actual: "+title);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}