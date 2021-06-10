package com.cybertek.tests.Practice_Selenium.P1_Xpath_Practice_1;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
  DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
  TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
  1. Open Chrome browser
  2. Go to http://practice.cybertekschool.com/add_remove_elements/
  3. Click to “Add Element” button
  4. Verify “Delete” button is displayed after clicking.
  5. Click to “Delete” button.
  6. Verify “Delete” button is NOT displayed after clicking.
  USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */
public class P2_Xpath_Practice_2 {

    WebDriver driver;

    @BeforeMethod
    public void setupDriver(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");


    }
    @Test
    public void window_test() throws InterruptedException {

//3.Click to “Add Element” button==> this is step is needed to add when locating a web element
        WebElement addElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        Thread.sleep(1000);
        addElementButton.click();

//4. Verify “Delete” button is displayed after clicking. you repeat the step again for the next verify button

       WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));

       if (deleteButton.isDisplayed()){
           System.out.println("Delete button is displayed. Verification PASSED!");
       }else{
           System.out.println("Delete button is displayed. Verification FAILED!");
       }
//  5. Click to “Delete” button. in the fifth step only one more time we are clicking because is what the task require
        // to do so we just click th button once again since we already located the web element
        deleteButton.click();

// 6. Verify “Delete” button is NOT displayed after clicking. after we run the code we get an additional web element error
//   StaleElementReferenceException: stale element reference: element is not attached to the page document.
//   To handle this Exception we have to created and additional step
//  two ways to handle an Exception are  first one is TRY & CATCH SECOND THROWING OUTSIDE THE METHOD!
// for this exception we are going to use try & catch
    try {
    deleteButton.click();
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
