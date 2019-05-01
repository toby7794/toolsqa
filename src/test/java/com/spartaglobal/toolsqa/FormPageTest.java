package com.spartaglobal.toolsqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormPageTest {

    private ToolsHome toolsWebsite;

    private void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\TGoddard\\Documents\\chromedriver\\chromedriver.exe");
        toolsWebsite = new ToolsHome(new ChromeDriver());
    }

    @Test
    public void ispartialLinkTestDisplayed() {
        setup();
        Assert.assertTrue(toolsWebsite.AutomationFormPage().goToHomePage().partialLinkTestDisplayed());
        toolsWebsite.quitDriver();
    }

    @Test
    public void ispartialLinkTestText() {
        setup();
        Assert.assertEquals(toolsWebsite.AutomationFormPage().goToHomePage().partialLinkTestText(), "Partial Link Test");
        toolsWebsite.quitDriver();
    }

    @Test
    public void ispartialLinkTestClick(){
        setup();
        Assert.assertEquals(toolsWebsite.AutomationFormPage().goToHomePage().partialLinkTestClick().getCurrentURL(), "https://www.toolsqa.com/automation-practice-form/");
    }

    @Test
    public void isLinkTestClick(){
        setup();
        Assert.assertEquals(toolsWebsite.AutomationFormPage().goToHomePage().linkTestClick().getCurrentURL(), "https://www.toolsqa.com/automation-practice-table/");

    }

    @Test
    public void isLinkTableDisplayed(){
        setup();
        Assert.assertTrue(toolsWebsite.AutomationFormPage().goToHomePage().linkTestClick().linkTableDisplayed());
    }


    @Test
    public void isFirstNameBoxDisplayed(){
        setup();
        Assert.assertTrue(toolsWebsite.AutomationFormPage().goToHomePage().firstNameDisplayed());
    }

    @Test
    public void isFirstNameTextDisplayed(){
        setup();
        String text = "toby";
        Assert.assertEquals(toolsWebsite.AutomationFormPage().goToHomePage().inputFirstName(text).getDisplayedFirstName(), text);
    }

    @Test
    public void isLastNameBoxDisplayed(){
        setup();
        Assert.assertTrue(toolsWebsite.AutomationFormPage().goToHomePage().lastNameDisplayed());
    }

    @Test
    public void isLastNameTextDisplayed(){
        setup();
        String text = "toby";
        Assert.assertEquals(toolsWebsite.AutomationFormPage().goToHomePage().inputLastName(text).getDisplayedLastName(), text);
    }

    @Test
    public void isSizeOfSexList(){
        setup();
        int size = 2;
        Assert.assertEquals(toolsWebsite.AutomationFormPage().goToHomePage().sexessize(),2);
    }

    @Test
    public void isSexButtonsDisplayed(){
        setup();
        Boolean [] truthArray = new Boolean[] {true, true};
        Assert.assertArrayEquals(toolsWebsite.AutomationFormPage().goToHomePage().sexesButtonsDisplayed(), truthArray);
    }



}
