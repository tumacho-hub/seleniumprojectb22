package com.cybertek.tests.day2_Locators_getText_getAttribute.Practice_Task;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FaceBook_Incorrect_Login {
    /*
    TC #2: Facebook incorrect login title verification
    1.Open Chrome browser
    2.Go to https://www.facebook.com
    3.Enter incorrect username
    4.Enter incorrect password
    5.Verify title changed to: Expected: “Log into Facebook”
     */

    WebDriver driver;

    @BeforeMethod
    public void setupDriver(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");


    }
    @Test
    public void windowTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("yoyoyo123" + Keys.ENTER);
        Thread.sleep(8000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("tuyonomas123" + Keys.ENTER);
        String expectedTitle = "Log into Facebook";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Expected title verification Passed");
        }else{
            System.out.println("Expected verification failed");
        }


    }
}
