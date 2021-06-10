package com.cybertek.tests.Practice_Selenium.P1_Xpath_Practice_1;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P05_P06_checkbox_Task {
    /*
    TC #2: SeleniumEasy CheckboxVerification–Section 1
    1.Open Chrome browser
    2.Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
    3.Verify “Success –Check box is checked” message is NOTdisplayed.
    4.Click to checkbox under “Single Checkbox Demo” section
    5.Verify “Success –Check box is checked” message isdisplayed.
      */
    WebDriver driver;
    @BeforeMethod
    public void setupDriver(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");


        }
        @Test
        public void windowTest() throws InterruptedException {
        //3.Verify “Success –Check box is checked” message is NOTdisplayed. message

            WebElement checkBox = driver.findElement(By.xpath("//div[@style='display: block;']"));
            Thread.sleep(1000);
            checkBox.click();


        }
}
