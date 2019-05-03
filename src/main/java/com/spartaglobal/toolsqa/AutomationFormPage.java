package com.spartaglobal.toolsqa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AutomationFormPage {

    private WebDriver driver;
    private final By partialLinkTest = By.linkText("Partial Link Test");
    private final By linkTest = By.linkText("Link Test");
    private final By linkTable = By.className("tsc_table_s13");
    private final By firstName = By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div[2]/div/form/fieldset/div[8]/input");
    private final By lastName = By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div[2]/div/form/fieldset/div[11]/input");
    private final By sexElements = By.name("sex");
    private final By experianceElements = By.name("exp");
    private final By date = By.id("datepicker");
    private final By professionElements = By.name("profession");
    private final By toolElements = By.name("tool");
    private final By hybridFrameworkDownload = By.linkText("Selenium Automation Hybrid Framework");
    private final By testFileDownload = By.linkText("Test File to Download");
    private final By continentElements = By.id("continents");
    private final String practiceFormURL = "https://www.toolsqa.com/automation-practice-form/";
    private final String downLoadURL = "http://toolsqa.com/wp-content/uploads/2014/04/OnlineStore.zip";
    private int numOfKeys;


    private List<String> sexRadioButtonElements;
    private List<String> experianceRadioButtonElements;
    private List<String> toolButtonElements;
    private List<String> professionButtonElements;
    private List<String> continentsElements;


    public AutomationFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By element) {
        return driver.findElement(element);
    }

    public AutomationFormPage goToHomePage() {
        driver.navigate().to(practiceFormURL);
        return this;
    }

    public boolean partialLinkTestDisplayed() {
        return findElement(partialLinkTest).isDisplayed();
    }

    public String partialLinkTestText() {
        return findElement(partialLinkTest).getText();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }


    public AutomationFormPage partialLinkTestClick() {
        findElement(partialLinkTest).click();
        return this;
    }

    public AutomationFormPage linkTestClick() {
        findElement(linkTest).click();
        return this;
    }

    public boolean linkTableDisplayed() {
        return findElement(linkTable).isDisplayed();
    }

    public AutomationFormPage inputFirstName(String first) {
        findElement(firstName).sendKeys(first);
        return this;
    }

    public boolean firstNameDisplayed() {
        return findElement(firstName).isDisplayed();
    }

    public String getDisplayedFirstName() {
        return findElement(firstName).getAttribute("value");
    }

    public AutomationFormPage inputLastName(String first) {
        findElement(lastName).sendKeys(first);
        return this;
    }

    public boolean lastNameDisplayed() {
        return findElement(lastName).isDisplayed();
    }

    public String getDisplayedLastName() {
        return findElement(lastName).getAttribute("value");
    }

    public List<WebElement> findElements(By element) {
        return driver.findElements(element);
    }

