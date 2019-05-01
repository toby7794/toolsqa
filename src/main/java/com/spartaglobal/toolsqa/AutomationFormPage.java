package com.spartaglobal.toolsqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AutomationFormPage {

    private WebDriver driver;
    private final By partialLinkTest = By.linkText("Partial Link Test");
    private final By linkTest = By.linkText("Link Test");
    private final By linkTable = By.className("tsc_table_s13");
    private final By firstName = By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div[2]/div/form/fieldset/div[8]/input");
    private final By lastName = By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div[2]/div/form/fieldset/div[11]/input");
    private final By sexElements = By.name("sex");
    private final String practiceFormURL = "https://www.toolsqa.com/automation-practice-form/";
    private List<String> sexRadioButtonElements;


    public AutomationFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By element){
        return driver.findElement(element);}

    public AutomationFormPage goToHomePage() {
        driver.navigate().to(practiceFormURL);
        return this;
    }

    public boolean partialLinkTestDisplayed() {
        return findElement(partialLinkTest).isDisplayed();
    }

    public String partialLinkTestText(){
        return findElement(partialLinkTest).getText();
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }


    public AutomationFormPage partialLinkTestClick() {
        findElement(partialLinkTest).click();
        return this;
    }

    public AutomationFormPage linkTestClick(){
        findElement(linkTest).click();
        return this;
    }

    public boolean linkTableDisplayed(){
        return findElement(linkTable).isDisplayed();
    }

    public AutomationFormPage inputFirstName(String first){
        findElement(firstName).sendKeys(first);
        return this;
    }

    public boolean firstNameDisplayed(){
        return findElement(firstName).isDisplayed();
    }

    public String getDisplayedFirstName(){
        return findElement(firstName).getAttribute("value");
    }

    public AutomationFormPage inputLastName(String first){
        findElement(lastName).sendKeys(first);
        return this;
    }

    public boolean lastNameDisplayed(){
        return findElement(lastName).isDisplayed();
    }

    public String getDisplayedLastName(){
        return findElement(lastName).getAttribute("value");
    }

    public List<WebElement> findElements(By element){
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

    private void getSexElements(){
        List<String> sexRadioBElements = new ArrayList<>();  //creates a new string arraylist

        for (WebElement sexElement : driver.findElements(sexElements)) {  //find elements make a list of button elements and uses By.name("sex") to get them all since this is the heading they have in common.
            sexRadioBElements.add(sexElement.getAttribute("value")); //adds the string value i.e. "male and "female" to the newly created arraylist corresponding to each button
        }

        sexRadioButtonElements =  sexRadioBElements; //assigns the created liststring to the memeber variable of the class
    }

    public void selectSex(String sexSelected) { //sex selected is the button whose corresponding value that you want to click on
        if (sexRadioButtonElements == null) { getSexElements(); }  //creates the string array using above private method

        if (sexRadioButtonElements.contains(sexSelected)){ //checks to see if the new liststring contains the value you want to accept
            driver.findElement(By.id("sex-" + sexRadioButtonElements.indexOf(sexSelected))).click(); //if true append the index of the position in the arraylist of the selected button in order to click the right button
        } else {
            throw new IllegalArgumentException("The requested element was not available. Please use one of the following " + sexRadioButtonElements); // if the button valiue is not in the string it will throw an exception and give the list of valid sex to select in the call
        }
    }

    public boolean checkSelectedSexButton(String selectedSex){
        boolean isSexSelected;
        if (sexRadioButtonElements == null) { getSexElements(); } //same as above

        if (sexRadioButtonElements.contains(selectedSex)){ //same as above
            isSexSelected = driver.findElement(By.id("sex-" + sexRadioButtonElements.indexOf(selectedSex))).isSelected(); // checks to see if the selected button is selected
        } else {
            throw new IllegalArgumentException("The requested element was not selected. Please use one of the following " + sexRadioButtonElements + " & that it hs been successfully selected");
        }
        return isSexSelected;
    }

}
