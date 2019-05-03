package com.spartaglobal.toolsqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

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

//    @Test
//    public void isSizeOfSexList(){
//        setup();
//        int size = 2;
//        Assert.assertEquals(toolsWebsite.AutomationFormPage().goToHomePage().sexessize(),2);
//    }
//
//    @Test
//    public void isSexButtonsDisplayed(){
//        setup();
//        Boolean [] truthArray = new Boolean[] {true, true};
//        Assert.assertArrayEquals(toolsWebsite.AutomationFormPage().goToHomePage().sexesButtonsDisplayed(), truthArray);
//    }

    @Test
    public void isSexButtonSelected(){
        setup();
        Assert.assertTrue(toolsWebsite.AutomationFormPage().goToHomePage().selectSex("Male").checkSelectedSexButton("Male"));
    }

    @Test
    public void isAfterSelectingOneButtonClickOntheOtherIsThatSelectedAndTheOtherOneNotSelected(){
        setup();
        toolsWebsite.AutomationFormPage().goToHomePage().selectSex("Male");
        Assert.assertTrue(toolsWebsite.AutomationFormPage().goToHomePage().selectSex("Female").checkSelectedSexButton("Female"));
        Assert.assertFalse(toolsWebsite.AutomationFormPage().goToHomePage().checkSelectedSexButton("Male"));
    }

    @Test
    public void isExperianceButtonSelected(){
        setup();
        Assert.assertTrue(toolsWebsite.AutomationFormPage().goToHomePage().selectExperianceButton("5").checkExperianceButton("5"));
    }

    @Test
    public void isDateDisplayed(){
        setup();
        Assert.assertTrue(toolsWebsite.AutomationFormPage().goToHomePage().DateDisplayed());
    }

    @Test
    public void isDateTextDisplayed(){
        setup();
        String date = "12/12/2012";
        Assert.assertEquals(toolsWebsite.AutomationFormPage().goToHomePage().inputDate(date).getDisplayedDate(), date);
    }

    @Test
    public void isBothProfessionButtonsSelected(){
        setup();
        toolsWebsite.AutomationFormPage().goToHomePage().selectProfessionButton("Manual Tester").selectProfessionButton("Automation Tester");

        Assert.assertTrue(toolsWebsite.AutomationFormPage().checkprofessionButton("Manual Tester") && toolsWebsite.AutomationFormPage().checkprofessionButton("Automation Tester"));
    }

    @Test
    public void isManualProfessionButtonSelected(){
        setup();
        toolsWebsite.AutomationFormPage().goToHomePage().selectProfessionButton("Manual Tester");

        Assert.assertTrue(toolsWebsite.AutomationFormPage().checkprofessionButton("Manual Tester"));
    }

    @Test
    public void isAutomaticProfessionButtonSelected(){
        setup();
        toolsWebsite.AutomationFormPage().goToHomePage().selectProfessionButton("Automation Tester");

        Assert.assertTrue(toolsWebsite.AutomationFormPage().checkprofessionButton("Automation Tester"));
    }

    @Test
    public void isAllThreeToolButtonsSelected(){
        setup();
        toolsWebsite.AutomationFormPage().goToHomePage().selecttoolButton("QTP").selecttoolButton("Selenium IDE").selecttoolButton("Selenium Webdriver");

        Assert.assertTrue(toolsWebsite.AutomationFormPage().checktoolButton("QTP") && toolsWebsite.AutomationFormPage().checktoolButton("Selenium IDE")&& toolsWebsite.AutomationFormPage().checktoolButton("Selenium Webdriver"));
    }

    @Test
    public void isTwoToolButtonsSelected(){
        setup();
        toolsWebsite.AutomationFormPage().goToHomePage().selecttoolButton("QTP").selecttoolButton("Selenium IDE");

        Assert.assertTrue(toolsWebsite.AutomationFormPage().checktoolButton("QTP") && toolsWebsite.AutomationFormPage().checktoolButton("Selenium IDE"));
    }

    @Test
    public void isQTPToolButtonsSelected(){
        setup();
        toolsWebsite.AutomationFormPage().goToHomePage().selecttoolButton("QTP");

        Assert.assertTrue(toolsWebsite.AutomationFormPage().checktoolButton("QTP"));
    }

    @Test
    public void isHybridFrameWorkDisplayed(){
        setup();
        Assert.assertTrue(toolsWebsite.AutomationFormPage().goToHomePage().seleniumAutomationHybridFrameworkDisplayed());
    }

    @Test
    public void isHybridFrameWorkTextDisplayed(){
        setup();
        Assert.assertEquals(toolsWebsite.AutomationFormPage().goToHomePage().seleniumAutomationHybridFrameworkDisplayedTextTest(), "Selenium Automation Hybrid Framework");
    }

    @Test
    public void checkHybridFrameWorkURL(){
        setup();
        Assert.assertEquals(toolsWebsite.AutomationFormPage().goToHomePage().getHybridFrameWorkURLAttribute(), "http://toolsqa.com/wp-content/uploads/2014/04/OnlineStore.zip");
    }

    @Test
    public void isTestFileDisplayed(){
        setup();
        Assert.assertTrue(toolsWebsite.AutomationFormPage().goToHomePage().seleniumAutomationTestFileDisplayed());
    }

    @Test
    public void isTestFileTextDisplayed(){
        setup();
        Assert.assertEquals(toolsWebsite.AutomationFormPage().goToHomePage().seleniumAutomationTestFileDisplayedTextTest(), "Test File to Download");
    }

    @Test
    public void checkTestFileURL(){
        setup();
        Assert.assertEquals(toolsWebsite.AutomationFormPage().goToHomePage().getTestFileDisplayURLAttribute(), "http://toolsqa.com/wp-content/uploads/2016/09/Test-File-to-Download.xlsx");
    }

//    @Test
//    public void checkSpecificContinent(){
//        setup();
//        Assert.assertEquals(toolsWebsite.AutomationFormPage().goToHomePage().selectSpecificContinent(2).getStringOfSpecificContinent(), "Africa");
//    }














}
