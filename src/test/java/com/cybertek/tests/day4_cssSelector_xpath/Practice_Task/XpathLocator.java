package com.cybertek.tests.day4_cssSelector_xpath.Practice_Task;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class XpathLocator {
    /*
    TC #6: XPATH LOCATORpractice
    1. Open Chrome browser
    2. Go to http://practice.cybertekschool.com/multiple_buttons
    3. Click on Button 1
    4. Verify text displayed is as expected:
    Expected:“Clicked on button one!”
     */
    WebDriver driver;
    @BeforeMethod
    public void setupDriver(){
        driver = WebDriverFactory.getDriver("Chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get("http://practice.cybertekschool.com/multiple_buttons");

        }
        @Test
    public void windowTest(){
            WebElement button = driver.findElement(By.xpath("//button[@onclick='button1()']"));
            button.click();

            WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

            String expectedTitle = "Clicked on button one!";
            String actualTitle = resultText.getText();

            System.out.println(actualTitle);

    }
}
