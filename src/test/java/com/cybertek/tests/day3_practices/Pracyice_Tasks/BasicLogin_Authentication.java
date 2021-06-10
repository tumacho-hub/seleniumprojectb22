package com.cybertek.tests.day3_practices.Pracyice_Tasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BasicLogin_Authentication {
    /*
    TC#5: Basic login authentication
    1-Open a chrome browser
    2-Go to: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    3-Verify title equals:Expected: Web Orders Login
    4-Enter username: Tester
    5-Enter password: test
    6-Click “Sign In” button
    7-Verify titleequals:
    Expected: Web Orders
     */
    WebDriver driver;

    @BeforeMethod
    public void setupDriver(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }
    @Test
    public void windowTest() throws InterruptedException {
  // 3-Verify title equals:Expected: Web Orders Login
        String expectedTitle = "Web Orders Login";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
       if (actualTitle.equals(expectedTitle)){
           System.out.println("Verification test Passed");
       }else{
           System.out.println("Verification test failed");
       }
//  4-Enter username: Tester
        Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']")).sendKeys("Tester");
//5-Enter password: test
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']")).sendKeys("test");
//6-Click “Sign In” button
      WebElement button =  driver.findElement(By.xpath("//input[@type='submit']"));
       button.click();
//7-Verify titleequals:     Expected: Web Orders
        String expectedTitleEquals = "Web Orders";
        String actualTitle2 = driver.getTitle();
        System.out.println(actualTitle2);
        if (actualTitle2.equals(expectedTitleEquals)){
            System.out.println("Title verification #2 Passed");
        }else{
            System.out.println("Title verification Failed");
        }


    }
}
