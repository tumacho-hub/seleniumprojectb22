package com.cybertek.tests.day4_cssSelector_xpath.Practice_Task;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Xpath_Css_Selectors {
    /*
    TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
    1. Open Chrome browser
    2. Go to http://practice.cybertekschool.com/forgot_password
    3. Locate all the WebElements on the page using XPATH and/or CSSlocator only (total of 6)
    a. “Home” link
    b. “Forgot password” header
    c. “E-mail” text
    d. E-mail input box
    e. “Retrieve password” button
    f. “Powered byCybertek School” text
    4. Verify all WebElements are displayed.
     */

    WebDriver driver;
    @BeforeMethod
    public void setupDriver(){
             driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15 , TimeUnit.SECONDS);
            driver.get("http://practice.cybertekschool.com/forgot_password");
        }
@Test
    public void windowTest(){
//3. Locate all the WebElements on the page using XPATH and/or CSSlocator only (total of 6)
//    a. “Home” link
    WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
 //    b. “Forgot password” header the best option here is to find the Web element by tag since
    // we don't have to many options
    WebElement ForgotPassword = driver.findElement(By.tagName("h2"));
//    c. “E-mail” text
    WebElement emailText = driver.findElement(By.xpath("//label[@for='email']"));
//    d. E-mail input box
    WebElement emailInputBox = driver.findElement(By.xpath("//input[@type='text']"));
//    e. “Retrieve password” button
    WebElement RetrievePasswordButton = driver.findElement(By.xpath("//button[@id='form_submit']"));
//    f. “Powered byCybertek School” text
    WebElement poweredBycybertek = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

    System.out.println("homeLink.isDisplayed() = " + homeLink.isDisplayed());
    System.out.println("ForgotPassword.isDisplayed() = " + ForgotPassword.isDisplayed());
    System.out.println("emailText.isDisplayed() = " + emailText.isDisplayed());
    System.out.println("emailInputBox.isDisplayed() = " + emailInputBox.isDisplayed());
    System.out.println("RetrievePasswordButton.isDisplayed() = " + RetrievePasswordButton.isDisplayed());
    System.out.println("poweredBycybertek.isDisplayed() = " + poweredBycybertek.isDisplayed());


}

        }


