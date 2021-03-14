package com.uiautomation.framework.uiElements;

import com.uiautomation.framework.driverContext.ScenarioContext;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BaseUIActions baseUIActions;
    public BasePage(ScenarioContext scenarioContext){
        PageFactory.initElements(scenarioContext.driver,this);
        this.baseUIActions = new BaseUIActions(scenarioContext);
    }
}
