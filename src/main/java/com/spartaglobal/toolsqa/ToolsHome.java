package com.spartaglobal.toolsqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToolsHome {

    private WebDriver driver;

    public ToolsHome(WebDriver driver) {
        this.driver = driver;
    }

    public AutomationFormPage AutomationFormPage(){
        return new AutomationFormPage(driver);
    }


    public void quitDriver(){
        driver.quit();
    }

}
