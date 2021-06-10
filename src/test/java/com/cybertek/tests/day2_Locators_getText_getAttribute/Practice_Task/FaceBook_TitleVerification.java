package com.cybertek.tests.day2_Locators_getText_getAttribute.Practice_Task;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FaceBook_TitleVerification {
  //  TC #1: Facebook title verification1.Open Chrome browser
    //  2.Go to https://www.facebook.com
    //  3.Verify title: Expected: “Facebook -Log In or Sign Up”

    WebDriver driver;
     @BeforeMethod
    public void setupDriver(){

         driver = WebDriverFactory.getDriver("Chrome");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         driver.get("https://www.facebook.com");
     }
     @Test
     public void window_Test(){
         WebElement verifyTitle = driver.findElement(By.xpath("//html[@id='facebook']"));

         System.out.println("Expected Title = " + driver.getTitle() );




     }

}
