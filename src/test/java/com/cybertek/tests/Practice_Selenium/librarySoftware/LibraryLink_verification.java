package com.cybertek.tests.Practice_Selenium.librarySoftware;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
Task#1: Librarysoftware link verification
1.Open browser
2.Go to website: http://library2.cybertekschool.com/login.html
3.Enter username: “”
4.Enter password: “”
5.Click to Login button
6.Print out count of all the links on landing page
7.Print out each link text on this page
username                 password
student11@library        tScBPCUr
student12@library        UC0LC9Hj
student13@library        zcVbvUWH
librarian13@library      9rf6axdD
 */
public class LibraryLink_verification {
    WebDriver driver;
    @BeforeMethod
    public void setupWindow(){
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://library2.cybertekschool.com/login.html");
    }
    @Test
    public void windowTest(){

        BrowserUtils.sleep(2);
     driver.findElement(By.xpath("//label[@for='inputEmail']")).click();
     driver.findElement(By.xpath("//label[@for='inputEmail']")).sendKeys("student11@library");

       driver.findElement(By.xpath("//label[@for='inputPassword']")).click();
       driver.findElement(By.xpath("//label[@for='inputPassword']")).sendKeys("tScBPCUr");


        driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']")).click();



    }


}
