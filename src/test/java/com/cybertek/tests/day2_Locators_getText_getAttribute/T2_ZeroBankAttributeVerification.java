package com.cybertek.tests.day2_Locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_ZeroBankAttributeVerification {
    public static void main(String[] args) {
/*
TC #2: Zero Bank link text verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify link text from top left:
Expected: “Zero Bank”
4. Verify link href attribute value contains:
Expected: “index.html”
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");
// locate the link and store inside of webElement
        WebElement zeroBankLink = driver.findElement(By.className("brand"));
/* all of the below is locating web element
Web element zeroBankLink = driver.findElement(By.linkText("zero Bank");
Web element zeroBankLink =  driver.findElement(By.tagName("a");
        */
 //3 verify link text from top left:
 //Expected: "Zero Bank"

        String expectedLinkText = "Zero Bank";
        String actualLinkText = zeroBankLink.getText();
// driver.findElement(BY.className("brand")).getText();

        if (actualLinkText.equals(expectedLinkText)){
            System.out.println("Link text verification PASSED");
        }else {
            System.out.println("Link text verification FAILED");
        }
// 4- verify link href attribute value contains:
            // Expected: "index.HTML"

            String expectedInHrefValue = "index.html";
            String actualHrefValue = zeroBankLink.getAttribute("href");

            if (actualHrefValue.contains(expectedInHrefValue)){
                System.out.println("HREF attirbute value verification PASSED");
            }else{
                System.out.println("HREF attribute value verification FAILED");
            }




        }


    }

