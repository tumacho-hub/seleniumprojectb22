package com.cybertek.tests.day2_Locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationAndTitleVerification {
    public static void main(String[] args) {
        /*
         1-  Open a chrome browser
         2- go to https://google.com
         3- click to gmail from top right
         4-  verify tittle contains
          Expected: GMAIL
          5- go back to google by using the back();
          6- verified title equals:
          Expected: Google.

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        //  3- click to gmail from top right
        // locating the web element and click!
         driver.findElement(By.linkText("Gmail")).click(); /// example of LINKTEXT
      // #2 Locator ! partialLinkText driver.findElement(By.partialLinkText("mail")); // EX.of partial.linktext


        //4- verify tittle contains
        //Expected: GMAIL
        String expectedInTitle = "Gmail";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedInTitle)){
            System.out.println("Title verification PASSED");
        }else{
            System.out.println("Title verification FAILED");
        }

        // go back to google by using the back
        driver.navigate().back();

        String expectedGoogleTitle = "Google";
        String actualGoogleTitle = driver.getTitle();

        if (actualGoogleTitle.equals(expectedGoogleTitle)){
            System.out.println("Tile verification PASSED");
        }else{
            System.out.println("Title verification FAILED");
        }

    }
}

