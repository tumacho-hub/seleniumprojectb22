package com.cybertek.tests.day1_selenium_intro.Practice_Task;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Cybertek_practice_tool_verification {

    /*
    TC #2: Cybertekpractice toolverifications
    1.Open Chrome browser
    2.Go to https://practice.cybertekschool.com
    3.Verify URL containsExpected: cybertekschool
    4.Verify title: Expected: Practice
     */

    WebDriver driver;
    @BeforeMethod
    public void setupDriver(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com");
    }
    @Test
    public void windowTest(){
        String title = driver.getTitle();
        System.out.println(title);

    }
}