//    public int sexessize(){
//        return findElements(sexes).size();
//    }
//
//    public Boolean [] sexesButtonsDisplayed(){
//        List<WebElement> sexesList = findElements(sexes);
//        Boolean [] isDisplayed = new Boolean[sexesList.size()];
//        for (int i = 0; i<sexesList.size(); i++){
//            isDisplayed[i] = sexesList.get(i).isDisplayed();
//        }
//        return isDisplayed;
//    }

    private void getSexElements() {
        List<String> sexRadioBElements = new ArrayList<>();  //creates a new string arraylist

        for (WebElement sexElement : driver.findElements(sexElements)) {  //find elements make a list of button elements and uses By.name("sex") to get them all since this is the heading they have in common.
            sexRadioBElements.add(sexElement.getAttribute("value")); //adds the string value i.e. "male and "female" to the newly created arraylist corresponding to each button
        }

        sexRadioButtonElements = sexRadioBElements; //assigns the created liststring to the memeber variable of the class
    }

    public AutomationFormPage selectSex(String sexSelected) { //sex selected is the button whose corresponding value that you want to click on
        if (sexRadioButtonElements == null) {
            getSexElements();
        }  //creates the string array using above private method

        if (sexRadioButtonElements.contains(sexSelected)) { //checks to see if the new liststring contains the value you want to accept
            driver.findElement(By.id("sex-" + sexRadioButtonElements.indexOf(sexSelected))).click(); //if true append the index of the position in the arraylist of the selected button in order to click the right button
        } else {
            throw new IllegalArgumentException("The requested element was not available. Please use one of the following " + sexRadioButtonElements); // if the button valiue is not in the string it will throw an exception and give the list of valid sex to select in the call
        }
        return this;
    }

    public boolean checkSelectedSexButton(String selectedSex) {
        if (sexRadioButtonElements == null) {
            getSexElements();
        } //same as above

        if (sexRadioButtonElements.contains(selectedSex)) { //same as above
            driver.findElement(By.id("sex-" + sexRadioButtonElements.indexOf(selectedSex))).isSelected(); // checks to see if the selected button is selected
        } else {
            throw new IllegalArgumentException("The requested element was not selected. Please use one of the following " + sexRadioButtonElements + " & that it hs been successfully selected");
        }
        return driver.findElement(By.id("sex-" + sexRadioButtonElements.indexOf(selectedSex))).isSelected();
    }

    private void getExperianceElements() {
        List<String> ExperianceRadioBElements = new ArrayList<>();

        for (WebElement experianceElement : driver.findElements(experianceElements)) {
            ExperianceRadioBElements.add(experianceElement.getAttribute("value"));
        }
        experianceRadioButtonElements = ExperianceRadioBElements;
    }

    public AutomationFormPage selectExperianceButton(String selectedNumber) {
        if (experianceRadioButtonElements == null) {
            getExperianceElements();
        }
        if (experianceRadioButtonElements.contains(selectedNumber)) {
            driver.findElement(By.id("exp-" + experianceRadioButtonElements.indexOf(selectedNumber))).click();
        } else {
            throw new IllegalArgumentException("The requested element was not available. Please use one of the following " + experianceRadioButtonElements);
        }
        return this;

    }

    public boolean checkExperianceButton(String selectedNumber) {
        if (experianceRadioButtonElements == null) {
            getExperianceElements();
        }
        if (experianceRadioButtonElements.contains(selectedNumber)) {
            driver.findElement(By.id("exp-" + experianceRadioButtonElements.indexOf(selectedNumber))).isSelected();
        } else {
            throw new IllegalArgumentException("The requested element was not available. Please use one of the following " + experianceRadioButtonElements);
        }
        return driver.findElement(By.id("exp-" + experianceRadioButtonElements.indexOf(selectedNumber))).isSelected();
    }

    public AutomationFormPage inputDate(String inputDate) {
        findElement(date).sendKeys(inputDate);
        return this;
    }

    public boolean DateDisplayed() {
        return findElement(date).isDisplayed();
    }

    public String getDisplayedDate() {
        return findElement(date).getAttribute("value");
    }


    private void getProfessionElements() {
        List<String> professionRadioBElements = new ArrayList<>();

        for (WebElement professionElement : driver.findElements(professionElements)) {
            professionRadioBElements.add(professionElement.getAttribute("value"));
        }
        professionButtonElements = professionRadioBElements;
    }

    public AutomationFormPage selectProfessionButton(String selectedProfession) {
        if (professionButtonElements == null) {
            getProfessionElements();
        }
        if (professionButtonElements.contains(selectedProfession)) {
            driver.findElement(By.id("profession-" + professionButtonElements.indexOf(selectedProfession))).click();
        } else {
            throw new IllegalArgumentException("The requested element was not available. Please use one of the following " + professionButtonElements);
        }
        return this;
    }

    public boolean checkprofessionButton(String selectedProfession) {
        if (professionButtonElements == null) {
            getProfessionElements();
        }
        if (professionButtonElements.contains(selectedProfession)) {
            driver.findElement(By.id("profession-" + professionButtonElements.indexOf(selectedProfession))).isSelected();
        } else {
            throw new IllegalArgumentException("The requested element was not available. Please use one of the following " + professionButtonElements);
        }
        return driver.findElement(By.id("profession-" + professionButtonElements.indexOf(selectedProfession))).isSelected();
    }

    private void getToolElements() {
        List<String> toolRadioBElements = new ArrayList<>();

        for (WebElement toolElement : driver.findElements(toolElements)) {
            toolRadioBElements.add(toolElement.getAttribute("value"));
        }
        toolButtonElements = toolRadioBElements;
    }

    public AutomationFormPage selecttoolButton(String selectedTool) {
        if (toolButtonElements == null) {
            getToolElements();
        }
        if (toolButtonElements.contains(selectedTool)) {
            driver.findElement(By.id("tool-" + toolButtonElements.indexOf(selectedTool))).click();
        } else {
            throw new IllegalArgumentException("The requested element was not available. Please use one of the following " + toolButtonElements);
        }
        return this;
    }

    public boolean checktoolButton(String selectedTool) {
        if (toolButtonElements == null) {
            getToolElements();
        }
        if (toolButtonElements.contains(selectedTool)) {
            driver.findElement(By.id("tool-" + toolButtonElements.indexOf(selectedTool))).isSelected();
        } else {
            throw new IllegalArgumentException("The requested element was not available. Please use one of the following " + toolButtonElements);
        }
        return driver.findElement(By.id("tool-" + toolButtonElements.indexOf(selectedTool))).isSelected();
    }

    public boolean seleniumAutomationHybridFrameworkDisplayed() {
        return driver.findElement(hybridFrameworkDownload).isDisplayed();
    }

    public String seleniumAutomationHybridFrameworkDisplayedTextTest() {
        return driver.findElement(hybridFrameworkDownload).getText();
    }

    public AutomationFormPage HybridFrameworkClick() {
        findElement(hybridFrameworkDownload).click();
        return this;
    }

    public AutomationFormPage goToDownLoadPage() {
        driver.navigate().to(downLoadURL);
        return this;
    }

    public String getHybridFrameWorkURLAttribute() {
        return driver.findElement(hybridFrameworkDownload).getAttribute("href");
    }

    public boolean seleniumAutomationTestFileDisplayed() {
        return driver.findElement(testFileDownload).isDisplayed();
    }

    public String seleniumAutomationTestFileDisplayedTextTest() {
        return driver.findElement(testFileDownload).getText();
    }

    public String getTestFileDisplayURLAttribute() {
        return driver.findElement(testFileDownload).getAttribute("href");
    }

    public List<String> getContinentElements() {
        ArrayList<String> continents = new ArrayList<>();


        WebElement dropdown = driver.findElement(continentElements);
        List<WebElement> continentOptions = dropdown.findElements(By.tagName("option"));
        Iterator<WebElement> it = continentOptions.iterator();
        while (it.hasNext()) {
            continents.add(it.next().getAttribute("value"));
        }
        continentsElements = continents;
        return continentsElements;
    }


//        for (WebElement continent : driver.findElements(continentElements)) {
//            continents.add(continent.getText());
//        }
//        continentsElements = continents;
//
//        return continentsElements;
//
//    }

    private void selectContinent() {
        driver.findElement(continentElements).click();
    }

    public AutomationFormPage selectSpecificContinent(String continent) {
        getContinentElements();
        selectContinent();
        int numOfDownKeys = continentsElements.indexOf(continent);
        numOfKeys = numOfDownKeys;
        int index = 0;
        if (numOfDownKeys == 0) {
            return this;
        } else {
            while (index < numOfDownKeys) {
                driver.findElement(continentElements).sendKeys(Keys.DOWN);
                index++;
            }
            driver.findElement(continentElements).sendKeys(Keys.ENTER);
            return this;
        }
    }
    public String getStringOfSpecificContinent(){
        return driver.findElement(continentElements).getText();
    }
}


