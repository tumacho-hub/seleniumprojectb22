package com.cybertek.tests.Nadir_Project;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NegativeCaseScenarios {

    @Test()
    public void negativeTest1(){

        Driver.getDriver().get("https://qa3.vytrack.com/user/login");

        Driver.getDriver().getTitle();

        String title = "Login";

        Assert.assertTrue(title.contains(Driver.getDriver().getTitle()));

    }
    @Test()
    public void negativeCase2(){

        Driver.getDriver().get("https://qa3.vytrack.com/user/login");

        WebElement userNameInput = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']"));
        userNameInput.sendKeys("user153");

        WebElement passwordInput = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordInput.sendKeys("Useruser123");


        WebElement logIn = Driver.getDriver().findElement(By.xpath("//button[@id='_submit']"));
        BrowserUtils.sleep(1);
        logIn.click();

        WebElement expectedResult = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']"));

        String result = expectedResult.getText();
        String actualResult = "Invalid user name or password.";

       Assert.assertTrue(actualResult.contains(result));



    }
    @Test
    public void negativeTestCase3(){

        Driver.getDriver().get("https://qa3.vytrack.com/user/login");

        WebElement userNameInput = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']"));
        userNameInput.sendKeys("userr153");

        WebElement passwordInput = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordInput.sendKeys("UserUser123");

        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@id='_submit']"));
        BrowserUtils.sleep(1);
        loginButton.click();


        WebElement result = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']"));

        String expectedExpectedResult = result.getText();
        String actualResult = "Invalid user name or password.";

        Assert.assertEquals(actualResult,expectedExpectedResult);

    }

}
