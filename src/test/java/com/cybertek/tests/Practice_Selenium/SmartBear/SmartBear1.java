package com.cybertek.tests.Practice_Selenium.SmartBear;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*
TC #1: Smartbear software link verification
1.Open browser
2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3.Enter username: “Tester”
4.Enter password: “test”
5.Click to Login button
6.Print out count of all the links on landing page
7.Print out each link text on this page
Mini-Task:CREATE A CLASS àSmartBearUtils
•Create a method called loginToSmartBear
•This method simply logs in to SmartBear when you call it.
•Accepts WebDriver type as parameter
 */
public class SmartBear1 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

       driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

    }
@Test
    public void windowTest() {

    WebElement inputUserName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
    inputUserName.sendKeys("Tester");

    WebElement inputPassword = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
    inputPassword.sendKeys("test");

    BrowserUtils.sleep(1);
    WebElement logIn = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$login_button']"));
    logIn.click();

    List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

    System.out.println(allLinks.size());

    for (WebElement each : allLinks) {
        System.out.println(each.getText());



    }
}
}
