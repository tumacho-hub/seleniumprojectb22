package com.cybertek.tests.day12_action_upload_isexecutor;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsPractices {
    @Test
    public void tc15_actions_hover(){

        //TC #15: Hover Test
        //1. Go to http://practice.cybertekschool.com/hovers
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");
        // locating all of the images here:
        WebElement img1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement img2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement img3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));
        //locating all the user
        WebElement use1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement use2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement use3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));

        // we must create object of actions class to be able to use methods coming from there
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        //2. Hover over to first image

        actions.moveToElement(img1).perform();
        //3. Assert:
        //a. “name: user1” is displayed 4. Hover over to second image
        Assert.assertTrue(use1.isDisplayed(),"User1 test is not display. FAIL!!!");

        BrowserUtils.sleep(1);

        //4 hover to the second image
        // moving to image2
        actions.moveToElement(img2).perform();
        //5. Assert:
        //a. “name: user2” is displayed 6. Hover over to third image
        Assert.assertTrue(use2.isDisplayed(),"User2 test is not display. FAIL!!!");

        BrowserUtils.sleep(1);
        //6. hover over to third image
        actions.moveToElement(img3).perform();
        Assert.assertTrue(use3.isDisplayed(),"User3 test is not display. FAIL!!!");

        //7. Confirm:
        //a. “name: user3” is displayed


    }

    @Test
    public void scrolling_test(){
        Driver.getDriver().get("http://practice.cybertekschool.com/");
        // scroll down to "Powered by Cybertek School
        Actions actions = new Actions(Driver.getDriver());
         // Locate "Power By Cybertek School
        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));

        //Scroll using actions object
        BrowserUtils.sleep(2);
        actions.moveToElement(cybertekSchoolLink).perform();

        // Scrolling up using keys.Page_up button
        BrowserUtils.sleep(2);
        actions.sendKeys(Keys.PAGE_UP).perform();

        BrowserUtils.sleep(2);
        actions.sendKeys(Keys.PAGE_UP).perform();

        BrowserUtils.sleep(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

}
