package com.project.testngCucumber.stepDef;

import com.project.testngCucumber.pages.GalactioPage;
import com.project.testngCucumber.pages.LoginPage;
import com.project.testngCucumber.pages.WindowHandlePage;
import com.uiautomation.framework.driverContext.ScenarioContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MapSyncTestStep {
    private ScenarioContext scenarioContext;
    private LoginPage loginPage;
    private GalactioPage galactioPage;
    public MapSyncTestStep(ScenarioContext scenarioContext){
        this.scenarioContext=scenarioContext;
        this.loginPage = new LoginPage(scenarioContext);
        this.galactioPage = new GalactioPage(scenarioContext);
    }
    @When("User login with {string} and {string}")
    public void userLoginWithUsernameAndPassword(String username,String password) {
        loginPage.performLogin(username, password);
    }

    @Then("User validate the login error message as {string}")
    public void userValidateTheLoginErrorMessageAsErrorMessage(String message) {
        loginPage.validateLoginErrorMessage(message);
    }

    @Given("User on the home page {string}")
    public void userOnTheHomePage(String homepageTitle) {
        loginPage.validateHomePageTitle(homepageTitle);
    }

    @When("User click on Galactio button")
    public void userClickOnGalactioButton() {
        galactioPage.navigateToGalactioPage();
    }

    @Then("User validate the Galactio page {string}")
    public void userValidateTheGalactioPage(String pageTitle) {
        galactioPage.validateGalactioPage(pageTitle);
    }
}
