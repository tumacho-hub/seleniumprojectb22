package com.cybertek.tests.day14_actionsPractices;

import com.cybertek.pages.DynamicLoadPage1;
import com.cybertek.utilities.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverPractice {
    @Test
    public void dynamic_loading_1_test(){
 //1. Go to http://practice.cybertekschool.com/dynamic_loading/1
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");

        DynamicLoadPage1 dynamicLoadPage1 = new DynamicLoadPage1();
        WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(),10);

//2. Click to start
        dynamicLoadPage1.startButton.click();
//3. Wait until loading bar disappears
        webDriverWait.until(ExpectedConditions.invisibilityOf(dynamicLoadPage1.loadingBar));
//4. Assert username input box is displayed
        Assert.assertTrue(dynamicLoadPage1.inputUsername.isDisplayed());

//5. Enter username: tom smith
        dynamicLoadPage1.inputUsername.sendKeys("tomsmith");



//6. Enter password: incorrect password
        dynamicLoadPage1.inputPassword.sendKeys("incorrectPassword");


//7. Click to Submit button
        dynamicLoadPage1.submitButton.click();

//8. Assert “Your password is invalid!” text is displayed.

        Assert.assertTrue(dynamicLoadPage1.errorMessage.isDisplayed());
//Note: Follow POM Design Pattern


    }

}
