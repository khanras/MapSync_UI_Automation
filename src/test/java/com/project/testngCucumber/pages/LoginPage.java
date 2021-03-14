package com.project.testngCucumber.pages;

import com.uiautomation.framework.driverContext.ScenarioContext;
import com.uiautomation.framework.uiElements.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage extends BasePage {
    ScenarioContext scenarioContext;
    public LoginPage(ScenarioContext scenarioContext){
        super(scenarioContext);
        this.scenarioContext=scenarioContext;
    }
    @FindBy(how= How.XPATH,using = "//a[contains(text(),'Sign in')]")
    private WebElement signInButton;
    @FindBy(how= How.ID,using = "name")
    private WebElement userName;
    @FindBy(how= How.ID,using = "password")
    private WebElement password;
    @FindBy(how= How.NAME,using = "commit")
    private WebElement loginButton;
    @FindBy(how= How.ID,using = "notice")
    private WebElement loginError;

    public void performLogin(String username, String password){
        baseUIActions.click(this.signInButton);
        baseUIActions.sendKeys(this.userName,username);
        baseUIActions.sendKeys(this.password, password);
        baseUIActions.click(this.loginButton);
    }

    public void validateLoginErrorMessage(String expectedErrorMsg) {
        String errorMsg = baseUIActions.getTextValue(this.loginError);
        Assert.assertEquals(errorMsg,expectedErrorMsg,"Expected: "+expectedErrorMsg+ ". Actual: "+errorMsg);
        System.out.println("Actual error message in the application which is expected: "+errorMsg);
    }

    public void validateHomePageTitle(String homepageTitle) {
        String title = scenarioContext.driver.getTitle();
        System.out.println("Page Title: "+title);
        Assert.assertEquals(title,homepageTitle,"Expected: "+homepageTitle+". Actual: "+title);
    }
}