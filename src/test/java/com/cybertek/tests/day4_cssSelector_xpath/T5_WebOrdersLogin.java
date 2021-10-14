package com.cybertek.tests.day4_cssSelector_xpath;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5_WebOrdersLogin {


    public static void main(String[] args) {
        /*
        TC#5: Basic login authentication
        1-Open a chrome browser
        2-Go to: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx3
        Verify
        title equals:Expected: Web Orders
        Login4-Enter username: Tester5-Enter password:
        test6-Click “Sign In” button7-Verify titleequals:
        Expected: Web Orders
         */
//        WebDriverManager.chromedriver().setup();
//      WebDriver driver =  new ChromeDriver();

        WebDriver driver = WebDriverFactory.getDriver("chrome");

// #2 go to =>
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx3");

// #3 verify title equals:
// Expected: Web orders login
        String expectedTitle = "Web Order login";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Login page title verification Passed!");
        } else {
            System.out.println("Login page title verification Failed");

            // Enter username: tester
            WebElement inputUserName = driver.findElement(By.id("ctl00_MainContent_username"));
            inputUserName.sendKeys("Tester");
// 5- enter password: test
            WebElement inputPassword = driver.findElement(By.id("ctl00_MainContent_password"));
            inputPassword.sendKeys("test");
// 6- click "sing in" button
            WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
            loginButton.click();

            // 7- Verified title equals:
// Expected: web orders
            String expectedHomeTitle = "Web Orders";
            String actualHomePageTitle = driver.getTitle();

            if (actualHomePageTitle.equals(expectedHomeTitle)) {
                System.out.println("Home page title verification PASSED");
            } else {
                System.out.println("Home page title verification FAILED");
            }


        }


    }
}

