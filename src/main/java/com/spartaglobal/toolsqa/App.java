package com.spartaglobal.toolsqa;

import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {System.setProperty("webdriver.chrome.driver", "C:\\Users\\TGoddard\\Documents\\chromedriver\\chromedriver.exe");
    ToolsHome toolsWebsite = new ToolsHome(new ChromeDriver());
        System.out.println(toolsWebsite.AutomationFormPage().goToHomePage().partialLinkTestDisplayed());

    }
}
