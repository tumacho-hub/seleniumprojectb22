package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartBearUtils {

    public static void SmartBear(WebDriver driver){

        WebElement inputUserName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        inputUserName.sendKeys("Tester");

        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        inputPassword.sendKeys("test");

        BrowserUtils.sleep(1);
        WebElement logIn = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$login_button']"));
        logIn.click();
    }
}
