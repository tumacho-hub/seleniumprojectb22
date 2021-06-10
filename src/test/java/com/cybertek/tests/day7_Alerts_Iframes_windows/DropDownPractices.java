package com.cybertek.tests.day7_Alerts_Iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropDownPractices {


    WebDriver driver;
    //String str1;

    /*
    1. Open Chrome browser
    2. Go to http://practice.cybertekschool.com/dropdown
     */
    @BeforeClass
    public void setupClass(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

        //str1 = "something";
    }

    @Test
    public void tc1_simple_dropdown_test(){
        ///str1.substring(1,5);

        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        WebElement currentlySelectedOption = simpleDropdown.getFirstSelectedOption();

        String actualTextOfCurrentOption = currentlySelectedOption.getText();
        String expectedText = "Please select an option";

        Assert.assertTrue(actualTextOfCurrentOption.equals(expectedText));


        //Doing everything in one line: get currently selected option, get the text and compare against expected
        //Assert.assertEquals(simpleDropdown.getFirstSelectedOption().getText(), "Please select an option");

        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State”

        Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        String actualStateDropDownText =  stateDropDown.getFirstSelectedOption().getText();
        String expedtedStateDropDwonText = "Select a State";

        Assert.assertEquals(actualStateDropDownText,expedtedStateDropDwonText);

    }

    @AfterClass
    public void teardownClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
@Test
    public void tc2_state_dropDwon_test() throws InterruptedException {
/*
TC #2: Selecting state from State dropdown and verifying result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
 */

// LOCATING STATE DROPDOWN
    Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
    //    3. Select Illinois
    Thread.sleep(1000);
    stateDropDown.selectByVisibleText("Illinois");

//4. Select Virginia
    Thread.sleep(1000);
    stateDropDown.selectByValue("VA");

//5. Select California
    Thread.sleep(1000);
    stateDropDown.selectByIndex(5);

//6. Verify final selected option is California.

    String expectedOptionText = "California";
    String actualOptionText = stateDropDown.getFirstSelectedOption().getText();

   Assert.assertEquals(actualOptionText,expectedOptionText, "This message will be printed only if assertion fails");
       }



}

