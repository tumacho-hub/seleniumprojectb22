package com.cybertek.tests.day2_Locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_ZeroBankHeaderTextVerification {
    public static void main(String[] args) {
        /*
        1- zero bank header verification
        first.. open chrome browser
        2- go to http://zero.webappsecurity.com/login.html
        3- verify header text
        Expected:"log in to ZeroBank"
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");

        String expectedHeader = "Log in to ZeroBank";

  //      3- verify header text
        //        Expected:"log in to ZeroBank"
//     step one -- locate the web element
//   step two --  get the text of it using getText()  method
        WebElement actualHeader = driver.findElement(By.tagName("h3"));

   String actualHeaderText = actualHeader.getText();
      //  String actualHeader = driver.findElement(By.tagName("h3")).getText();

        if (actualHeaderText.equals(expectedHeader)){
            System.out.println("Header verification PASSED");
        }else {
            System.out.println("Header verification FAILED");
        }




    }
}
