package com.cybertek.Office_Hours.day02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ZeroBankAccountActivity1 {
    /*
    2nd of June Office Hours Task: Scenario: Checking the account activity page features of ZeroBank Application

1. The user navigates to the login page: http://zero.webappsecurity.com/login.html
2. The user logs in with the user "username" and the password "password"
3. The user navigates to Account Activity page
4. Then The page should have the title "Zero - Account Activity"
5. Then Account drop down should have the following options :
(Savings, Checking, Savings, Loan, Credit Card, Brokerage)
6. Brokerage option should have "No results.
     */
    WebDriver driver;
    @BeforeClass
    public void setupDriver(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/login.html");

         // logIn credentials

        driver.findElement(By.cssSelector("[id*='user_login']")).sendKeys("username");
        driver.findElement(By.cssSelector("[id*='user_pass']")).sendKeys("password");
        driver.findElement(By.cssSelector("[type*='sub']")).click();
        driver.findElement(By.cssSelector("[id*=primary-']")).click();
    //    driver.findElement(By.cssSelector("[id*='[id*=primary-button']")).click();


    }
    @Test
    public void accountActivity(){
        //
        driver.findElement(By.id("account_activity_link")).click();

String expectedTitle = "Zero - Account Activity";
String actualTitle = driver.getTitle();

// always actualTitle
        Assert.assertEquals(actualTitle, expectedTitle, "Title check");
        // Then Account drop down should have the following options :
        //(Savings, Checking, Savings, Loan, Credit Card, Brokerage)

        List<String> expectedOptions =new ArrayList<>(Arrays.asList("Savings","Checking", "Savings","Loan","Credit Card", "Brokerage"));

        Select accountsDropDown = new Select(driver.findElement(By.id("aa_accountId")));
        List<WebElement> actualOptions = accountsDropDown.getOptions();
        List<String> actualOptionsText =  new ArrayList<>();

        //  for each loop //(iter shortcut)
        for (WebElement actualOption : actualOptions) {
            actualOptionsText.add(actualOption.getText());


        }
//        System.out.println("expectedOptions = " + expectedOptions);
//        System.out.println("actualOptions = " + actualOptions);
//        System.out.println("actualOptionsText = " + actualOptionsText);

        Assert.assertEquals(actualOptionsText,expectedOptions,"verify  account options");

        accountsDropDown.selectByVisibleText("Brokerage");

        String expectedText = "No results.";
        String actualText =  driver.findElement(By.xpath("//div[@class='well']")).getText();

        Assert.assertEquals(actualText,expectedText,"verify result text");

    }

    @AfterClass
    public void tearDownClass() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
