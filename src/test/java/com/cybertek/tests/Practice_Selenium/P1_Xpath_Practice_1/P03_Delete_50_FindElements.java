package com.cybertek.tests.Practice_Selenium.P1_Xpath_Practice_1;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P03_Delete_50_FindElements {
/*    TC #3: PracticeCybertek.com_AddRemoveElements WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/add_remove_elements
3. Click to “Add Element” button 50 times
4. Verify 50 “Delete” button is displayed after clicking.
5. Click to ALL “Delete” buttons to delete them.
6. Verify “Delete” button is NOT displayed after clicking. USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS Hint: Need to use findElements method.
    */
    WebDriver driver;

    @BeforeMethod
    public void setupDriver(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
    }
    @Test
    public void window_test(){
 //3. Click to “Add Element” button 50 times
        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int i = 0; i <50 ; i++) {
            addElement.click();
        }

        
//4. Verify 50 “Delete” button is displayed after clicking. added-manually

        List<WebElement>listOfDeleteButton = driver.findElements(By.xpath("//button[@class='added-manually']"));

        WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']")); //  this additional line needs to be added to
 //  get throw the StaleElementReferenceException  on the upcoming (try & catch)
        System.out.println("Number of delete buttons on the page = " + listOfDeleteButton.size()); //just to make sure we have the 50 delete buttons


//5. Click to ALL “Delete” buttons to delete them.
 // here we are using a each loop so we can check all the re-click on all the buttons again.
        for (WebElement button : listOfDeleteButton){
            button.click();
        }

//6. Verify “Delete” button is NOT displayed after clicking.
        try {

            if (!deleteButton.isDisplayed()) {
                System.out.println("delete button is not display after clicking. Passed");
            } else {
                System.out.println("Delete button is display after clicking. Failed! ");
            }
        }    catch (StaleElementReferenceException exception){
            System.out.println("StaleElementReferenceException has been thrown.");
            System.out.println("It means elements has been completely deleted from HTML.");
            System.out.println("Delete button is not display. Verification PASSED! ");
        }



    }
}
