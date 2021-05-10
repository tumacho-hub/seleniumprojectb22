package com.cybertek.tests.day_1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CybertekPractice {

    public static void main(String[] args) {
/*
TC #2: Cybertek practice tool verifications
1. Open Chrome browser
2. Go to https://practice.cybertekschool.com
3. Verify URL contains
Expected: cybertekschool
4. Verify title:
 Expected: Practice
 */
         // 1 - Chrome browser
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize(); // this will maximize the entire window!

        driver.get("http://practice.cybertekschool.com");

        driver.getTitle();

        System.out.println("Current title: " + driver.getTitle());

        String  currentUrl = driver.getCurrentUrl(); //  this line will get Url for us

        System.out.println("currentUrl: " + currentUrl);









    }
}
