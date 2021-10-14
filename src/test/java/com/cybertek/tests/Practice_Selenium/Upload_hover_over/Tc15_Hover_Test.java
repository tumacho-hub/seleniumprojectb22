package com.cybertek.tests.Practice_Selenium.Upload_hover_over;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
TC #15: Hover Test
1.Go to http://practice.cybertekschool.com/hovers
2.Hover over to first image
3.Assert: a.“name: user1” is displayed
4.Hover over to second image
5.Assert: a.“name: user2” is displayed
6.Hover over to third image
7.Confirm: a.“name: user3” is displayed
 */
public class Tc15_Hover_Test {


    @Test

    public void hoverTest(){
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");

        BrowserUtils.sleep(2);
        WebElement user1 = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[1]"));
        user1.click();
        Assert.assertTrue(user1.isDisplayed());

 BrowserUtils.sleep(2);
        WebElement user2 = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[2]"));
        user2.click();
        Assert.assertTrue(user2.isDisplayed());

 BrowserUtils.sleep(3);
        WebElement user3 = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[3]"));
        user3.click();
        Assert.assertTrue(user3.isDisplayed());



    }
}