package com.cybertek.tests.day9_properties_browser_utils;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.LibraryUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P1_Library_Login {
    /*


    username          password
    student11@library
    student12@library UC0LC9Hj
    student13@library zcVbvUWH
    librarian13@library 9rf6axdD

    Task#2:
    •Create a method called loginToLibraryin the same java class with the @Test
    •This method simply logs in to Library appwhen you call it.
    Task#3:
    •Create a new class under ‘utilities’packagenamed “LibraryUtilities”
    •MoveloginToLibrarymethod from the same java class to “LibraryUtilities”
    •Overcome the challenge so it works when you call from the other class.
     */

    WebDriver driver;
    @BeforeMethod
            public void setupMethod(){
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://library2.cybertekschool.com/login.html");

    }
    @Test
    public void login_link_count_test(){

//    Task#1: Library software link verification
//    1.Open browser
//    2.Go to website: http://library2.cybertekschool.com/login.html
//    3.Enter username:""
//        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='inputEmail']"));
//        inputUsername.sendKeys("student11@library");
//    4.Enter password:""
//        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='inputPassword']"));
//        inputPassword.sendKeys("tScBPCUr");

//    5.Click to Login button

//        WebElement loginButton = driver.findElement(By.xpath("//button[.='Sign in']"));
//        loginButton.click();
//    6.Print out count of all the links on landing page
        // because we are locating all the webElements in this step we need to use the ArrayList
        //// "//body//a" this will locate all the links in the page
        // in here we just calling our method that already replace the previous lines.
 //       loginToLibrary();
        LibraryUtils.loginToLibrary(driver);
        BrowserUtils.sleep(3);
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
        System.out.println("allLinks.size() = " + allLinks.size());


//    7.Print out each link text on this page

        for (WebElement each : allLinks){
            System.out.println(each.getText());
        }
    }

}
