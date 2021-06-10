package com.cybertek.tests.day4_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P1_cssSelector_Cybertek {
/*
TC #3: PracticeCybertek/ForgotPassword URL verification
1.Open Chrome browser
2.Go to http://practice.cybertekschool.com/forgot_password
3.Enter any email into input box
4.Click on Retrieve password
5.Verify URL contains: Expected: “email_sent”
6.Verify textbox displayed the content as expected.
Expected: “Your e-mail’s been sent!”
 */

    public static void main(String[] args) {
        // TC #1 : PraticeCybertek.com_ForgotPassword WebElement verification
        // 1. Open Chrome Browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2. go to htpp://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS locator only
        //a. "Home" link
        WebElement homeLink = driver.findElement(By.cssSelector("a[class='nav-link']"));

        //b. "forgot password" header
        // just the tag itself nothing else
        WebElement ForgotPasswordHeader = driver.findElement(By.tagName("h2"));

        //c. "Email" text
        WebElement emailTextHeader = driver.findElement(By.cssSelector("[for='email']"));
        // d. email input box

        WebElement emailInput = driver.findElement(By.cssSelector("input[name='email']"));
        //e, "Retrieve Password" button

        WebElement retrievePasswordButton = driver.findElement(By.cssSelector("button[id='form_submit']"));
        //.f "Powered by Cybertek School" text

        WebElement powerByCyberTekSchool = driver.findElement(By.cssSelector("div[style='text-align: center;']"));
        //4. Verified all web elements are displayed.

        System.out.println("homeLink.isDisplayed() = " + homeLink.isDisplayed());

        System.out.println("ForgotPasswordHeader.isDisplayed() = " + ForgotPasswordHeader.isDisplayed());
        System.out.println("emailTextHeader.isDisplayed() = " + emailTextHeader.isDisplayed());
        System.out.println("emailInput.isDisplayed() = " + emailInput.isDisplayed());
        System.out.println("retrievePasswordButton.isDisplayed() = " + retrievePasswordButton.isDisplayed());
       System.out.println("powerByCyberTekSchool.isDisplayed() = " + powerByCyberTekSchool.isDisplayed());


    }
}
