package com.cybertek.Office_Hours.day4;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import com.cybertek.utilities.officeHoursUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
In this task we will handle alerts, we will create a method that can be used in our test case for repeated actions. Try to stick to DRY (don't repeat yourself) concept.
If something is repeating try to create a solution for that.
 You have to implement the following Web automated checks over our (Adifas) DEMO ONLINE SHOP: https://www.demoblaze.com/index.html
• Customer navigation through product categories: Phones, Laptops and Monitors
• Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
• Navigate to "Phones" → "Samsung galaxy s6" and click on "Add to cart". Accept pop up confirmation.
• Navigate to "Monitors" → "Apple monitor 24" and click on "Add to cart". Accept pop up confirmation.
• Navigate to "Cart" → Delete "Apple monitor 24" from cart.
• Click on "Place order".
• Fill in all web form fields.
• Click on "Purchase"
• Capture and log purchase Id and Amount.
• Assert purchase amount equals expected.
• Click on "Ok"
 */
public class finArtz {

    WebDriver driver;
    String browser = ConfigurationReader.getProperty("browser");
    String addUserUrl = ConfigurationReader.getProperty("finArtzAddUserUrl");
    String loginUrl = ConfigurationReader.getProperty("finArtzLoginUrl");

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test
    public void liginTests(){
        // Adding user  test

        officeHoursUtils.addUserTest(driver,addUserUrl);
        BrowserUtils.sleep(5);

        // Positive Login Test
        Assert.assertTrue(officeHoursUtils.positiveLoginTest(driver,loginUrl));
        BrowserUtils.sleep(1);
        // Negative Login test

        Assert.assertTrue(officeHoursUtils.negativeLoginTests(driver,loginUrl));


    }
    @Test
    public void textTests(){
        driver.get(loginUrl);
        String expectedTab = "Login example page to test the PHP MySQL online system";
        String actualTab = driver.getTitle();
        Assert.assertEquals(actualTab,expectedTab);

        String actualHeader = driver.findElement(By.xpath("(//strong)[3]")).getText();
        String expectedHeader = "4. Login";
        Assert.assertEquals(actualHeader,expectedHeader);

        String expectedFuunyText = "Enter your login details you added on the previous page and test the login.\n" +
                "The success or failure will be shown above.";
        String actualText = driver.findElement(By.xpath("//p[contains(.,'login details you added')]")).getText();
        Assert.assertEquals(actualText,expectedFuunyText);
    }
    @AfterMethod
    public void tearDown(){
        BrowserUtils.sleep(3);
        driver.close();
    }

}
