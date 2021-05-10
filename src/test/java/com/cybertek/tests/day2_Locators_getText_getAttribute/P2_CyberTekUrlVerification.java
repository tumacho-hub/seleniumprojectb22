package com.cybertek.tests.day2_Locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_CyberTekUrlVerification {
    public static void main(String[] args) {
//
//        TC #2: Cybertek practice tool verifications
        // setup the browser
        WebDriverManager.chromedriver().setup();

//1. Open Chrome browser -> set browser driver
        WebDriver driver = new ChromeDriver();

//     make sure to maxima the page
        driver.manage().window().maximize();

        //2. Go to https://practice.cybertekschool.com
        driver.get("http://practice.cybertekschool.com");

//3. Verify URL contains
// Expected: cybertekSchool
        String expectedInUrl ="cybertekschool";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedInUrl)){
            System.out.println("URL verification FAILED");
        }


//4. Verify title:
// Expected: Practice
//
//

    }
}
