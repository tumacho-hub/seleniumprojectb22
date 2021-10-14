package com.cybertek.tests.day2_Locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class p4_googleSearchVerification {
    public static void main(String[] args) {
        /*
        1- open google chrome browser
        2- got to htpps//google.com
        3- write "apple" in search box
        4- click google search button
        5- verify title
        expected  title should start with "apple" word
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        // 3- write "apple" in search box // #4 click google search button is ont the last step Keys.ENTER);
        driver.findElement(By.name("q")).sendKeys("apple"+ Keys.ENTER);

// 5- verify title expected  title should start with "apple" word
        String expectedInTitle = "apple";
        String actualTittle = driver.getTitle();

        if (actualTittle.startsWith(expectedInTitle)){
            System.out.println("Title verification is PASSED ");
        }else{
            System.out.println("Title verification FAILED");
        }



    }
}
